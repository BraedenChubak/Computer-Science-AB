package Q3;
import DataStructures.Heap;

public class HeapLab {
    public static void main(String[] args) {
        var rand = new java.util.Random();
        var minh = new Heap<Integer>(true);
        for (int i = 0; i < 50; i++) {
            minh.insert(rand.nextInt(100));
        }
        System.out.println("Delete: " + minh.delete());
        System.out.println("Peek: " + minh.peek());
        System.out.println("Min Heap:");
        while (!minh.isEmpty()) {
            System.out.print(minh.delete() + " ");
        }
        System.out.println("\n");

        var maxh = new Heap<Integer>(false);
        for (int i = 0; i < 50; i++) {
            maxh.insert(rand.nextInt(100));
        }
        System.out.println("Delete: " + maxh.delete());
        System.out.println("Peek: " + maxh.peek());
        System.out.println("Max Heap:");
        while (!maxh.isEmpty()) {
            System.out.print(maxh.delete() + " ");
        }
        System.out.println("\n");
    }
}
/*
Delete: 2
Peek: 2
Min Heap:
2 5 8 9 9 9 10 13 17 25 26 27 27 31 32 37 39 40 41 45 48 54 58 59 61 63 64 64 68 70 73 75 77 77 82 82 83 84 84 89 92 93 93 95 97 98 98 99 99

Delete: 99
Peek: 99
Max Heap:
99 97 90 86 86 86 85 85 84 83 83 82 80 77 75 72 72 69 64 62 61 58 57 55 54 54 53 53 52 49 49 46 44 43 36 30 25 20 13 13 12 12 9 8 7 7 6 6 2
 */