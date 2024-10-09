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

    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                T val = arr[i];
                int j = i;
                while (j > h - 1 && arr[j-h].compareTo(val) >= 0) {
                    arr[j] = arr[j-h];
                    j -= h;
                }
                arr[j] = val;
            }
            h = (h-1) / 3;
        }
    }


    public static <T extends Comparable<T>> void insertionSort(T[] arr) { insertionSort(arr, arr.length); }

    public static <T extends Comparable<T>> void insertionSort(T[] arr, int n) {
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }


    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            var min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) { minIndex = j; }
            }
            swap(arr, minIndex, i);
        }
    }
}
/*
Unsorted	Bubble	Insertion	Selection
4			0		0			0
2			1		1			1
5			2		2			2
14			3		3			3
3			4		4			4
18			5		5			5
0			6		6			6
9			7		7			7
6			9		9			9
7			11		11			11
11			14		14			14
15			15		15			15
1			18		18			18
 */