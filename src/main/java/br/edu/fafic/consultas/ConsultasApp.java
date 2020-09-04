package br.edu.fafic.consultas;

import br.edu.fafic.persistence.JpaPersistence;

public class ConsultasApp {

	public static void main(String[] args) {
		
		JpaPersistence jpaPersistence = new JpaPersistence();

		//Consulta jogador por nome
//		System.out.println("Jogador: " + jpaPersistence.pessoaByNome("GutinTerraQuente"));
		
		//Consulta jogador por status
//		System.out.println("Jogadodr por status: " + jpaPersistence.jogadorByStatus(1));
		
		//consulta jogador por Time
//		System.out.println("Jogadores do Time: " + jpaPersistence.tim("Flamengo"));//erro na consulta aqui é teste
		
		//consulta jogadores por time
//		System.out.println("Jogadores do time: " + jpaPersistence.timeByNome("Flamengo"));
		
		//consulta tecnico por nome:
//		System.out.println("tecnico: " + jpaPersistence.pessoaByNome("buiu"));
		
		//consulta campeonato por equipe
//		System.out.println("Participantes do campeonato: " + jpaPersistence.timeByCampeonato("carioca"));//consulta incompleta da erro de loop no toString de campeonato e time, ela busca todos os dados dos times ligados ao campeonato e não só o nome dos times
	}
}
