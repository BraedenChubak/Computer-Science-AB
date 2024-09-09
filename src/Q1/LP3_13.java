package Q1;

import Utils.Console;

public class LP3_13 {
    public static void main(String[] args) {
        String choice = Console.input("Do you want Part A (A) or Part B (B)? ");
        if (choice.equals("A")) {
            double p = Console.input("Enter the principal: $");
            int y = Console.input("Enter the # of years: ");
            double r = Console.input("Enter the interest rate (decimal): ");
            double amnt = p * (1 + y * r);
            System.out.println("The value after " + y + " years is $" + amnt);
        } else if (choice.equals("B")) {
            double amnt = Console.input("Enter the desired amount: $");
            int y = Console.input("Enter the # of years: ");
            double r = Console.input("Enter the interest rate (decimal): ");
            double p = amnt / (1 + y * r);
            System.out.println("The principal that needs to be invested is $" + p);
        } else {
            System.out.println("Not a valid choice, try again!");
        }
    }
}
/*
Do you want Part A (A) or Part B (B)? A
Enter the principal: $5000.00
Enter the # of years: 5
Enter the interest rate (decimal): 0.06
The value after 5 years is $6500.0

Do you want Part A (A) or Part B (B)? B
Enter the desired amount: $6500.00
Enter the # of years: 5
Enter the interest rate (decimal): 0.06
The principal that needs to be invested is $5000.0

Do you want Part A (A) or Part B (B)? not A or B
Not a valid choice, try again!
 */