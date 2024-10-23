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

        list.remove(0);
        list.print();

        System.out.println("The item at index 6 is " + list.get(6));

        list.set(4, 99);
        list.print();

        System.out.println("The list contains " + list.size() + " elements");
        list.print();

        System.out.println("This is the list in reverse!");
        list.printReverse();
    }
}
/*
1 1 3 3 5 6 6 7 8 8 12 13 13 14 17 17 23 24 29 35 35 36 36 37 46 48 49 51 52 53 56 58 62 64 65 66 66 67 69 70 71 72 73 74 81 82 84 98 99 99 100
1 3 3 5 6 6 7 8 8 12 13 13 14 17 17 23 24 29 35 35 36 36 37 46 48 49 51 52 53 56 58 62 64 65 66 66 67 69 70 71 72 73 74 81 82 84 98 99 99 100
The item at index 6 is 7
1 3 3 5 99 6 7 8 8 12 13 13 14 17 17 23 24 29 35 35 36 36 37 46 48 49 51 52 53 56 58 62 64 65 66 66 67 69 70 71 72 73 74 81 82 84 98 99 99 100
The list contains 50 elements
1 3 3 5 99 6 7 8 8 12 13 13 14 17 17 23 24 29 35 35 36 36 37 46 48 49 51 52 53 56 58 62 64 65 66 66 67 69 70 71 72 73 74 81 82 84 98 99 99 100
This is the list in reverse!
100 99 99 98 84 82 81 74 73 72 71 70 69 67 66 66 65 64 62 58 56 53 52 51 49 48 46 37 36 36 35 35 29 24 23 17 17 14 13 13 12 8 8 7 6 99 5 3 3 1 
 */
