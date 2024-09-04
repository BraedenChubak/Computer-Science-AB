package Q1;

import java.util.*;

public class LP5_21 {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String fname = input.nextLine();
        System.out.print("Enter last name: ");
        String lname = input.nextLine();
        String lname2 = lname.toLowerCase();
        int group = 0;
        int index = 0;
        for (int lcv = 0; lcv < 26; lcv++) {
            if (lname2.substring(0, 1).equals(alphabet.substring(lcv, lcv + 1))) {
                index = lcv;
            }
        }
        if (index < 9) {
            group = 1;
        }
        else if (index > 18) {
            group = 3;
        }
        else {
            group = 2;
        }
        System.out.println(fname + " " + lname + " is in group " + group);
    }
}
/*
Enter first name: Daniel
Enter last name: Szelogowski
Daniel Szelogowski is in group 2
 */