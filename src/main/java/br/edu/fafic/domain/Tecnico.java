package br.edu.fafic.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tecnico extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Time treinaTime;

	public Tecnico() {
		
	}

	public Tecnico(Time treinaTime) {
		this.treinaTime = treinaTime;
	}
	
	public Long getId() {
		return id;
	}

	public Time getTreinaTime() {
		return treinaTime;
	}

	public void setTreinaTime(Time treinaTime) {
		this.treinaTime = treinaTime;
	}

	@Override
	public String toString() {
		return "Tecnico "+ super.getNome() + "treinaTime=" + treinaTime + "]";
	}
}
