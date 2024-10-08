package Q1;

import Algorithms.SortingAlgorithms;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog482h {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/numsort.dat"));
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            System.out.println("Shell Sort\nOriginal List: ");

            while (file.hasNext()) {
                arrayList.add(file.nextInt());
                System.out.print(arrayList.get(arrayList.size()-1));
            }
            System.out.println();
            Integer[] arr;
            arr = (Integer[]) arrayList.toArray();
            SortingAlgorithms.shellSort(arr);


            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
