package QuickSort;

public class QuickSort {
    int[] sortedArray;


    public void quickSort(int[] array, int startIndex, int endIndex) {

        if (startIndex > endIndex) {


            int partitionIndex = partition(array, startIndex, endIndex);
            quickSort(array, startIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, endIndex);
            sortedArray = array;
        }
    }


    private int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int partitionIndex = startIndex;

        for (int i = startIndex; i < endIndex - 1; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[partitionIndex];
                array[partitionIndex] = temp;
                partitionIndex++;
            }
        }
        int temp = array[partitionIndex];
        array[partitionIndex] = array[endIndex];
        array[endIndex] = temp;
        return partitionIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < sortedArray.length; i++) {
            sb.append(sortedArray[i]);
            if (i == sortedArray.length - 1) {
                sb.append("]");
            } else {
                sb.append(",");
            }
        }
        return sb.toString();

    }

}
