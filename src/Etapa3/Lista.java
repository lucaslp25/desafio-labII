package Etapa3;

public interface Lista<E>{

    public int numElements();

    public boolean isEmpty();

    public boolean isFull();

    public void insert(E element, int index);

    public E remove(int index);

    public E get(int index);

    public int contaElementos(E element);
 }
