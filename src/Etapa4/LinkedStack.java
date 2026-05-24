package Etapa4;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> topNode;
    private int size;

    public LinkedStack() {
        this.topNode = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(E element) {
        // cria o nó com o elemento
        Node<E> newNode = new Node<>(element);

        // aponta o 'next' do novo no para o antigo
        newNode.setNext(topNode);

        // atualiza o topo para ser o novo nó
        topNode = newNode;
        size++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        E elementToReturn = topNode.getElement();

        topNode = topNode.getNext();
        size--;

        return elementToReturn;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return topNode.getElement();
    }
}