package BInarySearch;

public class BinarySearch {


    public static  void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(array,7));


    }

    public static int binarySearch(int[] sortedArray, int elementToSearch) {
        int min=0;
        int max=sortedArray.length-1;

        while (min<=max){
            int middle = min+(max-min)/2;
            if (sortedArray[middle]== elementToSearch){
                return  middle;
            }
            else if (sortedArray[middle]<elementToSearch){
               min=middle+1;
            }
            else {
                max=middle-1;
            }
        }
        return -1;
    }
}
