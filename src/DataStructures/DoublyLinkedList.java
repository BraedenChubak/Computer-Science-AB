package DataStructures;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private class Node implements Comparable<Node> {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }

        public int compareTo(Node o) { return data.compareTo(o.data); }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element) {
        var temp = new Node(element);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
        size++;
    }

    public void addFront(T element) {
        var newHead = new Node(element);
        if (head == null) {
            head = newHead;
            tail = newHead;
        } else {
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
        size++;
    }

    public void addSorted(T element) {
        var temp = new Node(element);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            if (temp.data.compareTo(head.data) <= 0) {
                head.prev = temp;
                temp.next = head;
                head = temp;
            } else if (temp.data.compareTo(tail.data) >= 0) {
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            } else {
                Node current = head.next;
                while (temp.data.compareTo(current.data) >= 0 && current.next != null) {
                    current = current.next;
                }
                temp.prev = current.prev;
                temp.next = current;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }
        Node current = head;
        if (index == 0) {
            head = head.next;
            head.prev = null;
        }
        else if (index == size-1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    public void removeObj(T obj) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(obj)) {
                remove(index);
            }
            current = current.next;
            index++;
        }

    }

    public T get(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    public void print() {
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }

    public void printReverse() {
        for (Node current = tail; current != null; current = current.prev) {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public T pop() {
        Node current = head;
        head = head.next;
        head.prev = null;
        return current.data;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node current = head;

            public boolean hasNext() { return current != null; }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
