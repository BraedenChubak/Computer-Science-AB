package Q2;

import DataStructures.RedBlackTree;

public class RBTreeLab {
    public static void main(String[] args) {
        var t1 = new RedBlackTree<String>();
        t1.insert("The");
        t1.insert("quick");
        t1.insert("brown");
        t1.insert("fox");
        t1.insert("apple");
        t1.insert("cat");
        t1.insert("hat");
        t1.printInOrder();
        System.out.println();

        var t2 = new RedBlackTree<Integer>();
        t2.insert(30);
        t2.insert(40);
        t2.insert(12);
        t2.insert(31);
        t2.insert(42);
        t2.insert(86);
        t2.insert(67);
        t2.insert(18);
        t2.insert(4);
        t2.insert(124);
        t2.insert(53);
        t2.insert(75);
        t2.printInOrder();
        t2.display();
        System.out.println();


    }
}
