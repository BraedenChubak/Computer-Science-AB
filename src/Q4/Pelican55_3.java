package Q4;

import DataStructures.PriorityQueue;

public class Pelican55_3 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(true);

        pq.enqueue(8);
        pq.enqueue(2);
        pq.enqueue(1);
        pq.enqueue(9);
        pq.enqueue(5);
        pq.enqueue(4);

        while (!pq.isEmpty()) {
            System.out.println(pq.dequeue());
        }
    }
}
/*
1
2
4
5
8
9
 */