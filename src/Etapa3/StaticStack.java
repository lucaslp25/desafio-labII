package Etapa3;

public class StaticStack<E> implements Stack<E> {

    private Object[] elements;
    // sempre aponta para o último elemento inserido
    private int top;

    public StaticStack(int maxSize) {
        this.elements = new Object[maxSize];
        // -1 = pilha vazia.
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == elements.length - 1;
    }

    @Override
    public int numElements() {
        return top + 1;
    }

    @Override
    public void push(E element) throws OverflowException {
        if (isFull()) {
            // erro tentar colocar em uma pilha cheia
            throw new OverflowException();
        }
        top++;
        elements[top] = element;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            // tentar tirar de uma pilha vazia
            throw new UnderflowException();
        }

        // pega o elemento do topo
        E elementoRemovido = (E) elements[top];

        // liberaração de memória
        elements[top] = null;

        top--;
        return elementoRemovido;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        // apenas retorna o elemento
        return (E) elements[top];
    }
}