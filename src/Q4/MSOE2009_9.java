package Q4;

import java.util.*;

public class MSOE2009_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = input.nextInt();
        int[][] connections = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(connections[i], 9999);
        }
        System.out.print("Enter # of connections: ");
        int numConn = input.nextInt();
        for (int i = 0; i < numConn; i++) {
            int r = input.nextInt();
            int c = input.nextInt();
            if (c > r) {
                int temp = r;
                r = c;
                c = temp;
            }
            connections[r][c] = 1;
        }
        for (int i = 0; i < n-1; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < r; c++) {
                    if (connections[r][c] == 9999) {
                        int minR = 9999;
                        int minC = 9999;
                        for (int r2 = 0; r2 < r; r2++) {
                            if (connections[r2][c] < 9999) { minR = connections[r2][c]; }
                        }
                        for (int c2 = 0; c2 < c; c2++) {
                            if (connections[r][c2] < 9999) { minC = connections[r][c2]; }
                        }
                        if (minR != 9999 && minC != 9999) {
                            connections[r][c] = minR + minC;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(connections[r][c] + " ");
            }
            System.out.println();
        }
        System.out.print("Enter user1: ");
        int r = input.nextInt();
        System.out.print("Enter user2: ");
        int c = input.nextInt();
        if (c > r) {
            int temp = r;
            r = c;
            c = temp;
        }
        System.out.println("Degrees of seperation: " + connections[r][c]);
    }
}
