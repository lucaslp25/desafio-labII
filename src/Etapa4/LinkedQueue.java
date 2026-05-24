package Etapa4;

public class LinkedQueue<E> implements Queue<E> {

    private Node<E> frontNode;
    private Node<E> backNode;
    private int size;

    public LinkedQueue() {
        this.frontNode = null;
        this.backNode = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return frontNode == null;
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
    public void enqueue(E element) {
        // cria o novo nó
        Node<E> newNode = new Node<>(element);

        if (isEmpty()) {
            frontNode = newNode;
            backNode = newNode;
        } else {
            backNode.setNext(newNode);
            backNode = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        E elementToReturn = frontNode.getElement();

        frontNode = frontNode.getNext();
        size--;

        if (frontNode == null) {
            backNode = null;
        }

        return elementToReturn;
    }

    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return frontNode.getElement();
    }

    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return backNode.getElement();
    }
}