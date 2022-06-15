import ExceptionsTads.EmptyHeap;
import Tads.MyHeap;
import Tads.MyHeapImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class HeapTest {


    @Test
    public void testInsert() throws EmptyHeap{
        MyHeap<Integer, Integer> heapTest = new MyHeapImpl<>();

        heapTest.insert(10,10);
        heapTest.insert(1,1);
        heapTest.insert(20,20);
        heapTest.insert(2,2);
        heapTest.insert(5,5);
        heapTest.insert(7,7);
        heapTest.insert(30,30);
        Assertions.assertEquals(7, heapTest.size());


    }
}
