package Q1;

import java.util.*;

public class MSOE2007_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter shadow 1: ");
        double s1 = input.nextDouble();
        System.out.print("Enter shadow 2: ");
        double s2 = input.nextDouble();
        System.out.print("Enter height 1: ");
        double h1 = input.nextDouble();
        double h2 = h1*s2/s1;
        if (s1 <= 0 || s2 <= 0 || h1 <= 0) {
            System.out.println("Please only enter positive, nonzero numbers!");
        } else {
            System.out.println("The second height is: " + h2);
        }
    }
}
/*
Enter shadow 1: 15
Enter shadow 2: 30
Enter height 1: 37
The second height is: 74.0
 */