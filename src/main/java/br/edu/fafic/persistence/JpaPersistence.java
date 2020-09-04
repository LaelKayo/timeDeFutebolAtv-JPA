package br.edu.fafic.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.fafic.domain.Campeonato;
import br.edu.fafic.domain.Jogador;
import br.edu.fafic.domain.Pessoa;
import br.edu.fafic.domain.Time;
import br.edu.fafic.enun.Status;

public class JpaPersistence {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploTime");
	private EntityManager em;
	
	public void save(Object object) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Object object) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
		em.close();
	}
	
	public Object findById(Class clazz, Long id) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Object o = em.find(clazz, id);
		em.getTransaction().commit();
		em.close();
		return o;
	}
	
	public Pessoa pessoaByNome(String nome) {
		em = emf.createEntityManager();
		Query query = em.createNamedQuery("pessoaByNome");
		query.setParameter("nome", nome);
		return (Pessoa) query.getSingleResult();
	}
	
	public List<Pessoa> pessoaOrderByNome(){
		em = emf.createEntityManager();
		Query query = em.createNamedQuery("pessoaOrderByNome");
		return query.getResultList();
	}
	
	public List<Jogador> jogadorByStatus (int codigo){
		em = emf.createEntityManager();
		Status status = (Status)Status.toEnum(codigo);
		Query query = em.createNamedQuery("jogadorByStatus");
		query.setParameter("status", status);
		return query.getResultList();
	}
	
	public Jogador jogadorByEquipe(String nome) {
		em = emf.createEntityManager();
		Query query = em.createNamedQuery("jogadorByEquipe");
		query.setParameter("nome", nome);
		return (Jogador) query.getSingleResult();
	}
	
	public Time timeByNome(String nome) {
		em = emf.createEntityManager();
		Query query = em.createNamedQuery("timeByNome");
		query.setParameter("nome", nome);
		return (Time) query.getSingleResult();
	}
	
	public Time timeByCampeonato(String nome) {
		em = emf.createEntityManager();
		Query query = em.createNamedQuery("timeByCampeonato");
		query.setParameter("nome", nome);
		return (Time) query.getSingleResult();
	}
	
	public Time timeByJogador(String nome) {
		em = emf.createEntityManager();
		Query query = em.createNamedQuery("timeByJogador");
		query.setParameter("nome", nome);
		return (Time) query.getSingleResult();	
	}
}