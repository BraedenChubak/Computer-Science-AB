package Q2;

import java.util.*;
import java.lang.Math;

public class MSOE2007_6 {
    public static double f(double x) {
        return Math.exp(-x*x/2)/Math.sqrt(2*Math.PI);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter A: ");
        double a = input.nextDouble();
        System.out.print("Enter B: ");
        double b = input.nextDouble();
        System.out.print("Enter N: ");
        int n = input.nextInt();
        double h = (b-a) / n;
        double area = f(a);
        for (int i = 1; i < n; i++) {
            area += 2 * f(a + i * h);
        }
        area += f(a + n * h);
        area *= h / 2;
        System.out.println("Estimated Area is " + area);
    }
}
/*
Enter A: -1
Enter B: 2
Enter N: 10
Estimated Area is 0.815965728062905
 */