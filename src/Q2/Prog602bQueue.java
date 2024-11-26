package Q2;

import DataStructures.Queue;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog602bQueue {
    public static double func (double hours, int code) {
        double cost = 0;
        if (code == 1) {
            cost = 50;
        } if (code == 2) {
            cost = 150;
        }
        if (hours > 15) {
            cost += 550 + 30 * (hours - 15);
        } else if (hours > 5) {
            cost += 200 + 30 * (hours - 5);
        } else {
            cost += 200;
        }
        return cost;
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog602b.dat"));
            System.out.println("Account #\tHours\tCode\tAmount Due");
            Queue<Integer> allAccounts = new Queue<>();
            Queue<Double> allHours = new Queue<>();
            Queue<Integer> allCodes = new Queue<>();
            int acc;
            double hours;
            int code;
            while (file.hasNext()) {
                acc = file.nextInt();
                hours = file.nextDouble();
                code = file.nextInt();
                allAccounts.enqueue(acc);
                allHours.enqueue(hours);
                allCodes.enqueue(code);
            }

            while (!allAccounts.isEmpty()) {
                acc = allAccounts.dequeue();
                hours = allHours.dequeue();
                code = allCodes.dequeue();
                double cost = func(hours, code);
                System.out.printf("%d\t\t%.2f\t%d\t\t%.2f\n", acc, hours, code, cost);
            }

            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Account #	Hours	Code	Amount Due
1825		3.25	0		200.00
14063		17.06	1		661.80
17185		7.93	1		337.90
19111		12.00	2		560.00
20045		5.00	1		250.00
21352		5.84	0		225.20
22841		27.90	2		1087.00
23051		1.55	2		350.00
29118		15.02	0		550.60
 */