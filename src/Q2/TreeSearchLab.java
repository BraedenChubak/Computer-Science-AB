package Q2;

import DataStructures.BinarySearchTree;

public class TreeSearchLab {
    public static void main(String[] args) {
        // Test set for BFS and DFS
        var tree = new BinarySearchTree<Integer>();

        var rand = new java.util.Random(42);
        for (int i = 0; i < 100; i++) {
            tree.insert(rand.nextInt(100));
        }

        System.out.println("BFS:");
        tree.breadthFirstSearch();

        System.out.println("DFS:");
        tree.depthFirstSearch();
    }
}
/*
BFS:
30 25 63 5 26 48 84 2 18 27 32 56 70 93 0 3 9 19 29 43 52 58 64 82 92 97 1 7 13 23 28 41 46 53 57 60 65 76 87 94 98 12 17 37 42 44 47 59 61 75 79 85 90 96 99 10 34 40 73 86 95 33 35
DFS:
30 25 5 2 0 1 3 18 9 7 13 12 10 17 19 23 26 27 29 28 63 48 32 43 41 37 34 33 35 40 42 46 44 47 56 52 53 58 57 60 59 61 84 70 64 65 82 76 75 73 79 93 92 87 85 86 90 97 94 96 95 98 99
 */