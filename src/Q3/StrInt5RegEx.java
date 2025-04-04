package Q3;

import java.util.*;
import java.util.regex.Pattern;

public class StrInt5RegEx {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        Pattern onlyDigits = Pattern.compile("^\\d+$");
        System.out.println("Is this string digits only? " + onlyDigits.matcher(str).find());
    }
}
/*
Enter a string: 817344
Is this string digits only? true
 */