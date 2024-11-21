package DataStructures;

@SuppressWarnings("unchecked")

public class CircularDeque<T extends Comparable<T>> extends CircularQueue {
    public CircularDeque(int cap) {
        super(cap);
    }

    public void enqueueFront(T element) {
        super.queue.add(element);
        for (int i = 0; i < size-1; i++) {
            super.queue.add(super.queue.remove(0));
        }
    }

    public void enqueueRear(T element) { enqueue(element); }

    public T dequeueFront() { return (T) dequeue(); }

    public T dequeueRear() {
        T element = (T) super.queue.get(size-1);
        super.queue.remove(size-1);
        return element;
    }
}
