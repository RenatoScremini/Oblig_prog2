package Tads;

import ExceptionsTads.EmptyHeap;

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

    }

    @Override
    public HeapNode<K, T> getAndDelete() throws EmptyHeap {
        return null;
    }


    @Override
    public int size() {
        return 0;
    }

    private int LeftChildInd(int parentInd) {

        return (2 * parentInd) + 1;
    }

    private int RightChildInd(int parentInd) {

        return 2 * (parentInd + 1);
    }


    private void ExchangeNonConsecutive(int indParent, int indChild) {
        HeapNode<K, T> parent = this.myHeap[indParent];
        HeapNode<K, T> child = this.myHeap[indChild];

        this.myHeap[indChild] = parent;
        this.myHeap[indParent] = child;

        ExchangeChildren(this.myHeap[indChild], this.myHeap[indParent]);
    }

    private void ExchangePos(int indParent, int indChild) {

        ExchangeNonConsecutive(indParent, indChild);
        SetChild(indChild, this.myHeap[indChild]);

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

}