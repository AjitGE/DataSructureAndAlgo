import java.util.Arrays;

public class kBinaryNumbers {
    public static void main(String[] args){
        int[] arr= new int[3];
        binary(3,arr);

    }


    public static void binary(int n,int[] arr) {

        if (n < 1) {
            System.out.println(Arrays.toString(arr));
        }
        else {
            arr[n-1]=0;
            binary(n-1,arr);
            arr[n-1]=1;
            binary(n-1,arr);
        }
        }
    }

