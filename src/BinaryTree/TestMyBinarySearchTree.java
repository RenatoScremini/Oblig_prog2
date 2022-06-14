package BinaryTree;


import BinaryTree.MyBinarySearchTree;
import BinaryTree.TreeNode;
import ExceptionsTads.NodoNoExiste;
import org.junit.Test;
import junit.framework.TestCase;

public class TestMyBinarySearchTree {

    @Test
    public void testInsert() throws NodoNoExiste {
        MyBinarySearchTree arbolBinario = new MyBinarySearchTree();
        arbolBinario.insert(0, 0);
        TestCase.assertEquals(), 0 );
    }
}
