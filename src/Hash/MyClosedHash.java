package Hash;

public class MyClosedHash<K, V> implements MyHash<K,V> {

    private int umbral;
    private final double loadFactor;
    private int size;
    private int totalSize;
    private Object[][] hashTable;

    public MyClosedHash(int initSize, double loadFactor) {
        this.loadFactor = loadFactor;
        totalSize = initSize;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode()*7 % (totalSize-1));
    }


    @Override
    public void put(K key, V value) {
        if (getSize() >= umbral){
            rehash();
        }

        int index = hashFunc(key);
        while (hashTable[index][0] != null){
            index++;
            if(index == this.totalSize){
                index = 0;
            }
        }
        hashTable[index][0] = key;
        hashTable[index][1] = value;
        size = size + 1;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void rehash() {
        umbral = (int)(totalSize * loadFactor);
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public int getSize() {
        return size;
    }
}
