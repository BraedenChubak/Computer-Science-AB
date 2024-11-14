package Q2;

import DataStructures.StackFromQueue;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog1071hStackFromQueue {
    public static void main(String[] args) {
        try {
            StackFromQueue<Transaction1071h> Stack = new StackFromQueue<>();

            var file2 = new Scanner(new File("Langdat/buysell.txt"));
            while (file2.hasNext()) {
                String buySell = file2.next();
                int code = file2.nextInt();
                int quantity = file2.nextInt();
                double value;
                if (buySell.equalsIgnoreCase("B")) {
                    value = file2.nextDouble();
                } else {
                    value = -1.0;
                }
                Transaction1071h tran = new Transaction1071h(code, quantity, value);
                Stack.push(tran);
            }
            file2.close();

            var file1 = new Scanner(new File("Langdat/bginvtry.txt"));
            while (file1.hasNext()) {
                int code = file1.nextInt();
                int quantity = file1.nextInt();
                double value = file1.nextDouble();
                System.out.println(code + "\t\t" + quantity + "\t\t" + value);
                Transaction1071h tran = new Transaction1071h(code, quantity, value);
                Stack.push(tran);
            }
            file1.close();

            int s = Stack.size();
            Stack<Transaction1071h> processedTrans = new Stack<>();
            Stack<Transaction1071h> savedTrans = new Stack<>();

            for (int i = 0; i < s; i++) {
                Transaction1071h curTrans = Stack.pop();
                if (curTrans.value != -1) {
                    processedTrans.push(curTrans);
                } else {
                    while (curTrans.quantity > 0) {
                        Transaction1071h lookingForCode = processedTrans.pop();
                        if (curTrans.prodCode == lookingForCode.prodCode) {
                            if (curTrans.quantity >= lookingForCode.quantity) {
                                curTrans.quantity -= lookingForCode.quantity;
                                lookingForCode.quantity = 0;
                            } else {
                                lookingForCode.quantity -= curTrans.quantity;
                                curTrans.quantity = 0;
                            }
                        }
                        savedTrans.push(lookingForCode);
                    }
                    int s2 = savedTrans.size();
                    for (int j = 0; j < s2; j++) {
                        processedTrans.push(savedTrans.pop());
                    }
                }
            }
            System.out.println("\nEnding Inventory");
            s = processedTrans.size();
            for (int i = 0; i < s; i++) {
                Transaction1071h t = processedTrans.pop();
                if (t.quantity != 0) {
                    System.out.println(t.prodCode + "\t\t" + t.quantity + "\t\t" + t.value);
                }
            }



        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
1		50		1298.0
2		50		107.5
3		100		248.85
4		5000		1.07
5		20		489.75
6		5		586.24
7		30		84.23
8		600		24.73
9		1500		19.99
10		15		238.99

Ending Inventory
10		9		250.0
5		2		510.25
7		10		87.5
4		750		1.1
1		13		1298.0
2		2		107.5
3		87		248.85
4		5000		1.07
5		20		489.75
6		4		586.24
7		30		84.23
8		600		24.73
9		1010		19.99
10		15		238.99
 */