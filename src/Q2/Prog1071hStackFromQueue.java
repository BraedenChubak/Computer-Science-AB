package Q2;

import DataStructures.StackFromQueue;

import java.io.File;
import java.io.IOException;
import java.util.*;
import Q2.Transaction1071h;

public class Prog1071hStackFromQueue {
    public static void main(String[] args) {
        try {
            StackFromQueue<Transaction1071h> Stack = new StackFromQueue<Transaction1071h>();

            var file2 = new Scanner(new File("Langdat/buysell.dat"));
            while (file2.hasNext()) {
                String buySell = file2.next();
                int code = file2.nextInt();
                int quantity = file2.nextInt();
                if (buySell.equalsIgnoreCase("B")) {
                    double value = file2.nextDouble();
                    Transaction1071h tran = new Transaction1071h(code, quantity, value);
                    Stack.push(tran);
                } else {
                    double value = -1;
                    Transaction1071h tran = new Transaction1071h(code, quantity, value);
                    Stack.push(tran);
                }
            }
            file2.close();

            var file1 = new Scanner(new File("Langdat/bginvtry.dat"));
            while (file1.hasNext()) {
                int code = file1.nextInt();
                int quantity = file1.nextInt();
                double value = file1.nextDouble();
                System.out.println(code + "\t\t" + quantity + "\t\t" + value);
                Transaction1071h tran = new Transaction1071h(code, quantity, value);
                Stack.push(tran);
            }
            file1.close();



        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
