package Tads;

import ExceptionsTads.EmptyHeap;

public interface MyHeap<K extends Comparable<K>, T > {

    void insert(K key, T value);

     HeapNode<K,T> delete() throws EmptyHeap;

    int size();

}
