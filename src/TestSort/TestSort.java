package TestSort;

import BubbleSort.BubbleSort;
import InsertionSort.InsertionSort;
import MergeSort.MergeSort;
import QuickSort.QuickSort;
import SelectionSort.SelectionSort;
import ShellSort.ShellSort;

public class TestSort {
    public static void main(String[] args) {
        int[] array1 = {1,-4,6,7,9,5,2};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array1);
        System.out.println(selectionSort);

        int[] array2 = {1,-4,6,7,9,5,2};
        BubbleSort bubbleSort =new BubbleSort();
        bubbleSort.bubbleSort(array2);
        System.out.println(bubbleSort);

        int[] array3 = {1,-4,6,7,9,5,2};
        InsertionSort insertionSort =new InsertionSort();
        insertionSort.insertionSort(array3);
        System.out.println(insertionSort);

        int[] array4 = {4,5,6,2,1,7,10,3,8,9};
        ShellSort shellSort =new ShellSort();
        shellSort.shellSort(array4);
        System.out.println(shellSort);

        int[] array5 = {4,5,6,2,1,7,10,3,8,9};
         MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array5);
        System.out.println(mergeSort);

        int[] array6 = {4,5,6,2,1,7,10,3,8,9};
        QuickSort quickSort= new QuickSort();
        quickSort.quickSort(array6,0, array6.length-1);



        }

    }


