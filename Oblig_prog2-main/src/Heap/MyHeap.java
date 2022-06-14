package Heap;

public interface MyHeap<K extends Comparable<K>, T > {

    void insert(K key, T value);

    Node<K, T> delete() throws EmptyHeap;

    int size();

}
