package Tads.Heap;

public class HeapNode<K,T> {

    K key;
    T value;

    HeapNode<K,T> leftChild;
    HeapNode<K,T> rightChild;

    public HeapNode<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HeapNode<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public HeapNode<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(HeapNode<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public HeapNode(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}