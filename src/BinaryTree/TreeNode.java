package BinaryTree;

import com.sun.source.tree.Tree;

public class TreeNode<K, T> {

    K key;

    T data;

    TreeNode<K, T> leftChild;
    TreeNode<K, T> rightChild;

    public TreeNode(K key, T data) {
        this.key = key;
        this.data = data;
    }

    public T find(K key){
        if(this.key == key){
            return data;
        }
        else if(getLeftChild()==null) {
            if (getRightChild() == null) {
                return null;
            } else {
                return getRightChild().find(key);
            }
        }
        else{
            return getLeftChild().find(key);
        }
    }

    public TreeNode<K,T> findNodo(K key) {
        TreeNode<K, T> resultado = null;
        if(this.key == key){
            resultado = this;
        } else if(getLeftChild() != null){
            resultado = getLeftChild().findNodo(key);
        }
        if(resultado == null && getRightChild() != null){
            resultado = getRightChild().findNodo(key) ;
        }
        return resultado;
    }

    public TreeNode<K, T> findNodoPadre(K key){
        TreeNode<K, T> resultado = null;
        if(this.getLeftChild() == key){
            resultado = this;
        }else if(this.getRightChild() == key){
            resultado = this;
        }
        else if(getLeftChild().getLeftChild() != null){
            resultado = getLeftChild().findNodoPadre(key);
        }else if(getLeftChild().getRightChild() != null){
            resultado = getLeftChild().findNodoPadre(key);
        }
        if(resultado == null && getRightChild().getLeftChild() != null){
            resultado = getRightChild().findNodoPadre(key) ;
        }else if(resultado == null && getRightChild().getRightChild() != null){
            resultado = getRightChild().findNodoPadre(key);
        }
        return resultado;
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

    public TreeNode<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<K, T> rightChild) {
        this.rightChild = rightChild;
    }



}

