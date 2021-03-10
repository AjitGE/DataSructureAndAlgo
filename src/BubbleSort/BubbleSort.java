package BubbleSort;

public class BubbleSort {
    int[] sotedArray;

    public void bubbleSort(int [] array){
        this.sotedArray = array;
        for(int i= 0; i<sotedArray.length ;i++){
            boolean swapped = false;
            for(int j=sotedArray.length-1; j>i;j--){
            if (sotedArray[j]<sotedArray[j-1]){
                int temp = sotedArray[j];
                sotedArray[j] = sotedArray[j-1];
                sotedArray[j-1] = temp;
                swapped =true;
            }
                if (!swapped){
                    break;
                }

                }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<sotedArray.length;i++){
            sb.append(sotedArray[i]);
            if (i==sotedArray.length-1){
                sb.append("]");
            }
            else{
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
