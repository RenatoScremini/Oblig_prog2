
package Tads;

import Exceptions.NodoNoExiste;


public class MyBinarySearchTree <K extends  Comparable<K>, T extends  Comparable<T>>  implements MyTree<K,T> {
    private TreeNode<K, T> primero;
    TreeNode<K, T> nodoRaiz = primero;

    @Override
    public T find(K key) throws NodoNoExiste {
        if (nodoRaiz.getKey() == null) { // es un arbol vacio
            return null;
        } else if (key.compareTo(nodoRaiz.getKey()) == 1) {
            return find(nodoRaiz.getLeftChild().getKey());
        } else {
            return find(nodoRaiz.getLeftChild().getKey());
        }
    }

    @Override
    public void insert(K key, T data) {
        TreeNode<K, T> nodoTemp = new TreeNode<>(key, data);
        primero = insert(key, data, nodoTemp);
    }

    private TreeNode<K, T> insert(K key, T data, TreeNode<K, T> nodoTemp) {
        TreeNode<K, T> nodoAIngresar = new TreeNode<>(key, data);
        if (primero == null) {
            return nodoAIngresar;
        }
        if (data.compareTo(nodoTemp.getData()) > 0) {
            TreeNode<K, T> nodoDer = insert(key, data, nodoTemp.getRightChild());
            nodoTemp.setRightChild(nodoDer);
            return nodoTemp;
        } else if (data.compareTo(nodoTemp.getData()) < 0) {
            TreeNode<K, T> nodoIzq = insert(key, data, nodoTemp.getLeftChild());
            nodoTemp.setLeftChild(nodoIzq);
            return nodoTemp;
        }
        return null;
    }

    @Override
    public void delete(K key) {
        primero = delete(key, primero);

    }

    private TreeNode<K, T> delete(K key, TreeNode<K, T> nodoTemp) {
        if (nodoTemp == null) {
            return null;
        }
        if (key.compareTo(nodoTemp.getKey()) == 0) {
            if (nodoTemp.getRightChild() == null && nodoTemp.getLeftChild() == null) {
                return null;
            }
            if (nodoTemp.getLeftChild() == null) {
                return nodoTemp.getLeftChild();
            }
            if (nodoTemp.getRightChild() == null) {
                return nodoTemp.getRightChild();
            }
            return null; //FIXME  nose bien como se hace eso
        } else if (key.compareTo(nodoTemp.getKey()) < 0) {
            nodoTemp.setLeftChild(delete(key, nodoTemp.getLeftChild()));
        } else {
            nodoTemp.setRightChild(delete(key, nodoTemp.getRightChild()));
        }
        return nodoTemp;
    }

}




