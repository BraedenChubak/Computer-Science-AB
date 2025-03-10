package Q3;

import java.util.*;

public class MSOE2007_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter # of digits: ");
        int digits = input.nextInt();
        System.out.print("Enter starting num: ");
        int startNum = input.nextInt();
        String startOdom = "";
        for (int i = 0; i < digits; i++) {
            startOdom += "0";
        }
        startOdom += String.valueOf(startNum);
        startOdom = startOdom.substring(startOdom.length()-digits);
        int dist = 0;
        boolean notPalindrome = true;
        String curOdom = startOdom;
        int curNum = startNum;
        while (notPalindrome) {
            String curReverse = "";
            for (int i = digits-1; i >= 0; i--) {
                curReverse += curOdom.substring(i, i+1);
            }
            if (curOdom.equals(curReverse)) {
                notPalindrome = false;
            } else {
                dist++;
                curNum = startNum + dist;
                curOdom = "";
                for (int i = 0; i < digits; i++) {
                    curOdom += "0";
                }
                curOdom += String.valueOf(curNum);
                curOdom = curOdom.substring(curOdom.length()-digits);
            }
        }
        System.out.println("The next palindrome is " + curNum);
        System.out.println("The distance to the next palindrome is: " + dist);
    }
}
/*
Enter # of digits: 5
Enter starting num: 12654
The next palindrome is 12721
The distance to the next palindrome is: 67
 */