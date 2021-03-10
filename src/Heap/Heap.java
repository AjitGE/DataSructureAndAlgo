package Heap;

import java.lang.reflect.Array;


public class Heap<T extends Comparable<? super T>> {
    private static final int size=40;
    private T[] elements;
    private int count=0;

    public Heap(Class<T> clazz){
        this(clazz,size);
    }
    public Heap(Class<T> clazz, int size){
        elements = (T[])Array.newInstance(clazz,size);
    }

    public int getCount() {
        return count;
    }
    public int getLeftChildIndex(int index){
      int leftChildIndex = 2* index +1;
      if (index>=count){
          return -1;
      }
      return leftChildIndex;
    }

    public int getRightChildIndex(int index){
        int rightChildIndex=2*index+2;
        if (index>=count){
            return -1;
        }
        return rightChildIndex;
    }

    public int getParentIndex(int index){
        int parentIndex= (index-1)/2;
        if (index<0||index>=count){
            return -1;
        }
        return parentIndex;
    }

    public boolean isEmpty(){
        return count == 0;

    }
    public boolean isFull(){
        return count ==size;

    }
    public void swap(int index1, int index2){
        T temp = elements[index1];
        elements[index1]= elements[index2];
        elements[index2]=temp;


    }

    public void insert(T data){

        if(isEmpty()){
          elements[0]=data;

        }
        else{
            elements[count]=data;
            siftUp(count);
        }
        count++;
    }

    public T remove() {
        T removedData;
        if (isEmpty()) {
            return null;
        } else {
            removedData = elements[0];
           elements[0]=elements[count-1];
            count--;
            siftDown(0);
        }
        return removedData;
    }

    protected void siftDown(int index){
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int smallIndex = -1;
        if (leftChildIndex!=-1 && rightChildIndex !=-1){
            smallIndex= getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex))<0
                    ?leftChildIndex:rightChildIndex;

        }
        if (leftChildIndex!=-1){
            smallIndex = leftChildIndex;
        }
        if (rightChildIndex==-1){
            smallIndex =rightChildIndex;
        }
        if (smallIndex==-1){
            return;
        }
        if (getElementAtIndex(index).compareTo(getElementAtIndex(smallIndex))>0){
            swap(index,getParentIndex(index));
            siftDown(smallIndex);
        }

    }
    protected void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        if (parentIndex != -1 &&
                (getElementAtIndex(parentIndex).compareTo(getElementAtIndex(index)) > 0)) {
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }
    public T getElementAtIndex(int index){
        return elements[index];
    }

    protected void insertAtMinLocation(T data) {
        elements[0]=data;
        siftDown(0);

    }
    protected void printHeap() {

        for(T number : elements){
            System.out.println(number);
        }

    }
}
