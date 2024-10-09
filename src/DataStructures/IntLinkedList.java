package DataStructures;

import java.util.Iterator;

public class IntLinkedList implements Iterable<Integer> {
    private class Node {
        int data;
        Node next; // Pointer/reference to next node

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    public IntLinkedList() {
        head = null;
    }

    public void addFront(int data) {
        var newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        var newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void add(int data, int pos) {
        var newNode = new Node(data);
        if (pos < this.size()) {
            Node current = head;
            for (int i = 0; i < pos-1; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
    }

    public int getFirst() { return head.data; }

    public int getLast() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public int getByIndex(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        Node current = head;
        while (current.next.next != null) {
            head = current.next;
        }
        current.next = null;
    }

    public void removeIndex(int index) {
        Node current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }

    public int countLess10() {
        Node current = head;
        int count = 0;
        while (current.next != null) {
            if (current.data < 10) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public void clear() {
        head = null;
    }

    public boolean contains(int n) {
        Node current = head;
        while (current.next != null) {
            if (current.data == n) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = head;

            public boolean hasNext() { return current.next != null; }

            public Integer next() {
                int data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
