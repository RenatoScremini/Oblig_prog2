package Ejercio1;
import Exceptions.NodoVacio;

public interface MyTree <K extends Comparable<K>, T>  {

    T find (K key) throws NodoVacio;
    // Busca la posicion de un elemento dado dentro del AB.


    void insert (K key, T data, K parentKey);
    /*
    Añade un elemento al AB.
    El elemento que vamos a añadir tiene que respetar las propiedades del AB.

    */

    void delete (K key);
    /*
    Elimina un nodo deseado del AB.
    El nodo a eliminar puede ser el root node, o cualquiera de los nodos "hijos".

    */


}
