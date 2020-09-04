package br.edu.fafic.domain;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "campeonatoByEquipes", query = "SELECT c FROM Campeonato c WHERE c.nomeCampeonato = :nome")
})
public class Campeonato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(mappedBy = "campeonatos")
	private List<Time> times;

	@Temporal(TemporalType.DATE)
	private Date dataInicial;

	@Temporal(TemporalType.DATE)
	private Date dataFinal;
	
	private String nomeCampeonato;

	public Campeonato() {

	}

	public Campeonato(List<Time> times, Date dataInicial, Date dataFinal, String nomeCampeonato) {
		this.times = times;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.nomeCampeonato = nomeCampeonato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Time> getTimes() {
		if(times == null) {
			times = new ArrayList<Time>();
		}
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	@Override
	public String toString() {
		return 	"\n" +
				"Campeonato: " + nomeCampeonato + "\n" +
				"Data Inicial: " + dataInicial + "\n" +
				"Data Final: " + dataFinal + "\n";
	}
}
