package Heap;

public class MinHeap<T extends Comparable<? super T>> extends Heap<T>{


    public MinHeap(Class<T> clazz){
        super(clazz);
    }

    public MinHeap(Class<T> clazz,int size){
        super(clazz,size);
    }

@Override
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
    @Override
    protected void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        if (parentIndex != -1 &&
                (getElementAtIndex(parentIndex).compareTo(getElementAtIndex(index)) > 0)) {
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }








    }
