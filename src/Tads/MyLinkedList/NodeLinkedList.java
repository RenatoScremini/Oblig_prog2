package Tads.MyLinkedList;

public class NodeLinkedList {
    private Object value;
    private NodeLinkedList next;


    public NodeLinkedList(Object value){

        this.value = value;
        this.next = null;

    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public NodeLinkedList getNext() {
        return next;
    }

    public void setNext(NodeLinkedList next) {
        this.next = next;
    }



}
