package Q3;

import java.util.*;

public class MSOE2010_2 {
    public static boolean tripleChar(String s) {
        boolean triple = false;
        for (int i = 0; i < s.length()-2; i++) {
            if (s.substring(i,i+1).equals(s.substring(i+1,i+2)) && s.substring(i,i+1).equals(s.substring(i+2,i+3))) {
                triple = true;
            }
        }
        return triple;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = input.nextLine();
        System.out.println(tripleChar(s));
    }
}
/*
Enter string: realrealtruewww
true
 */