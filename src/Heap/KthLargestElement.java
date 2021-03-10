package Heap;


public class KthLargestElement {
    int[] array={1,5,7,8,9,0,1,2,4,6,7,8,100};




    public void kthLargestElement(int k){
        MinHeap<Integer> minHeap = new MinHeap<Integer>(Integer.class,k);



      for (int number: array){
        if (minHeap.isEmpty()) {
            minHeap.insert(number);
        }else if(!minHeap.isFull() || minHeap.getElementAtIndex(0)<number){
            if(minHeap.isFull()){
                minHeap.remove();
            }
            minHeap.insertAtMinLocation(number);
        }}
            minHeap.printHeap();
        }




    }

