package Q1.Prog285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataStructures.Stack;

public class Prog285bStack {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog285b.dat"));
            var stack = new Stack<Cl285b>();

            System.out.println("Id\tCode\tSales\tCommission");
            while (file.hasNext()) {
                int id = file.nextInt();
                int c = file.nextInt();
                double sales = file.nextDouble();

                var fred = new Cl285b(id, c, sales);
                stack.push(fred);
            }
            file.close();

            while (!stack.isEmpty()) {
                var fred = stack.pop();
                System.out.println(fred);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Id	Code	Sales	Commission
291	17	$750.00	$71.25
264	17	$4150.00	$410.50
235	5	$5250.00	$283.75
218	5	$5000.00	$375.00
203	8	$3250.00	$243.75
192	8	$8125.00	$528.13
138	17	$6375.00	$677.50
125	5	$6500.00	$390.00
118	8	$7350.00	$462.25
117	3	$7350.00	$0.00
103	5	$4000.00	$300.00
101	17	$2250.00	$213.75
 */