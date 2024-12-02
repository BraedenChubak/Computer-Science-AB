package Q2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Algorithms.SortingAlgorithms;

public class Prog575aMergeSort {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog575a.dat"));
            ArrayList<String> list = new ArrayList<>();

            while (file.hasNext()) {
                list.add(file.next());
            }

            String[] listArr = new String[list.size()];

            System.out.println("Original List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                listArr[i] = list.get(i);
            }

            SortingAlgorithms.mergeSort(listArr);

            System.out.println("\nSorted List:");
            for (int i = 0; i < listArr.length; i++) {
                System.out.println(listArr[i]);
            }

            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Original List:
ONE
TWO
THREE
FOUR
FIVE
SIX
SEVEN
EIGHT
NINE
TEN
ELEVEN
TWELVE
THIRTEEN

Sorted List:
EIGHT
ELEVEN
FIVE
FOUR
NINE
ONE
SEVEN
SIX
TEN
THIRTEEN
THREE
TWELVE
TWO
 */