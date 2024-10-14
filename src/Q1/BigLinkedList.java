package Q1;

import DataStructures.IntLinkedList;

public class BigLinkedList {
    public static void main(String[] args) {
        var list = new IntLinkedList();
        for (int i = 0; i < 200; i++) {
            list.addFront((int)(Math.random() * 100 + 1));
        }

        list.addFront(101);
        list.print();

        list.addLast(102);
        list.print();

        System.out.println(list.getCount() + " items");
        list.print();

        list.add((int)(Math.random() * 100 + 1), 2);
        list.print();

        System.out.println("Is the list empty? " + list.isEmpty());
        list.print();

        System.out.println("The first item is " + list.getFirst());
        System.out.println("The last item is " + list.getLast());
        list.print();

        System.out.println("The data at index 10 is " + list.getByIndex(10));
        list.print();

        list.removeFirst();
        list.print();

        list.removeLast();
        list.print();

        System.out.println("The number of nodes under 10 is: " + list.countLess10());
        list.print();

        list.removeIndex(5);
        list.print();

        System.out.println("Does the list contain 57? " + list.contains(57));
        list.print();

        System.out.println("Reversed list created! Printing now... ");
        list.getReverse().print();

        var iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("The average is " + list.avg());
        list.print();

        System.out.println("The min is " + list.min());
        list.print();

        System.out.println("The max is " + list.max());
        list.print();

        System.out.println("The index of the max is: " + list.indexMax());
        list.print();

        System.out.println("The last index of the max is: " + list.lastIndexMax());
        list.print();

        list.sort();
        list.print();

        System.out.println("Removed " + list.lose58() + " 58s");
        list.print();

        System.out.println("There are " + list.getEvenCount() + " even nums");
        list.print();

        list.removeOdds();
        list.print();

        list.clear();
    }
}
