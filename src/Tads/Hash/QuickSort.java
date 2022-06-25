package Tads.Hash;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class QuickSort<K,T>{

    private NodeHash<Long,T>[] quisortArray ;
    int quixsortIndex=0;
    int largo;

    public  void initQuicksort(int larg){
        this.largo = larg;
        quisortArray = new NodeHash[largo];
    }
    public void addToQuicksort(Long key, T value){
        boolean newValue=true;
        for (int l =0;l<quixsortIndex;l++) {
            if(quisortArray[l].getValue().equals(value)){
                newValue=false;
                quisortArray[l].setKey(quisortArray[l].getKey()+key);
            }
        }
        if (newValue) {
            quisortArray[quixsortIndex] = new NodeHash<>(key, value);
            quixsortIndex++;
        }

    }
    public void emptyQuickArray(){
        quixsortIndex=0;
        quisortArray= new NodeHash[largo];
    }
    public  NodeHash<K, T>[] Top(int top){
        NodeHash<K,T>[] result =  new NodeHash[top];

        quicksort(quisortArray,quisortArray[0],quisortArray[quixsortIndex-1]);
        int a = min(top,quixsortIndex);
        for (int j =0;j<a;j++)
            result[j] = new NodeHash(quisortArray[j].getKey(),quisortArray[j].getValue()) ;
        return  result;
    }

    private void quicksort(NodeHash<Long, T>[] arr, NodeHash<Long, T> low, NodeHash<Long, T> high){
        if(low.getKey() < high.getKey()){
            NodeHash<Long, T> p = partition(arr, low, high);
            quicksort(arr, low, arr[p.getKey().intValue()-1]);
            quicksort(arr, arr[p.getKey().intValue()+1], high);
        }
    }
    private NodeHash<Long, T> partition(NodeHash<Long, T>[] arr, NodeHash<Long, T> low, NodeHash<Long, T> high){
        int p = low.getKey().intValue(), j;
        for(j=low.getKey().intValue()+1; j <= high.getKey(); j++)
            if(arr[j].getKey() < arr[low.getKey().intValue()].getKey())
                swap(arr, arr[++ p], arr[j]);

        swap(arr, low, arr[p]);
        return arr[p];
    }
    private void swap(NodeHash<Long, T>[] arr, NodeHash<Long, T> low, NodeHash<Long, T> pivot) {
        try {
            NodeHash<Long, T> tmp = arr[low.getKey().intValue()];
            arr[low.getKey().intValue()] = arr[pivot.getKey().intValue()];
            arr[pivot.getKey().intValue()] = tmp;
        }catch (Exception e){
            System.out.println("error en swap");
        }
    }

}

