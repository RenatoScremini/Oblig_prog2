package Tests.adt;

import List.MyLinkedList;
import org.junit.Test;
import junit.framework.TestCase;

public class TestMyLinkedList {
    @Test
    public void testAdd(){
        MyLinkedList lista = new MyLinkedList();// cambiar a generics
        lista.add(1);
        TestCase.assertEquals(1, lista.get(0));
    }
    @Test
    public void testRemove(){
        MyLinkedList lista = new MyLinkedList();// cambiar a generics
        lista.add(1);
        lista.add(2);
        lista.remove(1);
        TestCase.assertEquals(false, lista.buscar(2));
    }
    @Test
    public void testGet(){
        MyLinkedList lista = new MyLinkedList();// cambiar a generics
        lista.add(1);
        lista.add(2);
        TestCase.assertEquals(1, lista.get(0));
    }
    @Test
    public void testAddfirst(){
        MyLinkedList lista = new MyLinkedList();// cambiar a generics
        lista.add(1);
        lista.add(2);
        lista.addFirst(0);
        TestCase.assertEquals(0, lista.get(0));
    }
    @Test
    public void testAddlast(){
        MyLinkedList lista = new MyLinkedList();// cambiar a generics
        lista.add(1);
        lista.add(2);
        lista.addLast(0);
        TestCase.assertEquals(0, lista.get(2));
    }
    @Test
    public void buscar(){
        MyLinkedList lista = new MyLinkedList();// cambiar a generics
        lista.add(1);
        lista.add(2);
        lista.add(3);
        TestCase.assertEquals(true, lista.buscar(2));
    }

}