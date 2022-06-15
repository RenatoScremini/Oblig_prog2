package Hash;

public class MyClosedHashTest {
    public static void main(String[] args) {

        Integer[] values = new Integer[10];
        MyHash<Integer, Integer> hashInteger = new MyClosedHash<>(10,10);

        hashInteger.put(1,1);
        hashInteger.put(2,2);
        hashInteger.put(3,3);
        hashInteger.put(4,4);
        hashInteger.put(5,5);
        hashInteger.put(6,6);
        hashInteger.put(7,7);

        System.out.println(hashInteger.contains(10));
        System.out.println(hashInteger.contains(1));

    }
}
