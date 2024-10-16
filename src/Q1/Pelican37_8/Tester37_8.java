package Q1.Pelican37_8;

import java.io.*;
import java.util.*;

public class Tester37_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Slope: ");
        double m = input.nextDouble();
        System.out.print("Intercept: ");
        double b = input.nextDouble();
        var line = new Pelican37_8(m, b);
        System.out.println("Slope is: " + line.getSlope());
        System.out.println("Intercept is: " + line.getYintercept());
        System.out.println("Root is: " + line.getRoot());

        System.out.print("Enter X value: ");
        double x = input.nextDouble();
        System.out.println("Y value at that X is " + line.getYvalue(x));
        System.out.print("Enter Y value: ");
        double y = input.nextDouble();
        System.out.println("X value at that Y is " + line.getXvalue(y));
    }
}
/*
Slope: -3
Intercept: 2.5
Slope is: -3.0
Intercept is: 2.5
Root is: 0.8333333333333334
Enter X value: -4.61
Y value at that X is 16.330000000000002
Enter Y value: 5
X value at that Y is -0.8333333333333334
 */
