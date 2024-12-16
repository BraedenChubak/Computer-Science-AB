package Q2;

import java.util.ArrayList;
import java.util.Scanner;

public class MSOE2024_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter target word: ");
        String target = input.next();
        System.out.println("Enter dictionary (single space for end of dictionary): ");
        ArrayList<String> dictionary = new ArrayList<>();
        String curInput = target;
        while (true) {
            curInput = input.nextLine();
            if (!target.contains(curInput) && !curInput.contains(target)) {
                dictionary.add(curInput);
            }
            if (curInput.equals(" ")) { break; }
        }
        ArrayList<String> maxEmbeds = new ArrayList<>();
        int maxLength = 0;
        for (int i = 2; i < target.length(); i++) {
            for (int j = 0; j < target.length()-i+1; j++) {
                for (String s : dictionary) {
                    if (s.contains(target.substring(j, j+i))) {
                        if (i > maxLength) {
                            maxEmbeds.clear();
                            maxLength = i;
                        }
                        maxEmbeds.add(s);
                    }
                }
            }
        }
        for (String s : maxEmbeds) {
            System.out.println(s);
        }
    }
}
/*
Enter target word: grand
Enter dictionary (single space for end of dictionary):
are
bandersnatch
bangle
branch
grandfather
great
hand
plant

branch
bandersnatch
hand
 */