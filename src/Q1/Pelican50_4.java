package Q1;

import Algorithms.SearchAlgorithms;

public class Pelican50_4 {
    public static void main(String[] args) {
        int i[] = {-7, 15, 21, 22, 43, 49, 51, 67, 78, 81, 84, 89, 95, 97};
        Integer iw[] = new Integer[14];
        for(int k = 0; k < 14; k++) {
            iw[k] = i[k];
        }
        System.out.println(SearchAlgorithms.binarySearchRecursive(iw, 22)); //3
        System.out.println(SearchAlgorithms.binarySearchRecursive(iw, 89)); //11
        System.out.println(SearchAlgorithms.binarySearchRecursive(iw, -100)); //-1
        System.out.println(SearchAlgorithms.binarySearchRecursive(iw, 72)); //-1
        System.out.println(SearchAlgorithms.binarySearchRecursive(iw, 102)); //-1
    }
}
/*
3
11
-1
-1
-1
 */