package Q1;

import java.util.*;

public class MSOE2007_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter starting bin location: ");
        int binStart = input.nextInt();
        System.out.print("Enter bin width: ");
        int binWid = input.nextInt();
        System.out.print("Enter number of bins: ");
        int numBins = input.nextInt();
        System.out.print("Enter number of data points to generate: ");
        int numData = input.nextInt();
        int[] data = new int[numData];
        for (int i = 0; i < numData; i++) {
            data[i] = (int)(Math.random() * (binWid*numBins)) + binStart;
        }
        for (int i = 0; i < numBins; i++) {
            int curBinStart = binStart+binWid*i;
            int curBinEnd = binStart+binWid*(i+1)-1;
            System.out.print(curBinStart + " - " + curBinEnd + "\t");
            for (int j = 0; j < numData; j++) {
                if (data[j] >= curBinStart && data[j] <= curBinEnd) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
/*
Enter starting bin location: 0
Enter bin width: 5
Enter number of bins: 20
Enter number of data points to generate: 200
0 - 4	||||||||||||
5 - 9	||||||||||||||
10 - 14	||||||||||
15 - 19	|||||
20 - 24	||||||
25 - 29	|||||||||
30 - 34	||||||
35 - 39	||||||||||||||
40 - 44	||||||
45 - 49	|||||||||||
50 - 54	|||||||||||||
55 - 59	||||||||||||||
60 - 64	|||||||||
65 - 69	|||||||
70 - 74	|||||||
75 - 79	|||||||||||
80 - 84	||||||||||||
85 - 89	|||||||||||
90 - 94	||||||||||||
95 - 99	|||||||||||
 */