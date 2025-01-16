package Q2.Pelican42_7;

import java.io.*;
import java.util.*;

public class Pelican42_7And43_8 {
    public static void main(String[] args) {
        String name = "";
        ArrayList<BankAccount> accounts = new ArrayList<>();
        // ListIterator<BankAccount> iterator = accounts.listIterator();
        Scanner input = new Scanner(System.in);
        while (!name.equalsIgnoreCase("exit")) {
            System.out.print("Please enter name of account: ");
            name = input.nextLine();
            if (!name.equalsIgnoreCase("exit")) {
                System.out.print("Please enter amount in account: $");
                double amount = input.nextDouble();
                accounts.add(new BankAccount(name, amount));
                name = input.nextLine();
            }
        }
        System.out.println();
        int maxIndex = 0;
        int count = 0;
        for (BankAccount b : accounts) {
            if (b.balance > accounts.get(maxIndex).balance) {
                maxIndex = count;
            }
            count++;
        }

        System.out.println("The account with the largest balance belongs to " + accounts.get(maxIndex).name);
        System.out.println("The balance of this account is $" + accounts.get(maxIndex).balance);
    }
}
/*
Please enter name of account: Daniel S.
Please enter amount in account: $82594.65
Please enter name of account: Braeden C.
Please enter amount in account: $817.65
Please enter name of account: Jonah S.
Please enter amount in account: $914.38
Please enter name of account: Tristan C.
Please enter amount in account: $896.87
Please enter name of account: exit

The account with the largest balance belongs to Daniel S.
The balance of this account is $82594.65
 */