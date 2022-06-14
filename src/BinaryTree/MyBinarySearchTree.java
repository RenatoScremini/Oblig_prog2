/*
package BinaryTree;

import ExceptionsTads.ArbolLLeno;
import ExceptionsTads.NodoNoExiste;
import ExceptionsTads.NodoOcupado;
import ExceptionsTads.NumeroInvalido;


public class MyBinarySearchTree <K, T> implements MyTree<K,T> {
    private TreeNode<K, T> primero;

    @Override
    public T find(K key) throws NodoNoExiste {
        TreeNode<K, T> nodoRaiz = primero;
        if (nodoRaiz.getKey() == null) { // es un arbol vacio
            throw new NodoNoExiste;
        } else {
            return nodoRaiz.find(key);
        }
    }

    public void ingresarNodo(K key, T data) throws NumeroInvalido {
        TreeNode<K, T> nodoRaiz = primero; // como hago para que no se me setee siempre aca
        TreeNode<K, T> nodoAgregar = new TreeNode<K, T>(key, data);

        if (nodoAgregar.getKey() > nodoRaiz.getKey()) {
            if (nodoRaiz.getLeftChild() == null) {
                nodoRaiz.setLeftChild(nodoAgregar);
            } else {
                ingresarNodo(nodoRaiz.getLeftChild().getKey(), nodoRaiz.getLeftChild().getData());
            }
        } else if (nodoAgregar.getKey() >= nodoRaiz.getKey()) {
            throw new NumeroInvalido();
        } else {
            if (nodoRaiz.getRightChild() == null) {
                nodoRaiz.setRightChild(nodoAgregar);
            } else {
                ingresarNodo(nodoRaiz.getRightChild().getKey(), nodoRaiz.getRightChild().getData());
            }
        }
    }

    @Override
    public void insert(K key, T data, K parentKey) throws NodoNoExiste, ArbolLLeno {
        TreeNode<K, T> nodoRaiz = primero;
        TreeNode<K, T> nodoAgregar = new TreeNode<K, T>(key, data);
        if (nodoRaiz == null) {
            nodoRaiz = nodoAgregar;
        } else {
            ingresarNodo(key, data);// ya seria suficiente con esto? FIXME
        }
    }


    @Override
    public void delete(K key) throws NumeroInvalido {
        if (buscarNodoPadre(key) == null) {
            throw new NumeroInvalido();
        }
        if (buscarNodoPadre(key))// ir viendo todos los casos
    }

    public TreeNode<K, T> buscarNodoPadre(K key) {
        TreeNode<K, T> nodoRaiz = primero;
        if (nodoRaiz.getKey() == key) {
            // no hay padre, como mierda hago si hay qeu eliminar el root
        } else if (key > nodoRaiz.getKey()) {
            if (nodoRaiz.getLeftChild() == null) {
                return nodoRaiz;
            } else {
                return buscarNodoPadre(nodoRaiz.getLeftChild().getKey());
            }
        } else if (key < nodoRaiz.getKey()) {
            if (nodoRaiz.getRightChild() == null) {
                return nodoRaiz;
            } else {
                return buscarNodoPadre(nodoRaiz.getRightChild().getKey());
            }
        }
        return null;
    }
}



 */
