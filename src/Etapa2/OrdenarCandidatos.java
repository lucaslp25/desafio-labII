package Etapa2;

import java.util.Arrays;

public class OrdenarCandidatos {

    public static void ordenaCandidatosPorNome(Candidato[] candidatos){

        for (int i = 0; i < candidatos.length - 1; i++) {
            for (int j = 0; j < candidatos.length - i - 1; j++) {
                if (candidatos[j].getNome().compareToIgnoreCase(candidatos[j+1].getNome()) > 0) {
                    Candidato temp = candidatos[j];
                    candidatos[j] = candidatos[j+1];
                    candidatos[j+1] = temp;
                }
            }
        }
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos){
        for (int i = 0; i < candidatos.length - 1; i++) {
            for (int j = 0; j < candidatos.length - i - 1; j++) {
                if (candidatos[j].getIntencoesVotos() > candidatos[j + 1].getIntencoesVotos()) {
                    Candidato temp = candidatos[j];
                    candidatos[j] = candidatos[j+1];
                    candidatos[j+1] = temp;
                }
            }
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos){
        for (int i = 0; i < candidatos.length - 1; i++) {
            for (int j = 0; j < candidatos.length - i - 1; j++) {
                if (candidatos[j].getPartido().compareToIgnoreCase(candidatos[j+1].getPartido()) > 0) {
                    Candidato temp = candidatos[j];
                    candidatos[j] = candidatos[j+1];
                    candidatos[j+1] = temp;
                }
            }
        }
    }

     public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome){
        if (candidatos.length <= 0){
            return -1;
        }
        // ordena pelo nome primeiro
        ordenaCandidatosPorNome(candidatos);

        return pesquisaBinariaRecursiva(candidatos, nome, 0);
    }

    // metodo recursivo
    private static int pesquisaBinariaRecursiva(Candidato[] candidatos, String nome, int index){
        if (candidatos.length == 0){
            return -1; // não achou
        }

        int meio = candidatos.length / 2;

        int comparacao = candidatos[meio].getNome().compareToIgnoreCase(nome);

        if (comparacao == 0){
            System.out.println("INFORMAÇÕES DO CANDIDATO: \n" + candidatos[meio].toString());
            return index + meio;
        } else if (comparacao > 0) {
            // busca na esquerda
            Candidato[] temp = Arrays.copyOfRange(candidatos, 0, meio);
            return pesquisaBinariaRecursiva(temp, nome, index);
        } else {
            // busca na direita
            Candidato[] temp = Arrays.copyOfRange(candidatos, meio + 1, candidatos.length);
            return pesquisaBinariaRecursiva(temp, nome, index + meio + 1);
        }
    }

}
