import Ejercicio.MyStack;
import Ejercicio.MyStackImp;

public class main {
    public static void main(String[] args) {
        MyStackImp<Integer> stack = new MyStackImp<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        // System.out.println(stack.top());

        // stack.pop();

        // System.out.print(stack.isEmpty());

        stack.makeEmpty();

        stack.display();

    }
}
