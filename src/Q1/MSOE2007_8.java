package Q1;

import java.util.*;

public class MSOE2007_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the terrain: ");
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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(terrain[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The following are all high points:\tRow\tCol\tAltitude");
        for (int r = 1; r < rows-1; r++) {
            for (int c = 1; c < cols-1; c++) {
                int curAlt = terrain[r][c];
                boolean highest = true;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (curAlt <= terrain[r+i][c+j]) {
                            highest = false;
                        }
                    }
                }
                if (highest) {
                    System.out.println((r+1) + "\t" + (c+1) + "\t" + curAlt);
                }
            }
        }
    }
}
