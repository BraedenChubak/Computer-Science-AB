package Q3;

import java.util.*;

public class MSOE2014_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = input.nextInt();
        ArrayList<Integer> factors = new ArrayList<>();
        int factorednum = num;
        int curfactor = 2;
        while (factorednum > 1) {
            while (factorednum % curfactor == 0) {
                factorednum /= curfactor;
                factors.add(curfactor);
            }
            curfactor++;
        }

        for (int i = 1; i < factors.size(); i++) {
            if (factors.get(i-1) != factors.get(i)) {
                factors.remove(i-1);
                i--;
            }
        }
        if (factors.size() > 0) { factors.remove(factors.size()-1); }

        int finalnum = 1;
        for (int i = 0; i < factors.size(); i++) {
            finalnum *= factors.get(i);
        }

        System.out.print("Your knocked down number is: " + finalnum);
    }
}
/*
Enter an integer: 44100
Your knocked down number is: 210
 */