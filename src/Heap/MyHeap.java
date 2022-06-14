package Heap;

public interface MyHeap<K extends Comparable<K>, T > {

    void insert(K key, T value);

    T delete() throws EmptyHeap;

    int size();

}
