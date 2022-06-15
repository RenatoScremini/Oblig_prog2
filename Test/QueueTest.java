import ExceptionsTads.EmptyQueueException;
import Tads.MyQueue;
import Tads.MyQueueImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class QueueTest {

    @Test
    public void queueEnqueue(){
        MyQueue<Integer> queueTest = new MyQueueImpl<>();

        queueTest.enqueue(1);
        queueTest.enqueue(2);
        queueTest.enqueue(3);
        queueTest.enqueue(4);
        queueTest.enqueue(5);
        queueTest.enqueue(6);

        Assertions.assertFalse(queueTest.isEmpty());
    }

    @Test
    public void queueDequeue() throws EmptyQueueException {
        MyQueue<Integer> queueTest = new MyQueueImpl<>();

        queueTest.enqueue(1);
        queueTest.enqueue(2);
        queueTest.enqueue(3);
        queueTest.enqueue(4);
        queueTest.enqueue(5);
        queueTest.enqueue(6);
        queueTest.dequeue();

        //Assertions.ass


    }
}
