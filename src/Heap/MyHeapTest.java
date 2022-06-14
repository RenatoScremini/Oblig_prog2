package Heap;

public class MyHeapTest {
    public static void main(String[] args) throws EmptyHeap {

        Integer[] values = new Integer[10];
        MyHeap<Integer, Integer> heapInteger = new MyHeapImpl<>(values, true);

        /*


        heapInteger.insert(10);
        heapInteger.insert(23);
        heapInteger.insert(50);
        heapInteger.insert(40);
        heapInteger.insert(30);
        heapInteger.insert(5);


        heapInteger.delete(5);
        */


        for (int i = 0; i < values.length; i++){
            System.out.println(values[i]);
        }

        System.out.print(heapInteger.size());


    }
}