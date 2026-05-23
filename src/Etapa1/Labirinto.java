package Etapa1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {

    private final char PAREDE = 'X';
    private final char CAMINHO_ABERTO = ' ';
    private final char SAIDA = 'D';
    private final char CAMINHO_SOLUCAO = '#';

    private char[][] labirinto;

    public Labirinto(){}

    public void criaLabirinto(String filename){

        BufferedReader br = null;
        FileReader fr = null;

        try{
            // tratar exceção de nome de arquivo errado
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            List<String> linhas = new ArrayList<>();
            String line = br.readLine();

             while(line != null){
                linhas.add(line);
                line = br.readLine();
             }

             if (!linhas.isEmpty()) {
                 int qtdLinhas = linhas.size();
                 int qtdColunas = linhas.get(0).length();
                 labirinto = new char[qtdLinhas][qtdColunas];

                for (int i = 0; i < qtdLinhas; i++) {
                    labirinto[i] = linhas.get(i).toCharArray();
                }
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Arquivo não encontrado: " + filename);
        } catch (IOException e) {
            System.err.println("Erro na leitura no arquivo: " + e.getMessage());
        }
    }

    public void imprimeLabirinto(){
        if (labirinto == null) {
            System.err.println("O labirinto não foi carregado!");
        }

        for (int i = 0; i < labirinto.length; i++){
            for (int j = 0; j < labirinto[i].length; j++){
                System.out.print(labirinto[i][j]);
            }
            // quebra de linha
            System.out.println();
        }
    }

    public boolean percorreLabirinto(){
        if (labirinto == null){
            throw new RuntimeException("O Labirinto ainda não foi criado.");
        }

        //retorna o resultado da resolução do labirinto
        return resolverLabirinto(0, 0);
    }

    // [][] - linha, coluna
    public boolean resolverLabirinto(int x, int y) {

        // validação de segurança - tamanho da linha \ tamanho da coluna
         if (x < 0 || x >= labirinto.length || y < 0 || y >= labirinto[x].length) {
            return false;
        }

        if (labirinto[x][y] == SAIDA) {
            return true;
        }
        // validação para ver se é parede ou se já passou por ali
        if (labirinto[x][y] == this.PAREDE || labirinto[x][y] == CAMINHO_SOLUCAO) {
            return false;
        }

        // chegou - marcar como rastro
        labirinto[x][y] = CAMINHO_SOLUCAO;

        // tenta recursão por todos os lados para ver se acha a solução
        if (resolverLabirinto(x + 1, y)) {
            return true;
        }
        if (resolverLabirinto(x, y + 1)) {
            return true;
        }
        if (resolverLabirinto(x - 1, y)) {
            return true;
        }
        if (resolverLabirinto(x, y - 1)) {
            return true;
        }

        // se não tiver saída, desfazemos a marcação
        labirinto[x][y] = CAMINHO_ABERTO;
        return false;
    }
}

