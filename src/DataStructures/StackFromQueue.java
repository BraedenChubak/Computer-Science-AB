package DataStructures;

import DataStructures.Queue;

public class StackFromQueue<T extends Comparable<T>> {
    private int size;
    private Queue<T> queue1;
    private Queue<T> queue2;

    public StackFromQueue() {
        size = 0;
        queue1 = new Queue<T>();
        queue2 = new Queue<T>();
    }

    public void push(T element) {
        queue1.enqueue(element);
        queue2.enqueue(element);
        size++;
    }

    public T pop() {
        Queue<T> newqueue = new Queue<T>();
        for (int i = 0; i < queue1.size(); i++) {
            newqueue.enqueue(queue2.dequeue());
        }
        T thing = queue2.peek();
        queue1 = newqueue;
        queue2 = queue1;
        size--;
        return thing;
    }

    public T peek() {
        for (int i = 0; i < queue1.size(); i++) {
            queue2.dequeue();
        }
        T thing = queue2.peek();
        queue2 = queue1;
        return thing;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
