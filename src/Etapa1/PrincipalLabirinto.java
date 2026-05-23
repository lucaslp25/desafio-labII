package Etapa1;

public class PrincipalLabirinto {
    public static void main(String[] args) {

        final String ARQ_LABIRINTO = "src/Etapa1/labirinto.txt";

        Labirinto lab = new Labirinto();
        lab.criaLabirinto(ARQ_LABIRINTO);

        boolean resultado = lab.percorreLabirinto();
        System.out.println("Solução encontrada: " + resultado + "\n");

        System.out.println("=== IMPRESSÃO DO LABIRINTO ===\n");
        lab.imprimeLabirinto();
    }
}
