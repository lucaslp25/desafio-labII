package Etapa2;

import java.util.Random;
import java.util.Scanner;

import static Etapa2.OrdenarCandidatos.*;

public class PrincipalCandidatos {
    public static void main(String[] args) {

        String[] nomes = {"Ana", "Carlos", "Beatriz", "João", "Mariana", "Pedro", "Fernanda", "Lucas"};
        String[] partidos = {"PT", "PSDB", "MDB", "PSOL", "PL", "NOVO", "PDT", "REDE"};

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        Candidato[] candidatos = new Candidato[randomNumber];

        for (int i = 0; i < randomNumber; i++) { // gera de 1 a 50 instâncias de candidatos
            String nome = nomes[random.nextInt(nomes.length)];
            String partido = partidos[random.nextInt(partidos.length)];
            int numero = random.nextInt(999) + 1;

            Candidato candidato = new Candidato(nome, partido, numero);
            candidatos[i] = candidato;
        }

        // chamando os métodos, deixo o de nome por ultimo para já ficar ordenado para busca binaria
        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);

        System.out.println("Digite o nome que deseja procurar: ");
        String nome = new Scanner(System.in).nextLine();

        int indice = pesquisaBinariaCandidatos(candidatos, nome);

        System.out.println("INDICE DO CANDIDATO: " + indice);

        StringBuilder sc = new StringBuilder();

        sc.append("""
                ===========================================================================
                         RELATÓRIO DE VOTAÇÃO
                ===========================================================================
                Nome                 Partido         Intenções de Votos
                ===========================================================================
                \n""" );
        sc.append("Candidatos ordenados por Nome: \n\n");

        for (Candidato c : candidatos){
            sc.append(c);
        }
        sc.append("\n" + "Primeiro candidato: " + candidatos[0]);
        sc.append("\n" + "Útilmo candidato: " + candidatos[candidatos.length-1]);
        sc.append("\n" + "Candidato encontrado na posição  " + indice + ": " + candidatos[indice]);

        System.out.println(sc);

    }
}
