package DataStructures;

import DataStructures.LinkedList;

public class CircularQueue<T extends Comparable<T>> {

    protected LinkedList<T> queue;
    protected int size;
    protected int capacity;

    public CircularQueue(int cap) {
        size = 0;
        capacity = cap;
        queue = new LinkedList<>();
    }

    public void enqueue(T element) {
        if (size < capacity) {
            queue.add(element);
            size++;
        }
    }

    public T dequeue() {
        T element = queue.get(0);
        size--;
        queue.remove(0);
        return element;
    }

    public T peek() { return queue.get(0); }
    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }


}
