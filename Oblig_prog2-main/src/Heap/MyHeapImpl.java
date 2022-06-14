package Heap;

public class MyHeapImpl<K extends  Comparable<K>,T> implements MyHeap<K,T>  {


    private Node[] heap;

    private int size;

    private Node<K,T> root;
    private Node<K,T> last;

    private boolean isHeapMin = true;
    private boolean isHeapMax;



    private int getFatherElement(int childElement){
        return (childElement - 1) / 2;
    }

    @Override
    public void insert(K key,T value) {
        Node<K, T> nodoAgregar = new Node<>(key, value);

        if (size == heap.length - 1){
            doubleSize();
        }

        int posicionFinal = size() -1;



    }

    private void doubleSize(){
        Node[] old = heap;
        heap = (Node[]) new Comparable[heap.length * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }

    @Override
    public Node<K ,T> delete() throws EmptyHeap {
        if (size == 0){
            throw new EmptyHeap();
        }
        Node elementToDelete = heap[1];
        heap[1] = heap[size--];
        insertElement(1);
        return elementToDelete;
    }
    @Override
    public int size() {
        return size;
    }

    private void insertElement(int e){
        /*
        T temp = values[e];

        for(; 2 * e <= size; e = child){
            child = 2 * e;

            if (child != size && (isHeapMin ? values[child].compareTo(values[child + 1]) > 0 : !(values[child].compareTo(values[child + 1]) > 0))){
                child++;
            }

            if (isHeapMin ? temp.compareTo(values[child]) > 0 : !(temp.compareTo(values[child]) > 0)){
                values[e] = values[child];
            } else {
                break;
            }
        } values[e] = temp;

         */


    }

    //Por las dudas no eliminar.
        /*
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

         */

        /*
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
}



