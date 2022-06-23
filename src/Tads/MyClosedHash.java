package Tads;




public class MyClosedHash<K,T> implements  MyHash<K,T> {



    private NodeHash<K, T>[] myHash;

    private int tableSize;
    private int currentSize;
    private int ocupizeSize;

    public MyClosedHash(int tableSize) {
    }


    private void vectorInit(){
        for (int i = 0; i < tableSize; i++)
            myHash[i] = null;
        currentSize = 0;
    }
    private  void reSize() {
        this.tableSize = tableSize * 2;
        MyClosedHash newHash = new MyClosedHash(tableSize);
        for(int i = 0; i < tableSize/2; i++){
            if(myHash[i] != null && myHash[i].isDeleted() == false){
                newHash.put(myHash[i].getKey(), myHash[i].getValue());
            }
        }
        setMyHash(newHash.myHash);
        setOcupizeSize(newHash.ocupizeSize);
    }



    @Override
    public void put(K key, T value) {
        int hash = key.hashCode() % tableSize;
        if(ocupizeSize / tableSize > 0.7){
            reSize();
        }
        while (myHash[hash] != null && !myHash[hash].isDeleted()) {
            hash = (hash + 1) % tableSize;
        }
        myHash[hash] = new NodeHash<>(key,value);
        currentSize++;
        ocupizeSize++;

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



    public NodeHash<K, T>[] getMyHash() {
        return myHash;
    }

    public void setMyHash(NodeHash<K, T>[] myHash) {
        this.myHash = myHash;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int getOcupizeSize() {
        return ocupizeSize;
    }

    public void setOcupizeSize(int ocupizeSize) {
        this.ocupizeSize = ocupizeSize;
    }

}