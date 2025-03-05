package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Algorithms.SortingAlgorithms;

public class Prog485aHeapSort {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog485a.dat"));
            ArrayList<Integer> nums = new ArrayList<>();

            while (file.hasNext()) {
                nums.add(file.nextInt());
            }
            file.close();
            System.out.println("Original List:");
            int lineCount = 0;
            for (int n : nums) {
                System.out.print(n + " ");
                lineCount++;
                if (lineCount == 10) {
                    System.out.println();
                    lineCount = 0;
                }
            }
            System.out.println();

            Integer[] numsArr = new Integer[nums.size()];
            for (int i = 0; i < nums.size(); i++) {
                numsArr[i] = nums.get(i);
            }
            SortingAlgorithms.heapSort(numsArr);

            System.out.println("Sorted List:");
            lineCount = 0;
            for (int n : numsArr) {
                System.out.print(n + " ");
                lineCount++;
                if (lineCount == 10) {
                    System.out.println();
                    lineCount = 0;
                }
            }
            System.out.println();

            System.out.println("Frequency:");
            int curcount = 0;
            int curNum = numsArr[0];
            for (int i = 0; i < numsArr.length; i++) {
                if (numsArr[i] == curNum) {
                    curcount++;
                } else {
                    System.out.println(curNum + "\t" + curcount);
                    curcount = 1;
                    curNum = numsArr[i];
                }
            }
            System.out.println(curNum + "\t" + curcount);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Original List:
80 75 50 50 50 50 60 60 40 40
25 45 50 45 45 50 50 50 20 20
10 85 85 100 100 50 50 100 10 90
10 70 70 70 70 60 60 60 90 90
80 20 10 40 5 95 50 50 50
Sorted List:
5 10 10 10 10 20 20 20 25 40
40 40 45 45 45 50 50 50 50 50
50 50 50 50 50 50 50 50 60 60
60 60 60 70 70 70 70 75 80 80
85 85 90 90 90 95 100 100 100
Frequency:
5	1
10	4
20	3
25	1
40	3
45	3
50	13
60	5
70	4
75	1
80	2
85	2
90	3
95	1
100	3

Process finished with exit code 0

 */