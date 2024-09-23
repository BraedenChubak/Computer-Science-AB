package Q1;

import Algorithms.SortingAlgorithms;
import Utils.Console;

public class Pelican40_1 {
    public static void main(String[] args) {
        Integer[] theArray = {4,2,5,14,3,18,0,9,6,7,11,15,1};
        Integer[] bubbleArray = {4,2,5,14,3,18,0,9,6,7,11,15,1};
        Integer[] insertionArray = {4,2,5,14,3,18,0,9,6,7,11,15,1};
        Integer[] selectionArray = {4,2,5,14,3,18,0,9,6,7,11,15,1};
        SortingAlgorithms.bubbleSort(bubbleArray);
        SortingAlgorithms.insertionSort(insertionArray);
        SortingAlgorithms.selectionSort(selectionArray);

        System.out.println("Unsorted\tBubble\tInsertion\tSelection");
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(theArray[i] + "\t\t\t" + bubbleArray[i] + "\t\t" + insertionArray[i] + "\t\t\t" + selectionArray[i]);
        }
    }
}
