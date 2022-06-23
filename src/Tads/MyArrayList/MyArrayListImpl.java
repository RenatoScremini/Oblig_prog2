package Tads.MyArrayList;


public class MyArrayListImpl<T> implements MyArrayList<T>{

    private T[] list;

    private int size;

    private int length;

    public MyArrayListImpl (int length){
        this.list = (T[]) new Object[length];
        this.length = length;
        this.size = 0;
    }


    @Override
    public void add(T value) {
        if(value!=null) {
            if(size == length){
                T[] newlist = (T[]) new Object[2*length];
                for(int i = 0; i < size; i ++){
                    newlist[i] = list[i];
                }
                this.list = newlist;
            }
            else{
                list[size] = value;
                size = size + 1;
            }
        }
    }

    @Override
    public T get(int posicion) {
        if (posicion<size) {
            return list[posicion];
        }else{
            return null;
        }
    }

    @Override
    public void delete(T value) {
        if (value != null && this.contains(value)) {
            int posicion = 0;
            for (int i = 0; i < size; i++) {
                if (list[posicion] != value) {
                    posicion = posicion + 1;
                }
            }
            for (int i = 0; i < (size - posicion) - 1; i++) {
                list[posicion + i] = list[posicion + i + 1];
            }
            list[size - 1] = null;
            size = size - 1;
        }
    }

    public boolean contains(T value){
        if(value != null) {
            for (int i = 0; i < size; i++) {
                if (list[i] == value) {
                    return true;
                }
            }
        }
        return false;
    }
    public int size(){
        return this.size;
    }

}

