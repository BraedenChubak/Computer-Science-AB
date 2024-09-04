package Q1;

import java.util.*;

public class LP5_20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();
        String text2 = text.toLowerCase();
        int count = 0;
        for (int lcv = 0; lcv < text.length(); lcv++) {
            if (text2.substring(lcv,lcv+1).equals("a") || text2.substring(lcv,lcv+1).equals("e") || text2.substring(lcv,lcv+1).equals("i") || text2.substring(lcv,lcv+1).equals("o") || text2.substring(lcv,lcv+1).equals("u") || text2.substring(lcv,lcv+1).equals("y")) {
                count++;
            }
        }
        System.out.println("The number of vowels in " + text + " is " + count);
    }
}
/*
Enter text: Java Programming Assignment
The number of vowels in Java Programming Assignment is 8
 */