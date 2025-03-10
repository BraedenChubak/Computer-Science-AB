package Q2;

import DataStructures.BinarySearchTree;

public class BinaryTreeDeleteTest {
    public static void main(String[] args) {
        var tree = new BinarySearchTree<Integer>();
        for (int x : new int[]{5, 1, 3, 9, 8, 2, 4, 6, 7}) {
            tree.insert(x);
        }
        tree.printInOrder();
        tree.delete(5);
        tree.printInOrder();
    }
}
/*
1 2 3 4 5 6 7 8 9
1 2 3 4 6 7 8 9
 */