package Stack;

import Stack.src.Ejercicio.MyStack;
import Stack.src.Ejercicio.MyStackImp;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


/*

<!-- add the junit dependency here -->
<dependency>
<groupId>org.junit.jupiter</groupId>
<artifactId>junit-jupiter-api</artifactId>
<version>5.7.0</version>
<scope>test</scope>
</dependency>

 */



public class TestStack {
    @Test
    public void pushTest(){
        MyStack<Integer> stack = new MyStackImp<Integer>();

        stack.push(1);
        Assertions.assertEquals(1,stack.top());

    }


}


