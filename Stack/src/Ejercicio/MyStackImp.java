package Ejercicio;

import java.util.EmptyStackException;

public class MyStackImp<T> implements MyStack<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    private void remove(T element){
        Node<T> beforeSearchElement = null;
        Node<T> searchElement = this.first;

        while(searchElement != null && !searchElement.getElement().equals(element)){
            beforeSearchElement = searchElement;
            searchElement = searchElement.getNext();
        }

        if (searchElement != null){
            if (searchElement == this.first && searchElement != this.last){

                Node<T> elementRemove = this.first;
                this.first = this.first.getNext();

                elementRemove.setNext(null);
            } else if (searchElement == this.last && searchElement != this.first){

                beforeSearchElement.setElement(null);
                this.last = beforeSearchElement;
            } else if (searchElement == this.last && searchElement == this.first){
                this.first = null;
                this.last = null;

            } else {
                beforeSearchElement.setNext(searchElement.getNext());
                searchElement.setNext(null);
            }
        } else {

        }
    }

    private T removeLast(){
        T elementToRemove = null;

        if (this.first != null ){
            elementToRemove = this.first.getElement();

            remove(elementToRemove);
        }

        return elementToRemove;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.last == null) {
            throw new EmptyStackException();
        }
        return removeLast();
    }

    @Override
    public T top() throws EmptyStackException {
        T elementReturn = null;

        if (this.first != null){
            elementReturn = this.first.getElement();
        }
        if (this.first == null){
            throw new EmptyStackException();
        }

        return elementReturn;
    }


    @Override
    public void push(T element) {
        if (element != null){

            Node<T> elementToAdd = new Node<>(element);

            if(this.first == null) { // Si la stack esta vacia.
                this.first = elementToAdd;
                this.last = elementToAdd;
                return;
            } else {
                elementToAdd.setNext(this.first);
                this.first = elementToAdd;
            }

            } else {
            // que cazzo faccio?
        }

    }

    @Override
    public boolean isEmpty() {
        boolean emptyStack = false;
        if(this.last == null ) {
            emptyStack = true;

        } else if (this.last != null){
            emptyStack = false;
        }

        return emptyStack;
    }

    @Override
    public void makeEmpty() {
        if (this.first != null && this.last != null ){
            this.first.setElement(null);
            this.first.setNext(null);
            this.last.setElement(null);
        }

    }

    public void display ( ){
        Node temp = this.first;
        while (temp.getNext() != null){
            System.out.print(temp.getElement());
            System.out.print(" ");
            temp = temp.getNext();
        }
        System.out.print(temp.getElement());
    }
}
