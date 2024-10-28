package Q1;

import java.util.*;

public class MSOE2007_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the numbers: ");
        int rows = input.nextInt();
        int cols = input.nextInt();
        int[][] terrain = new int[rows][cols];
        int curRow = 0;
        int curCol = 0;
        for (int i = 0; i < rows*cols; i++) {
            terrain[curRow][curCol] = input.nextInt();
            curCol++;
            if (curCol == cols) {
                curCol = 0;
                curRow++;
            }
        }
    }
}
