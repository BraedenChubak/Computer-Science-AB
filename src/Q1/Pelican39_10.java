package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Utils.Console;

public class Pelican39_10 {
    public static int modFibonacci(int n) {
        if (n == 0) { return 3; }
        if (n == 1) { return 5; }
        if (n == 2) { return 8; }
        else { return modFibonacci(n-1) + modFibonacci(n-2) + modFibonacci(n-3); }
    }

    public static void main(String[] args) {
          int n = Console.input("Generate which term number? ");
          Console.println("Term #" + n + " is " + modFibonacci(n));
    }
}
/*
Generate which term number? 11
Term #11 is 2060
 */