package Tads;

import ExceptionsTads.EmptyHeap;

public class MyHeapImpl<K extends Comparable<K>, T> implements MyHeap<K,T> {

    private HeapNode<K,T>[] myHeap;

    private int indexElement = 0;

    public static final int lenght_heap = 10;

    private int getRightChild(int parentIndex){
        return (2 * parentIndex) + 2;
    }

    private int getLeftChild(int parentIndex){
        return (2 * parentIndex) + 1;
    }

    private int getIndexParent(int childIndex){
        return(childIndex -1) / 2;
    }

    @Override
    public void insert(K key, T value) {
        /**
         * Key me determina el orden de los nodos.
         */
        HeapNode<K,T> nodeAdd = new HeapNode<>(key, value);
        myHeap[indexElement] = nodeAdd;

        int elementIndex = indexElement;

        indexElement = indexElement + 1;

        int parentIndex = getIndexParent(elementIndex);
        while(nodeAdd.getKey().compareTo(myHeap[parentIndex].getKey()) > 0 && elementIndex != 0){
            myHeap[elementIndex] = this.myHeap[parentIndex];
            myHeap[parentIndex] = new HeapNode<>(key, value);

            elementIndex = parentIndex;
            parentIndex = getIndexParent(elementIndex);
        }
    }

    @Override
    public HeapNode<K, T> delete() throws EmptyHeap {
        HeapNode<K,T> nodeDelete = null;
        int lastPosition = size() - 1;
        int lenghtArray = size();

        if(lenghtArray == 0){
            throw new EmptyHeap();
        }

        if(lenghtArray == 1){
            nodeDelete = myHeap[0];
            myHeap[0] = null;
            myHeap[1] = null;
        } else if (lenghtArray == 2){
            nodeDelete = myHeap[0];
            nodeDelete = myHeap[1];
            myHeap[1] = null;

        } else {
            int root = 0;

            nodeDelete = myHeap[0];
            myHeap[root] = myHeap[lastPosition];
            myHeap[lastPosition] = null;

            int biggerChild = biggerChildPosition(getRightChild(root), getLeftChild(root));

            while(myHeap[biggerChild].getKey().compareTo(myHeap[root].getKey()) > 0) {
                HeapNode<K,T> temp = myHeap[biggerChild];
                myHeap[biggerChild] = myHeap[root];
                myHeap[root] = temp;
            }
        }

        return nodeDelete;
    }

    private int biggerChildPosition(int first_position, int second_position){
        int position = 0;
        if (myHeap[first_position] != null && myHeap[first_position].getKey().compareTo(myHeap[second_position].getKey()) > 0){
            position = first_position;
        } else if (myHeap[second_position] != null){
            position = second_position;
        }
        return position;
    }

    @Override
    public int size() {
        int entry_lenght = 0;
        for (int i = 0; i < myHeap.length; i++){
            if(myHeap[i] != null){
                entry_lenght++;
            }
        }
        return entry_lenght;
    }
}