package Heap;

public class MyHeapImpl<K extends  Comparable<K>,T> implements MyHeap<K,T>  {

    public MyHeapImpl(Node[] heap, boolean isHeapMin, boolean isHeapMax) {
        this.heap = heap;
        this.lastValuePosition = 0;
        this.isHeapMin = isHeapMin;
        this.isHeapMax = isHeapMax;
    }

    private Node[] heap;
    private int size;

    private int lastValuePosition;

    private Node<K,T> root;
    private Node<K,T> last;


    private boolean isHeapMin;
    private boolean isHeapMax;



    private K getFatherElement(int childElement){
        return (K) heap[(childElement - 1)/2];
    }

    private int getFatherPosition(int childElement){
        return (childElement - 1 ) / 2;
    }



    @Override
    public void insert(K key,T value) {

        /**
         * Me inserta el Node al final del array.
         */

        this.heap[lastValuePosition] = (Node) key;
        int pos = lastValuePosition;
        lastValuePosition++;

        if(isHeapMax == true){
            while( pos != 0 && key.compareTo(getFatherElement(pos)) > 0) {
                Node change = (Node) getFatherElement(pos);
                this.heap[getFatherPosition(pos)] = (Node) key;
                this.heap[pos] = change;
                pos = getFatherPosition(pos);
            }
        }

    }

    private void doubleSize(){
        Node[] old = heap;
        heap = (Node[]) new Comparable[heap.length * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }
    @Override
    public T delete() throws EmptyHeap {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

/*
Por las dudas no eliminar.

                values[nextElement] = value;
        int element = nextElement;
        nextElement++;

        int fatherElement = getFatherElement(element);
        while(value.compareTo(this.values[fatherElement]) > 0 && element != 0){
            values[element] = this.values[fatherElement];
            values[fatherElement] = value;

            element = fatherElement;
            fatherElement = getFatherElement(element);
        }

        if (size == values.length - 1)
            doubleSize();

        // Insert a new item to the end of the array
        int pos = ++size;

        // Percolate up
        for (; pos > 1 && (isHeapMin ? value.compareTo(values[pos / 2]) < 0 : !(value.compareTo(values[pos / 2]) < 0)); pos = pos / 2){
            values[pos] = values[pos / 2];
        }
        values[pos] = value;
 */

