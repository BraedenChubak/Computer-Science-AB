package Q3;

import java.util.*;
import DataStructures.Heap;

public class Pelican54_7 {
    public static void main(String[] args) {
        String chars = "ACMGDSQNZWPUT";
        Heap<Character> heap = new Heap<>(true);
        char[] charsArr = chars.toCharArray();
        for (char c : charsArr) {
            heap.insert(c);
        }
        int curRow = 1;
        int count = 1;
        for (int i = 0; i < chars.length(); i++) {
            char curChar = heap.delete();
            System.out.print(curChar + " ");
            if (count == Math.pow(2, curRow) - 1) {
                System.out.println();
                curRow++;
            }
            count++;
        }
    }
}
/*
A
C D
G M N P
Q S T U W Z
 */