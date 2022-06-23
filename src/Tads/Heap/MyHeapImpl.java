package Tads.Heap;

import Exceptions.EmptyHeap;

public class MyHeapImpl<K extends Comparable<K>, T> implements MyHeap<K,T> {

    private HeapNode<K, T>[] myHeap;

    private int nextIndex = 0;

    private final boolean isHeapMax;

    public MyHeapImpl(boolean isHeapMax) {
        this.myHeap = myHeap;
        this.isHeapMax = isHeapMax;
    }


    @Override
    public void insert(K key, T value) {
        HeapNode<K, T> [] NewValues = new HeapNode[(this.nextIndex + 1) * 2];

        for (int i = 0; i < (this.nextIndex); i++){
            NewValues[i] = this.myHeap[i];
            SetChild(i, NewValues[i]);
        }

        this.myHeap = NewValues;

        HeapNode<K, T> newNode = new HeapNode<>(key, value);

        // Insert newNode in the end
        this.myHeap[this.nextIndex] = newNode;

        int indNewValue = this.nextIndex;
        int indParent = ParentInd(indNewValue);
        this.nextIndex ++;

        if (this.isHeapMax) {

            while(this.myHeap[indNewValue].getKey().compareTo(this.myHeap[indParent].getKey()) > 0
                    && indNewValue != 0){

                ExchangePos(indParent, indNewValue);
                indNewValue = indParent;
                indParent = ParentInd(indNewValue);
            }

        } else { // isHeapMax == false

            while(this.myHeap[indNewValue].getKey().compareTo(this.myHeap[indParent].getKey()) < 0
                    && indNewValue != 0){

                ExchangePos(indParent, indNewValue);
                indNewValue = indParent;
                indParent = ParentInd(indNewValue);
            }

        }


    }

    @Override
    public HeapNode<K, T> getAndDelete() throws EmptyHeap {
        if (this.myHeap[0] == null) {
            throw new EmptyHeap();
        }


        HeapNode<K, T> oldRoot = this.myHeap[0];
        ExchangeNonConsecutive(0, this.nextIndex - 1);


        SetChild(this.nextIndex - 1, null);
        this.myHeap[this.nextIndex -1] = null;
        this.nextIndex --;


        int auxPos = 0;

        /**
         * Reubica el new root.
         */
        if (this.isHeapMax) {

            while((compareKeyMax(auxPos, "right")) || (compareKeyMax(auxPos, "left"))) {

                if((compareKeyMax(auxPos, "right")) && (compareKeyMax(auxPos, "left"))){

                    if (this.myHeap[RightChildInd(auxPos)].getKey().compareTo(this.myHeap[LeftChildInd(auxPos)].getKey()) > 0){

                        ExchangePos(auxPos, RightChildInd(auxPos));
                        auxPos = RightChildInd(auxPos);

                    } else {

                        ExchangePos(auxPos, LeftChildInd(auxPos));
                        auxPos = LeftChildInd(auxPos);

                    }

                } else if (compareKeyMax(auxPos, "right")) {
                    ExchangePos(auxPos, RightChildInd(auxPos));
                    auxPos = RightChildInd(auxPos);

                } else {
                    ExchangePos(auxPos, LeftChildInd(auxPos));
                    auxPos = LeftChildInd(auxPos);

                }
            }

        } else {

            while((compareKeyMin(auxPos, "right")) || (compareKeyMin(auxPos, "left"))){

                if((compareKeyMin(auxPos, "right")) && (compareKeyMin(auxPos, "left"))){

                    if (this.myHeap[RightChildInd(auxPos)].getKey().compareTo(this.myHeap[LeftChildInd(auxPos)].getKey()) < 0){

                        ExchangePos(auxPos, RightChildInd(auxPos));
                        auxPos = RightChildInd(auxPos);

                    } else {

                        ExchangePos(auxPos, LeftChildInd(auxPos));
                        auxPos = LeftChildInd(auxPos);

                    }

                } else if (compareKeyMin(auxPos, "right")) {
                    ExchangePos(auxPos, RightChildInd(auxPos));
                    auxPos = RightChildInd(auxPos);

                } else {
                    ExchangePos(auxPos, LeftChildInd(auxPos));
                    auxPos = LeftChildInd(auxPos);

                }
            }

        }

        return oldRoot;
    }


    @Override
    public int size() {
        return this.nextIndex;
    }

    private int ParentInd (int index){

        return (index - 1) / 2;
    }

    private int LeftChildInd(int parentInd) {

        return (2 * parentInd) + 1;
    }

    private int RightChildInd(int parentInd) {

        return 2 * (parentInd + 1);
    }


    private void ExchangePos(int indParent, int indChild) {

        ExchangeNonConsecutive(indParent, indChild);
        SetChild(indChild, this.myHeap[indChild]);

    }

    private void ExchangeNonConsecutive(int indParent, int indChild) {
        HeapNode<K, T> parent = this.myHeap[indParent];
        HeapNode<K, T> child = this.myHeap[indChild];

        this.myHeap[indChild] = parent;
        this.myHeap[indParent] = child;

        ExchangeChildren(this.myHeap[indChild], this.myHeap[indParent]);
    }

    private void ExchangeChildren(HeapNode<K, T> one, HeapNode<K, T> two) {
        HeapNode<K, T> RCtwo = one.getRightChild();
        HeapNode<K, T> LCtwo = one.getLeftChild();
        HeapNode<K, T> RCone = two.getRightChild();
        HeapNode<K, T> LCone = two.getLeftChild();

        one.setRightChild(RCone);
        one.setLeftChild(LCone);
        two.setRightChild(RCtwo);
        two.setLeftChild(LCtwo);
    }

    private void SetChild(int childPos, HeapNode<K, T> Child) {

        int parentPos = (childPos - 1) / 2;

        if (Math.floorMod(childPos, 2) == 0) { // Right Child
            this.myHeap[parentPos].setRightChild(Child);

        } else { // Left Child
            this.myHeap[parentPos].setLeftChild(Child);

        }
    }

    private boolean compareKeyMax(int aux, String RL){
        boolean result = false;

        if(RL.equals("right")) {
            if (this.myHeap[RightChildInd(aux)] != null){
                if ( ! (this.myHeap[RightChildInd(aux)].getKey().compareTo(this.myHeap[aux].getKey()) < 0)){
                    result = true;
                }
            }

        } else { // RL == left
            if (this.myHeap[LeftChildInd(aux)] != null){
                if ( ! (this.myHeap[LeftChildInd(aux)].getKey().compareTo(this.myHeap[aux].getKey()) < 0)){
                    result = true;
                }
            }

        }

        return result;
    }

    private boolean compareKeyMin(int aux, String RL){
        boolean result = false;

        if(RL.equals("right")) {
            if (this.myHeap[RightChildInd(aux)] != null){
                if ( ! (this.myHeap[RightChildInd(aux)].getKey().compareTo(this.myHeap[aux].getKey()) > 0)){
                    result = true;
                }
            }

        } else { // RL == left
            if (this.myHeap[LeftChildInd(aux)] != null){
                if ( ! (this.myHeap[LeftChildInd(aux)].getKey().compareTo(this.myHeap[aux].getKey()) > 0)){
                    result = true;
                }
            }

        }

        return result;
    }

}