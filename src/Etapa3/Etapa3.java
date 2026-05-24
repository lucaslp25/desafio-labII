package Etapa3;

public class Etapa3 {

    public boolean checkBrackets(Stack<Character> s1) {

        int contadorParenteses = 0;

        // enquanto a pilha não estiver vazia, continua
        while (!s1.isEmpty()) {
            try {
                char caractereAtual = s1.pop();

                // achou ')', aumenta o contador
                if (caractereAtual == ')') {
                    contadorParenteses++;
                }
                // achou '(', decrementa o contador
                else if (caractereAtual == '(') {
                    contadorParenteses--;
                }

                // se no final o contador ficar negativo, é porque a expressão é inválida
                if (contadorParenteses < 0) {
                    return false;
                }

            } catch (UnderflowException e) {
                System.out.println("Erro: tentativa de remover de uma pilha vazia.");
            }
        }

        // se fechar em 0 no final, ele será true
        return contadorParenteses == 0;
    }
}