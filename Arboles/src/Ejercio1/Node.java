package Ejercio1;

public class Node <K, T>{
    K key;
    T data;

    Node<K, T> leftChild;
    Node<K, T> rightChild;

    public Node(K key, T data, Node<K, T> leftChild, Node<K, T> rightChild) {
        this.key = key;
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(Object key, Object data) {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }
}
