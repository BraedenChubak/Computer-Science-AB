package Q1;

import DataStructures.DoublyLinkedList;

public class TestDLListRandom {
    public static void main(String[] args) {
        var list = new DoublyLinkedList<Integer>();
        for (int i = 0; i <= 50; i++) {
            int rand =(int) (Math.random() * 100) + 1;
            list.addSorted(rand);
        }
        list.print();

        // TODO: the rest of DLL methods
    }
}
