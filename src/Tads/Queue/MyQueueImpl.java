package Tads.Queue;

import Exceptions.EmptyQueueException;

public class MyQueueImpl<T> implements MyQueue<T> {

    NodeQueue<T> first;
    NodeQueue<T> last;

    private void addToBeginning ( T element){
        NodeQueue<T> elementToAdd = new NodeQueue<>(element);

        if (this.first == null){
            this.first = elementToAdd;
            this.last = elementToAdd;
            return;
        }
        if (this.first != null){
            NodeQueue<T> newBanana = this.first;
            while (newBanana.getNext() != null){
                newBanana = newBanana.getNext();
            }
            newBanana.setNext(elementToAdd);
        }
    }



    @Override
    public void enqueue(T element) {
        addToBeginning(element);
    }

    @Override
    public T dequeue() throws EmptyQueueException {

        if (this.first == null){
            throw new EmptyQueueException();
        }

        if (this.first != null){
            NodeQueue<T> resultNodeQueue = this.first;
            if (resultNodeQueue.getNext() != null){
                this.first = this.first.getNext();
                return resultNodeQueue.getElement();
            }

            if (this.first == this.last){
                this.first = null;
                this.last = null;
                return  resultNodeQueue.getElement();
            }
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        boolean emptyQueue = false;

        if (this.first == null && this.last == null){
            emptyQueue = true;
        }

        return  emptyQueue;
    }

    public void display ( ){
        NodeQueue temp = this.first;
        while (temp.getNext() != null){
            System.out.print(temp.getElement());
            System.out.print(" ");
            temp = temp.getNext();
        }
        System.out.print(temp.getElement());
    }
}
