package Q1;

import java.util.*;

public class Prog52a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Length: ");
        int l = input.nextInt();
        System.out.print("Enter Width: ");
        int w = input.nextInt();
        int area = l * w;
        int perim = 2 * l + 2 * w;
        System.out.println("Area is " + area + "\n" +
                           "Perimeter is " + perim);
    }
}
/*
Enter Length: 11
Enter Width: 19
Area is 209
Perimeter is 60
 */