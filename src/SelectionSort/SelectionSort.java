package SelectionSort;

public class SelectionSort {
    int[] array1;


    public void selectionSort (int[] array) {
        this.array1=array;
        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j<array1.length; j++) {
                  if (array1[j]<array1[i]){
                      int temp = array[j];
                      array1 [j] = array1[i];
                      array1[i]=temp;
                  }

            }
        }


    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0;i <array1.length;i++){
            sb.append(array1[i]);
            if (i==array1.length-1){
                sb.append("]");
            }
            else{
                sb.append(",");
            }

        }
      return sb.toString();
    }
}
