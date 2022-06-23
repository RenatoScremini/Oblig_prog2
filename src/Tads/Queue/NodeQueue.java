package Tads.Queue;

public class NodeQueue<T> {
    T element;

    private NodeQueue<T> next;

    public NodeQueue(NodeQueue<T> next) {
        this.next = next;
    }

    public NodeQueue<T> getNext() {
        return next;
    }

    public void setNext(NodeQueue<T> next) {
        this.next = next;
    }

    public NodeQueue(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }


}