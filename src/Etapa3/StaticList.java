package Etapa3;

public class StaticList<E> implements Lista<E> {

    private Object[] elements;
    private int size;

     public StaticList(int numero) {
        this.elements = new Object[numero];
        this.size = 0;
    }

    @Override
    public void insert(E obj, int index) {
        // validação
        if (index < 0 || index > size || isFull()) {
            System.out.println("Índice inválido ou lista cheia.");
            return;
        }

         for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        elements[index] = obj;
        size++;
    }

    @Override
    public E remove(int index) {
        // validação
        if (index < 0 || index >= size || isEmpty()) {
            System.out.println("Índice inválido ou lista vazia.");
            return null;
        }

        // pego o elemento que será removido
        E elementoRemovido = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        // limpa a ultima posição que ficou duplicada e diminui o tamanho
        elements[size - 1] = null;
        size--;

        return elementoRemovido;
    }

    public int contaElementos(E el) {
         return contaElementosRecursivo(el, 0);
    }

    private int contaElementosRecursivo(E el, int index) {
        // indice chegou no tamanho final da lista, nao tem mais o que contar
        if (index == size) {
            return 0;
        }

        // ve se o elemento na posição atual é o que estamos buscando
        int contagemAtual = 0;
        if (elements[index].equals(el)) {
            contagemAtual = 1; // Se achou, vale 1
        }

        // soma resultado atual com a busca no resto da lista (index + 1)
        return contagemAtual + contaElementosRecursivo(el, index + 1);
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Índice inválido.");
            return null;
        }
        // (E) para converter para o tipo original
        return (E) elements[index];
    }
}