package Heap;

public class MyHeapTest {
    public static void main(String[] args) {

        Integer[] values = new Integer[5];
        MyHeap<Integer> heapInteger = new MyHeapImpl<>(values, true);

        heapInteger.insert(23);
        heapInteger.insert(10);
        heapInteger.insert(50);

        for (int i = 0; i < values.length; i++){
            System.out.println(values[i]);
        }

    }
}
