package BinaryTree;

import ExceptionsTads.ArbolLLeno;
import ExceptionsTads.NodoNoExiste;

public interface MyTree<K, T> {
    T find(K key) throws NodoNoExiste;

    void insert(K key, T data, K parentKey) throws NodoNoExiste, ArbolLLeno;

    void delete (K key) throws NodoNoExiste;
}
