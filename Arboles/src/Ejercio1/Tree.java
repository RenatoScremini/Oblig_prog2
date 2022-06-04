package Ejercio1;
import Exceptions.NodoVacio;


public class Tree<K extends Comparable<K>, T> implements MyTree<K, T>  {

    private Node<Object, Object> findNode(Object parentKey) {
        return null;
    }

    private Node<K,T> root;

    private Node<K, T> findNode(K key, Node<K, T> root) {
        Node <K, T> result = null;

        if (root.getKey() == key){
            result = root;
        }
        if (result == null) {
            result = findNode(key, root.getLeftChild());
        }
        if (result == null){
            result = findNode(key, root.getRightChild());
        }

        return result;
    }

    private K getMax(Node<K, T> root) {
        K result = null;

        if (root.getRightChild() == null) {
            result = root.getKey();
        } else {
            result = getMax(root.getRightChild());
        }

        return result;
    }

    private K getMin(Node<K,T> root) {
        K result = null;

        if (root.getLeftChild() == null) {
            result = root.getKey();
        } else {
            result = getMin(root.getLeftChild());
        }

        return result;
    }

    private Node<K,T> deleteNode(K key, Node<K,T> root){
        Node<K,T> result = root;

        if (root == null){

        } else if (key.compareTo(root.getKey()) < 0){
            root.setLeftChild(deleteNode(key, root.getLeftChild()));
        } else if (key.compareTo(root.getKey()) > 0){
            root.setRightChild((deleteNode(key, root.getRightChild())));
        } else {

            if (root.getLeftChild() != null) {
                K candidate = getMax(root.getLeftChild());
                root.setKey(candidate);
                root.setLeftChild(deleteNode(candidate, root.getLeftChild()));
            }

            if (root.getRightChild() != null){
                K candidate = getMin(root.getRightChild());
                root.setKey(candidate);
                root.setRightChild(deleteNode(candidate, root.getRightChild()));
            }
        }
        return result;
    }

    @Override
    public T find(K key ) throws NodoVacio {
        return findNode(key, this.root).getData();
    }

    @Override
    public void insert(K key, T data, K parentKey) {
        Node<K,T> newNode = new Node<K,T>(key, data);

        if (findNode(parentKey) == null){
            root = newNode;
        } else if (findNode(parentKey).getRightChild() == null) {
            this.findNode(parentKey, root).setRightChild(newNode);
        } else if (findNode(parentKey).getLeftChild() == null) {
            this.findNode(parentKey, root).setLeftChild(newNode);
        }
    }


    @Override
    public void delete(K key) {
        root = deleteNode(key, root);
    }



}
