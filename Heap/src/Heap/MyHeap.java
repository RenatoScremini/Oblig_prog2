package Heap;

public interface MyHeap<T extends  Comparable<T>> {

    void insert(T value);

    T delete() throws EmptyHeap;

    int size();

}
