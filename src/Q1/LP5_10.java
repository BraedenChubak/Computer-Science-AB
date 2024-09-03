package Q1;

import java.util.*;

public class LP5_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first num: ");
        int num1 = input.nextInt();
        System.out.print("Enter second num: ");
        int num2 = input.nextInt();
        while (num2 > 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        System.out.println("The GCD is " + num1);
    }
}
/*
Enter first num: 1984
Enter second num: 3928
The GCD is 8
 */