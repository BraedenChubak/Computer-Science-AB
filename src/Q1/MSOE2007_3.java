package Q1;

import java.util.*;

public class MSOE2007_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side c: ");
        double cSide = input.nextDouble();
        System.out.print("Enter angle A: ");
        double A = input.nextDouble();
        System.out.print("Enter angle B: ");
        double B = input.nextDouble();
        System.out.print("Enter angle C: ");
        double C = input.nextDouble();
        if (A + B + C < 179 || A + B + C > 181) {
            System.out.println("Angles do not add to 180!");
        } else {
            A = Math.toRadians(A);
            B = Math.toRadians(B);
            C = Math.toRadians(C);
            double r = cSide * Math.sin(A / 2) * Math.sin(B / 2) / Math.cos(C / 2);
            System.out.println("The radius of the circle is " + r);
        }
    }
}
