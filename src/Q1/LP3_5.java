package Q1;

import java.util.*;

public class LP3_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter change (in cents): ");
        int cents = input.nextInt();
        int quarters = cents / 25;
        cents -= quarters * 25;
        int dimes = cents / 10;
        cents -= dimes * 10;
        int nickels = cents / 5;
        cents -= nickels * 5;
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + cents);
    }
}
/*
Enter change (in cents): 212
Quarters: 8
Dimes: 1
Nickels: 0
Pennies: 2
 */