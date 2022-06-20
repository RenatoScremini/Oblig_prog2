import Tads.MyStack;
import Tads.MyStackImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;






public class TestStack {

    @Test
    public void stackPush(){
        MyStack<Integer> stackTest = new MyStackImpl<>();

        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(5);
        stackTest.push(7);
        stackTest.push(9);
        stackTest.push(12);
        stackTest.push(30);

        Assertions.assertEquals(30, stackTest.top());


    }

    @Test
    public void stackPop(){
        MyStack<Integer> stackTest = new MyStackImpl<>();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(5);
        stackTest.push(7);
        stackTest.push(9);
        stackTest.push(12);
        stackTest.pop();
        Assertions.assertEquals(9, stackTest.pop());
    }

    @Test
    public void stackTop(){
        MyStack<Integer> stackTest = new MyStackImpl<>();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(5);
        stackTest.push(7);
        stackTest.top();
        Assertions.assertEquals(7, stackTest.top());
    }

    @Test
    public void stackMakeEmpty(){
        MyStack<Integer> stackTest = new MyStackImpl<>();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(5);
        stackTest.push(7);
        stackTest.makeEmpty();
        Assertions.assertTrue(stackTest.isEmpty());
    }
}
