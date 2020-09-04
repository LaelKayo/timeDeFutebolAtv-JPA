package br.edu.fafic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = "timeByNome", query = "SELECT t FROM Time t WHERE t.nome = :nome"),
	@NamedQuery(name = "timeByJogador", query = "select t from Time t join t.jogadores j WHERE j.nome = :nome"),
	@NamedQuery(name = "timeByCampeonato", query = "SELECT t FROM Time t JOIN t.campeonatos c WHERE c.nomeCampeonato = :nome")
})
public class Time implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.MERGE)
	private List<Jogador> jogadores;

	@OneToOne
	private Tecnico tecnicoTime;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "campeonato_time",
		joinColumns = {
			@JoinColumn(name = "campeonato_id")},
		inverseJoinColumns = {
				@JoinColumn(name = "times_id")})
	private List<Campeonato> campeonatos;

	private String nome;

	public Time() {

	}

	public Time(List<Jogador> jogadores, Tecnico tecnicoTime, List<Campeonato> campeonatos, String nome) {
		this.jogadores = jogadores;
		this.tecnicoTime = tecnicoTime;
		this.campeonatos = campeonatos;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	
	public List<Jogador> getJogadores() {
		if(jogadores == null) {
			jogadores = new ArrayList<Jogador>();
		}
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Tecnico getTecnicoTime() {
		return tecnicoTime;
	}

	public void setTecnicoTime(Tecnico tecnicoTime) {
		this.tecnicoTime = tecnicoTime;
	}

	public List<Campeonato> getCampeonatos() {
		if(campeonatos == null) {
			campeonatos = new ArrayList<Campeonato>();
		}
		return campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "\n"+ 
				"Time: " + nome + "\n" + 
				"TecnicoTime: " + tecnicoTime.getNome() + "\n" + 
				"Lista de Campeonatos: "+  campeonatos + "\n" + 
				"Jogadores: " + jogadores + "\n";
	}
}
