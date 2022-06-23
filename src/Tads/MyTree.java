package Tads;

import Exceptions.ArbolLLeno;
import Exceptions.NodoNoExiste;

public interface MyTree<K, T> {
    T find(K key) throws NodoNoExiste;

    void insert(K key, T data) throws NodoNoExiste, ArbolLLeno;

    void delete (K key) throws NodoNoExiste;
}
