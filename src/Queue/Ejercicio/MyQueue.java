package Queue.Ejercicio;

import Ejercicio.EmptyQueueException;

public interface MyQueue<T> {

    void enqueue (T element);

    T dequeue () throws EmptyQueueException;

    boolean isEmpty();

}
