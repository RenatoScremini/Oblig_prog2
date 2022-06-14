
package BinaryTree;

import ExceptionsTads.NodoNoExiste;
import com.sun.source.tree.Tree;


public class MyBinarySearchTree <K extends  Comparable<K>, T extends  Comparable<T>>  implements MyTree<K,T> {
    private TreeNode<K, T> primero;
    TreeNode<K, T> nodoRaiz = primero;

    @Override
    public T find(K key) throws NodoNoExiste {
        if (nodoRaiz.getKey() == null) { // es un arbol vacio
            return null;
        } else if (key.compareTo(nodoRaiz.getKey())== 1) {
            TreeNode<K, T> nodoTemp;
            nodoTemp = findNodo(key);
            return nodoRaiz.getLeftChild().find(key);
        }else{
            return nodoRaiz.getRightChild().find(key);
        }
    }

    @Override
    public void insert(K key, T data)  {
        TreeNode<K, T> nodoTemp = new TreeNode<>(key, data);
        primero = insert(key, data, nodoTemp);
    }

    private TreeNode<K, T> insert(K key, T data, TreeNode<K,T> nodoTemp){
        TreeNode<K, T> nodoAIngresar = new TreeNode<>(key, data);
        if( primero == null){
            return nodoAIngresar;
        }
        if(data.compareTo(nodoTemp.getData()) > 0){
            TreeNode<K, T> nodoDer = insert(key, data, nodoTemp.getRightChild());
            nodoTemp.setRightChild(nodoDer);
            return nodoTemp;
        } else if(data.compareTo(nodoTemp.getData()) < 0){
            TreeNode<K, T> nodoIzq = insert(key, data, nodoTemp.getLeftChild());
            nodoTemp.setLeftChild(nodoIzq);
            return nodoTemp;
        }
        return null;
    }

    @Override
    public void delete(K key) {
        /*if (buscarNodoPadre(key) == null) {
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
        return null;*/
    }


}




