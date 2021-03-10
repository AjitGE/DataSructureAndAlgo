package Heap;

public class HeapSort<Integer> extends Heap {
 int[] array;
    public HeapSort(Class clazz) {
        super(clazz);
    }

    public HeapSort(Class clazz, int size) {
        super(clazz, size);
    }

    public int getLeftChildIndex(int parentIndex, int endIndex){
        int count = getCount();
        int leftChildIndex= (parentIndex+1)/2;
     if (parentIndex<0 || endIndex>=count){
         return -1;
     }

         return leftChildIndex;

    }

    public int getRightChildIndex(int parentIndex,int endIndex){
        int count = getCount();
        int rightChildIndex= (parentIndex+2)/2;
        if (parentIndex<0|| endIndex>=count){
            return -1;
        }
        return rightChildIndex;
    }



    private void percolateDown(int parentIndex,int endIndex){
        int leftChildIndex = getLeftChildIndex(parentIndex,endIndex);
        int rightChildIndex = getRightChildIndex(parentIndex,endIndex);


        if (leftChildIndex !=-1 && array[leftChildIndex]<array[parentIndex]){
            swap(leftChildIndex,parentIndex);
            percolateDown(leftChildIndex,endIndex);
        }
        if (rightChildIndex !=-1 && array[rightChildIndex]<array[parentIndex]){
            swap(rightChildIndex,parentIndex);
            percolateDown(rightChildIndex,endIndex);
        }

    }

    private void heapify(int endIndex) {
        int parentIndex= getParentIndex(endIndex);
        int count = getCount();
        while (endIndex >=0)
           {
                percolateDown(parentIndex, endIndex);
                endIndex--;
            }
        }


        public void heapSort(){
        int endIndex= array.length-1;
        heapify(endIndex);

        while(endIndex>0){
            swap(0,endIndex);
            endIndex--;
            percolateDown(0,endIndex);
        }


        }

    }
