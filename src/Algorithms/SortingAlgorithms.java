package Algorithms;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings({"unchecked", "unusued", "ManualArrayCopy"})
public class SortingAlgorithms {
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }


    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (i = 1; i < arr.length; i++) {
            var key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {

            }
        }
    }


    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            var min = arr[i];
            if (arr[i].compareTo(min) < 0) { min = arr[i]; }

        }
    }
}