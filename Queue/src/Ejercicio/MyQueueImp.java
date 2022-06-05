package Ejercicio;

public class MyQueueImp<T> implements MyQueue<T> {

    Node<T> first;
    Node<T> last;

    private void addToBeginning ( T element){
        Node<T> elementToAdd = new Node<>(element);

        if (this.first == null){
            this.first = elementToAdd;
            this.last = elementToAdd;
            return;
            }
        if (this.first != null){
            Node<T> newBanana = this.first;
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
            Node<T> resultNode = this.first;
            if (resultNode.getNext() != null){
                this.first = this.first.getNext();
                return resultNode.getElement();
            }

            if (this.first == this.last){
                this.first = null;
                this.last = null;
                return  resultNode.getElement();
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
        Node temp = this.first;
        while (temp.getNext() != null){
            System.out.print(temp.getElement());
            System.out.print(" ");
            temp = temp.getNext();
        }
        System.out.print(temp.getElement());
    }
}
