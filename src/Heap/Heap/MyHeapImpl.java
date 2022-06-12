package Heap.Heap;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T>  {

    private T[] values;

    private int nextElement = 0;

    private boolean isHeapMax;

    public MyHeapImpl(T[] values, boolean isHeapMax) {
        this.values = values;
        this.isHeapMax = isHeapMax;
    }

    private int getFatherElement(int childElement){
        return (childElement - 1) / 2;
    }

    @Override
    public void insert(T value) {
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
    }

    @Override
    public T delete() throws EmptyHeap {
        if (size == 0){
            throw new EmptyHeap();
        }
        T min = values[1];
        values[1] = values[size--];
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int size;
}
