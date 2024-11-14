package Q2;

import DataStructures.StackFromQueue;

public class StackFromQueueTest {
    public static void main(String[] args) {
        StackFromQueue<Integer> stack = new StackFromQueue<>();
        stack.push(10);
        stack.push(5);
        stack.push(7);
        stack.push(21);
        stack.push(37);
        System.out.println(stack.size());
        int s = stack.size();
        for (int i = 0; i < s; i++) {
            System.out.println(stack.pop());
        }
    }
}
