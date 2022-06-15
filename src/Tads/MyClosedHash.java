package Tads;




public class MyClosedHash<K,T> implements  MyHash<K,T> {

    private NodeHash<K, T>[] myHash;

    private int tableSize;
    private int currentSize;

    private void vectorInit(){
        for (int i = 0; i < tableSize; i++)
            myHash[i] = null;
        currentSize = 0;
    }



    @Override
    public void put(K key, T value) {
        int hash = key.hashCode() % tableSize;

        while (myHash[hash] != null && !myHash[hash].isDeleted()) {
            hash = (hash + 1) % tableSize;
        }
        myHash[hash] = new NodeHash<>(key,value);
        currentSize++;

    }

    @Override
    public T get(K key) {
        int hash = key.hashCode() % tableSize;


        while (myHash[hash] != null ) {
            if (myHash[hash].getKey().equals(key) && !myHash[hash].isDeleted()) {
                return (T) myHash[hash].getValue();
            }
            hash = (hash + 1) % tableSize;
        }

        return null;
    }

    @Override
    public void remove(K key) {
        for (int i = 0; i < tableSize; i++)
            if (myHash[i] != null && myHash[i].getKey().equals(key)){
                myHash[i].setDeleted(true);
                currentSize--;
                return;
            }

    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return getSize()== 0;
    }
}