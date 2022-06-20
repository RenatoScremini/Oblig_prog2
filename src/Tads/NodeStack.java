package Tads;

public class NodeStack<T> {
    T element;

    private NodeStack<T> next;

    public NodeStack(NodeStack<T> next) {
        this.next = next;
    }

    public NodeStack<T> getNext() {
        return next;
    }

    public void setNext(NodeStack<T> next) {
        this.next = next;
    }

    public NodeStack(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }


}
