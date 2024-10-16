package Q1;

import java.util.*;

public class MSOE2007_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            String substr = str.substring(i, i+1);
            if (substr.equals("a") || substr.equals("e") || substr.equals("i") || substr.equals("o") || substr.equals("u")) {
                count++;
            }
        }
        System.out.println("There are " + count + " vowels in the string.");
    }
}
