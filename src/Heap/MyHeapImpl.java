package Heap;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T>  {

    private T[] values;
    private int size;

    private int nextElement = 0;
    private boolean isHeapMin = true;
    private boolean isHeapMax;

    public MyHeapImpl(T[] values, boolean isHeapMax) {
        this.values = values;
        this.isHeapMax = isHeapMax;
        this.size = 0;


    }

    private int getFatherElement(int childElement){
        return (childElement - 1) / 2;
    }

    private void insertElement(int e){
        T temp = values[e];
        /*
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

    @Override
    public void insert(T value) {
        // Por las dudas no eliminar.
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
        if (size == values.length - 1)
            doubleSize();

        // Insert a new item to the end of the array
        int pos = ++size;

        // Percolate up
        for (; pos > 1 && (isHeapMin ? value.compareTo(values[pos / 2]) < 0 : !(value.compareTo(values[pos / 2]) < 0)); pos = pos / 2){
            values[pos] = values[pos / 2];
        }
        values[pos] = value;

    }

    private void doubleSize(){
        T[] old = values;
        values = (T[]) new Comparable[values.length * 2];
        System.arraycopy(old, 1, values, 1, size);
    }
    @Override
    public T delete() throws EmptyHeap {
        if (size == 0){
            throw new EmptyHeap();
        }
        T elementToDelete = values[1];
        values[1] = values[size--];
        insertElement(1);
        return elementToDelete;
    }

    @Override
    public int size() {
        return size;
    }
}

