package ShellSort;

public class ShellSort {
    int[] sortedArray;
   public void shellSort(int[] array){
       this.sortedArray = array;
       int increment = sortedArray.length/2;
       while (increment>=1){

           for (int startIndex=0;startIndex<increment;startIndex++){
           insertionSort(sortedArray,startIndex,increment);
           }
           increment =increment/2;
       }

   }

    private void insertionSort(int[] sortedArray, int startIndex, int increment) {
       for(int i=startIndex;i<sortedArray.length;i+=increment){
           for(int j = Math.min(i+increment,sortedArray.length-1);j - increment >= 0; j-=increment){
               if(sortedArray[j]<sortedArray[j-increment]){
                   int temp = sortedArray[j];
                   sortedArray[j]=sortedArray[j-1];
                   sortedArray[j-1]= temp;
               }
               else{
                   break;
               }

           }
       }
    }

    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("[");
       for(int i=0;i<sortedArray.length;i++){
           sb.append(sortedArray[i]);
           if (i==sortedArray.length-1){
               sb.append("]");

           }
           else {
               sb.append(",");
           }
       }
       return sb.toString();
    }
}
