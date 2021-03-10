package InsertionSort;

public class InsertionSort {

    int[] sortedArray;

    public void insertionSort(int[] array){
        sortedArray = array;
        for (int i=0;i<sortedArray.length-1;i++){
            for(int j=i+1;j>0;j--){
                if (sortedArray[j]<sortedArray[j-1]){
                    int temp = sortedArray[j];
                    sortedArray[j]=sortedArray[j-1];
                    sortedArray[j-1]=temp;
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
        for (int i= 0; i<sortedArray.length;i++){
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

}
