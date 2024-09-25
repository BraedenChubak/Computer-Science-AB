package Q1;

import DataStructures.DynamicArray;
import java.util.ArrayList;

public class DynamicArrayLab {
    public static void main(String[] args) {
        System.out.println("========== Dynamic Array ==========");
        var dArray = new DynamicArray<Integer>();
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            dArray.add((int)(Math.random()*100000));
        }
        long end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms"); // ns to ms

        start = System.nanoTime();
        dArray.sort();
        end = System.nanoTime();
        System.out.println("Dynamic Array sort: " + (end-start)/1e6 + " ms"); // ns to ms

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            dArray.remove(0);
        }
        end = System.nanoTime();
        System.out.println("Dynamic Array remove: " + (end-start)/1e6 + " ms"); // ns to ms

        //TODO: check against ArrayList

        System.out.println("\n========== ArrayList ==========");
        var arrayList = new ArrayList<Integer>();
        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            arrayList.add((int)(Math.random()*100000));
        }
        end = System.nanoTime();
        System.out.println("Arraylist add: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        arrayList.sort(null);
        end = System.nanoTime();
        System.out.println("Dynamic Array sort: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            arrayList.remove(0);
        }
        end = System.nanoTime();
        System.out.println("Dynamic Array remove: " + (end-start)/1e6 + " ms");
    }
}
/*
========== Dynamic Array ==========
Dynamic Array add: 8.0794 ms
Dynamic Array sort: 15761.9278 ms
Dynamic Array remove: 28341.6461 ms

========== ArrayList ==========
Arraylist add: 5.7646 ms
Dynamic Array sort: 42.2749 ms
Dynamic Array remove: 400.4929 ms
 */