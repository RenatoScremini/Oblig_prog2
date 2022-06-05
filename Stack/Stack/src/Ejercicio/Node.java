package Stack.Stack.src.Ejercicio;

public class Node<T> {
    T element;

    private Node<T> next;

    public Node(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {this.element = element;}

}