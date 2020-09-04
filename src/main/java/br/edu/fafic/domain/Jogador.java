package br.edu.fafic.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import br.edu.fafic.enun.Status;

@Entity
@NamedQueries({
	@NamedQuery(name = "jogadorByStatus", query = "SELECT j FROM Jogador j WHERE j.status = :status"),
	@NamedQuery(name = "jogadorByEquipe", query = "SELECT j FROM Jogador j WHERE j.jogaEm = :jogaEm")
})
public class Jogador extends Pessoa {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.MERGE)
	private Time jogaEm;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	private String posicao;

	public Jogador() {

	}

	public Jogador(Status status, Time jogaEm, String posicao) {
		this.status = status;
		this.jogaEm = jogaEm;
		this.posicao = posicao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Time getJogaEm() {
		return jogaEm;
	}

	public void setJogaEm(Time jogaEm) {
		this.jogaEm = jogaEm;
	}
	
	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	@Override
	public String toString() {
		return 	"Jogador" + super.getNome() + "\n" +
				"Status: " + status + "\n" + 
				"Joga Em: " + jogaEm.getNome() + "\n" +
				"Posição: " + posicao;
	}
}
