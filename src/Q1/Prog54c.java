package Q1;

import java.util.*;

public class Prog54c {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double PI = 3.14159;
        System.out.print("Enter Radius: ");
        double rad = input.nextDouble();
        double area = PI * Math.pow(rad, 2);
        double circum = 2 * PI * rad;
        System.out.println("Area is " + area +
                           "\nCircumference is " + circum);
    }
}
/*
Enter Radius: 6.5
Area is 132.7321775
Circumference is 40.840669999999996
 */
