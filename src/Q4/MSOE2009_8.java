package Q4;

import java.util.*;

public class MSOE2009_8 {
    public static void ocr(char[][] mat, char replace, int curR, int curC) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i+curR >= 0 && j+curC >= 0 && i+curR < mat.length && j+curC < mat[0].length) {
                    if (mat[curR + i][curC + j] == '*') {
                        mat[curR + i][curC + j] = replace;
                        ocr(mat, replace, curR + i, curC + j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter rows: ");
        int rows = input.nextInt();
        System.out.print("enter cols: ");
        int cols = input.nextInt();

        // make the array
        char[][] mat = new char[rows][cols];
        input.nextLine();
        for (int i = 0; i < rows; i++) {
            String row = input.nextLine();
            for (int j = 0; j < cols; j++) {
                mat[i][j] = row.charAt(j);
            }
        }

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int countchars = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (mat[i][j] == '*') {
                    mat[i][j] = alphabet.charAt(countchars);
                    ocr(mat, alphabet.charAt(countchars), i, j);
                    countchars++;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
/*
enter rows: 4
enter cols: 6
** *
*   **
 * * *
*   **
AA B
A   BB
 A B B
A   BB
 */