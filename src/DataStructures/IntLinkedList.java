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
        if (pos == this.size()) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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
        if (index >= this.size() || index < 0) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public Node getNodeByIndex(int index) {
        if (index >= this.size() || index < 0) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public Node getLastNodeByData(int data) {
        Node current = head;
        Node node = null;
        while (current != null) {
            if (current.data == data) {
                node = current;
            }
            current = current.next;
        }
        return node;
    }

    public IntLinkedList getReverse() {
        IntLinkedList reverse = new IntLinkedList();
        Node current = head;
        Node startRev = head;
        while (startRev.next != null) {
            startRev = startRev.next;
        }
        reverse.addFront(startRev.data);
        for (int i = 0; i < this.size()-1; i++) {
            reverse.add(current.data, 1);
            current = current.next;
        }
        return reverse;
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void removeIndex(int index) {
        Node current = head;
        if (index == 0) {
            head = current.next;
        } else {
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public void sort() {
        IntLinkedList sorted = new IntLinkedList();
        int sizeLock = this.size();
        for (int i = 0; i < sizeLock-1; i++) {
            int curData = this.max();
            Node max = this.getLastNodeByData(curData);
            sorted.addFront(max.data);
            this.removeIndex(lastIndexMax());
        }
        sorted.addFront(head.data);
        head = sorted.head;

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

    public int getCount() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
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

    public double avg() {
        double total = 0;
        Node current = head;
        while (current != null) {
            total += current.data;
            current = current.next;
        }
        return total / this.size();
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        Node current = head;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    public int lastIndexMin() {
        int min = Integer.MAX_VALUE;
        int curIndex = 0;
        int minIndex = 0;
        Node current = head;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
                minIndex = curIndex;
            }
            current = current.next;
            curIndex++;
        }
        return minIndex;
    }

    public int lose58() {
        Node current = head;
        int count58 = 0;
        int index = 0;
        while (current != null) {
            if (current.data == 58) {
                removeIndex(index);
                count58++;
            }
            index++;
            current = current.next;
        }
        return count58;
    }

    public int getEvenCount() {
        Node current = head;
        int countEven = 0;
        while (current != null) {
            if (current.data % 2 == 0) {
                countEven++;
            }
            current = current.next;
        }
        return countEven;
    }

    public void removeOdds() {
        while (this.size() != this.getEvenCount()) {
            Node current = head;
            int index = 0;
            while (current != null) {
                if (current.data % 2 == 1) {
                    removeIndex(index);
                    index--;
                }
                index++;
                current = current.next;
            }
        }
    }

    public int max() {
        int max = Integer.MIN_VALUE;
        Node current = head;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    public int indexMax() {
        int max = Integer.MIN_VALUE;
        int curIndex = 0;
        int maxIndex = 0;
        Node current = head;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
                maxIndex = curIndex;
            }
            current = current.next;
            curIndex++;
        }
        return maxIndex;
    }


    public int lastIndexMax() {
        int max = Integer.MIN_VALUE;
        int curIndex = 0;
        int maxIndex = 0;
        Node current = head;
        while (current != null) {
            if (current.data >= max) {
                max = current.data;
                maxIndex = curIndex;
            }
            current = current.next;
            curIndex++;
        }
        return maxIndex;
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
