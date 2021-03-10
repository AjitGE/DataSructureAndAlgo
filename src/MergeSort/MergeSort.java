package MergeSort;

public class MergeSort {
    int[] sortedArray;

    public void mergeSort(int[] array){

        if (array.length==1 ){
           return;
        }
        int leftArrayLength= array.length/2 + array.length %2;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[array.length-leftArrayLength];
        System.arraycopy(array,0,leftArray,0,leftArrayLength);
        System.arraycopy(array,leftArrayLength,rightArray,0,rightArray.length);

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array,leftArray,rightArray);
        sortedArray=array;
    }
@Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for(int i=0; i<sortedArray.length;i++){
            sb.append(sortedArray[i]);
            if(i==sortedArray.length-1){
                sb.append("]");
            }
            else{
                sb.append(",");
            }

        }
        return sb.toString();
    }

    private void merge(int[] sortedArray,int[] leftArray, int[] rightArray) {
        int startIndexForMainArray=0;
        int startIndexForLeftArray=0;
        int startIndexForRightArray=0;



            while( startIndexForLeftArray<leftArray.length && startIndexForRightArray<rightArray.length){
               if(leftArray[startIndexForLeftArray]<rightArray[startIndexForRightArray]){
                   sortedArray[startIndexForMainArray]=leftArray[startIndexForLeftArray];
                   startIndexForLeftArray++;
               }
               else if (rightArray[startIndexForRightArray]<leftArray[startIndexForLeftArray]){
                   sortedArray[startIndexForMainArray]=rightArray[startIndexForRightArray];
                   startIndexForRightArray++;
               }
                startIndexForMainArray++;
            }
              while(startIndexForMainArray<sortedArray.length){
               if(startIndexForLeftArray<leftArray.length){
                   sortedArray[startIndexForMainArray++]=leftArray[startIndexForLeftArray++];

               }
                if (startIndexForRightArray<rightArray.length){
                   sortedArray[startIndexForMainArray++]=rightArray[startIndexForRightArray++];

               }
           }
    }


    }













