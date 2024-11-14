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
                System.out.println(buySell + " " + code + " " + quantity + " " + value);
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
            System.out.println(Stack.size());

            for (int i = 0; i < Stack.size(); i++) {
                Transaction1071h t = Stack.pop();
                System.out.println(t.prodCode + "\t\t" + t.quantity+ "\t\t" + t.value);
            }



        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
