package Tads;

import Exceptions.EmptyHeap;

public interface MyHeap<K extends Comparable<K>, T > {

    void insert(K key, T value);

     HeapNode<K,T> getAndDelete() throws EmptyHeap;

    int size();

}
