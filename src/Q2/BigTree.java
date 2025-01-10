package Q2;

import DataStructures.BinarySearchTree;

public class BigTree {
    public static int total(BinarySearchTree<Integer> bst) {
        return total(bst.root);
    }

    private static int total(BinarySearchTree<Integer>.Node node) {
        if (node == null) { return 0; }
        return node.data + total(node.left) + total(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < 50; i++) {
            int r = (int)(Math.random() * 100) + 1;
            System.out.print(r + " ");
            tree.insert(r);
        }

        System.out.println("In Order");
        tree.printInOrder();
        System.out.println("Pre Order");
        tree.printPreOrder();
        System.out.println("Post Order");
        tree.printPostorder();

        int total = total(tree);
        System.out.println("The total of the nums is: " + total);

        System.out.println("Is the number 32 in the tree? " + tree.search(32));

        tree.insert(51);
        tree.insert(102);
        tree.printInOrder();

        double average = total / 52.0;
        double decimal = average % 1;
        boolean addOrSub;
        if (decimal >= 0.5) {
            average += 1 - decimal;
            addOrSub = true;
        }
        else {
            average -= decimal;
            addOrSub = false;
        }
        int tries = 0;
        boolean found = false;
        while (!found) {
            if (addOrSub) {
                average += tries;
            } else {
                average -= tries;
            }
            addOrSub = !addOrSub;
            found = tree.search((int)average);
            tries++;
        }
        tree.delete((int) average);

        System.out.println("Depth: " + tree.height());
        System.out.println("Width: " + tree.width());
        tree.invert();
        tree.printInOrder();

        tree.breadthFirstSearch();
        tree.depthFirstSearch();
    }
}
/*
27 86 65 98 43 1 95 78 43 50 36 28 83 43 19 61 5 77 58 28 23 60 71 41 97 43 12 1 9 24 48 83 31 30 100 72 23 38 65 53 22 34 54 18 82 83 55 96 30 98 In Order
1 5 9 12 18 19 22 23 24 27 28 30 31 34 36 38 41 43 48 50 53 54 55 58 60 61 65 71 72 77 78 82 83 86 95 96 97 98 100
Pre Order
27 1 19 5 12 9 18 23 22 24 86 65 43 36 28 31 30 34 41 38 50 48 61 58 53 54 55 60 78 77 71 72 83 82 98 95 97 96 100
Post Order
9 18 12 5 22 24 23 19 1 30 34 31 28 38 41 36 48 55 54 53 60 58 61 50 43 72 71 77 82 83 78 65 96 97 95 100 98 86 27
The total of the nums is: 1980
Is the number 32 in the tree? true
1 5 9 12 18 19 22 23 24 27 28 30 31 34 36 38 41 43 48 50 51 53 54 55 58 60 61 65 71 72 77 78 82 83 86 95 96 97 98 100 102
Depth: 10
Width: 9
102 100 98 97 96 95 86 83 82 78 77 72 71 65 61 60 58 55 54 53 51 50 48 43 41 36 34 31 30 28 27 24 23 22 19 18 12 9 5 1
27 86 1 98 65 19 100 95 78 43 23 5 102 97 83 77 50 36 24 22 12 96 82 71 61 48 41 28 18 9 72 58 31 60 53 34 30 54 51 55
27 86 98 100 102 95 97 96 65 78 83 82 77 71 72 43 50 61 58 60 53 54 55 51 48 36 41 28 31 34 30 1 19 23 24 22 5 12 18 9
 */