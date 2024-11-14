package DataStructures;

import DataStructures.Queue;

public class StackFromQueue<T extends Comparable<T>> {
    private int size;
    private Queue<T> queue1;

    public StackFromQueue() {
        size = 0;
        queue1 = new Queue<>();
    }

    public void push(T element) {
        queue1.enqueue(element);
        for (int i = 0; i < queue1.size()-1; i++) {
            queue1.enqueue(queue1.dequeue());
        }
    }

    public T pop() {
        T thing = queue1.dequeue();
        size--;
        return thing;
    }

    public T peek() {
        return queue1.peek();
    }

    public int size() { return queue1.size(); }
    public boolean isEmpty() { return queue1.isEmpty(); }
}
