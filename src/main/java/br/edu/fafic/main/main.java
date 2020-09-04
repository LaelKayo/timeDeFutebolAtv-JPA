package br.edu.fafic.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import br.edu.fafic.domain.Campeonato;
import br.edu.fafic.domain.Jogador;
import br.edu.fafic.domain.Tecnico;
import br.edu.fafic.domain.Time;
import br.edu.fafic.enun.Status;
import br.edu.fafic.persistence.JpaPersistence;

public class main {

	public static void main(String[] args) {

		JpaPersistence persistence = new JpaPersistence();

//		//criando joagador
//		Jogador jogador1 = new Jogador();
//		jogador1.setNome("GutinTerraQuente");
//		jogador1.setStatus(Status.TITULAR);
//		jogador1.setPosicao("Goleiro");
//		//jogador1.setJogaEm((Time)persistence.findById(Time.class, 1l));
//		persistence.save(jogador1);
//		
//		//criando Tecnico
//		Tecnico tecnico1 = new Tecnico();
//		tecnico1.setNome("Buiu");
//		persistence.save(tecnico1);
//		
//		//criando Time
//		Time time1 = new Time();
//		time1.setNome("Flamengo");
//		time1.setJogadores(Arrays.asList((Jogador)persistence.
//				findById(Jogador.class, 1l)));
//		time1.setTecnicoTime((Tecnico)persistence.findById(Tecnico.class, 2l));
//		persistence.save(time1);
//		
//		//criando campeonato
//		Campeonato campeonato1 = new Campeonato();
//		campeonato1.setNomeCampeonato("Carioca");
//		campeonato1.setTimes(Arrays.asList((Time)persistence.
//				findById(Time.class, 1l)));
//		campeonato1.setDataInicial(new Date());
//		campeonato1.setDataFinal(new Date());
//		persistence.save(campeonato1);
//		
//		//Updade de tecnico para time
//		Tecnico t1 = (Tecnico)persistence.findById(Tecnico.class, 2l);
//		t1.setTreinaTime((Time)persistence.findById(Time.class, 1l));
//		persistence.update(t1);
		
//		//update de time no campeonato
//		Time t1 = ((Time)persistence.findById(Time.class, 1l));
//		t1.setCampeonatos(Arrays.asList((Campeonato)persistence.findById(Campeonato.class, 1l)));
//		persistence.update(t1);
//		
//		//update de jogador para time
//		Jogador j1 = (Jogador)persistence.findById(Jogador.class, 1l);
//		j1.setJogaEm((Time)persistence.findById(Time.class, 1l));
//		persistence.update(j1);
	}
}
