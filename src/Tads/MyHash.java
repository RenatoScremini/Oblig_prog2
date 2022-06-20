package Tads;

public interface MyHash<K, V> {

    void put(K key, V value);

    V get (K key);

    void remove(K key);

    int getSize();

    boolean isEmpty();

}
