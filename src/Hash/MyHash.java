package Hash;

public interface MyHash<K, V> {

    public void put(K key, V value);

    public boolean contains(K key);

    void rehash();

    public void remove(K key);

    int getSize();

}
