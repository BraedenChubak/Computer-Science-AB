package Q1;

import java.util.*;

public class LP5_19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sen = input.nextLine();
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        for (int lcv = 0; lcv < sen.length() - str.length(); lcv++) {

            if (sen.substring(lcv, lcv+str.length()).equals(str)) {
                sen = sen.substring(0,lcv) + sen.substring(lcv+str.length(),sen.length());
            }
        }
        System.out.println(sen);
    }
}
/*
Enter a sentence: I really hope you get an interview
Enter a string: really
I  hope you get an interview
 */