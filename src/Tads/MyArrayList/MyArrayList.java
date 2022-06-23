package Tads.MyArrayList;


public interface MyArrayList <T> {

    void add(T value);

    T get (int postion);

    void delete(T value);

    boolean contains(T value);

    int size();
}
