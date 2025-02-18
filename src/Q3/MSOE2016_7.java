package Q3;

import java.util.*;

class Hint {
    int facing;
    int rowcol;
    int buildings;

    public Hint(int f, int r, int b) {
        facing = f;
        rowcol = r;
        buildings = b;
    }
}
public class MSOE2016_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of puzzle (integer between 3 and 6 inclusive): ");
        int size = input.nextInt();
        System.out.print("Enter number of hints (positive integer): ");
        int hints = input.nextInt();
        Hint[] hintList = new Hint[hints];
        for (int i = 0; i < hints; i++) {
            System.out.print("Enter facing, row, and buildings, separated by spaces, in that order: ");
            int f = input.nextInt();
            int r = input.nextInt();
            int b = input.nextInt();
            Hint h = new Hint(f, r, b);
            hintList[i] = h;
        }

        int[][] attempted = new int[size][size];
        System.out.println("\nEnter attempted solution:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter row " + (i+1) + ": ");
            for (int j = 0; j < size; j++) {
                int cur = input.nextInt();
                attempted[i][j] = cur;
            }
        }

        // Error 1: duplicates in same row/column
        int error1count = 0;

        // rows
        for (int i = 0; i < attempted.length; i++) {
            ArrayList<Integer> curNums = new ArrayList<>();
            for (int j = 0; j < attempted[i].length; j++) {
                if (curNums.contains(attempted[i][j])) {
                    error1count++;
                    break;
                }
                curNums.add(attempted[i][j]);
            }
        }
        // columns
        for (int i = 0; i < attempted.length; i++) {
            ArrayList<Integer> curNums = new ArrayList<>();
            for (int j = 0; j < attempted[i].length; j++) {
                if (curNums.contains(attempted[j][i])) {
                    error1count++;
                    break;
                }
                curNums.add(attempted[j][i]);
            }
        }
        System.out.println("Counts of Error 1: " + error1count);

        // Error 2: every num already present
        int error2count = 0;
        for (int i = 0; i < attempted.length; i++) {
            for (int j = 0; j < attempted.length; j++) {
                boolean containsAll = false;
                if (attempted[i][j] == 0) {
                    ArrayList<Integer> curNums = new ArrayList<>();
                    for (int k = 0; k < attempted.length; k++) {
                        if (!(k == i && k == j)) {
                            curNums.add(attempted[i][k]);
                            curNums.add(attempted[k][j]);
                        }
                    }
                    for (int k = 1; k < attempted.length; k++) {
                        if (!curNums.contains(k)) { containsAll = true; }
                    }
                    if (containsAll) {
                        error2count++;
                    }
                }
            }
        }
        System.out.println("Counts of Error 2: " + error2count);

        // Error 3: wrong number of faces
        int error3count = 0;
        for (int i = 0; i < hints; i++) {
            Hint curHint = hintList[i];
            int r;
            int c;
            int curheight = 0;
            int numseen = 0;
            boolean nozeros = true;
            if (curHint.facing % 2 == 0) {
                c = curHint.rowcol;
                if (curHint.facing == 0) { r = 0; }
                else { r = attempted.length-1; }
                for (int j = 0; j < attempted.length; j++) {
                    if (attempted[r][c] > curheight) {
                        curheight = attempted[r][c];
                        numseen++;
                    }
                    if (attempted[r][c] == 0) {
                        nozeros = false;
                    }
                    if (curHint.facing == 0) { r++; }
                    else { r--; }
                }
                if (nozeros && numseen != curHint.buildings) {
                    error3count++;
                }
            }
            else {
                r = curHint.rowcol;
                if (curHint.facing == 1) { c = 0; }
                else { c = attempted.length-1; }
                for (int j = 0; j < attempted.length; j++) {
                    if (attempted[r][c] > curheight) {
                        curheight = attempted[r][c];
                        numseen++;
                    }
                    if (attempted[r][c] == 0) {
                        nozeros = false;
                    }
                    if (curHint.facing == 1) { c++; }
                    else { c--; }
                }
                if (nozeros && numseen != curHint.buildings) {
                    error3count++;
                }
            }
        }
        System.out.println("Counts of Error 3: " + error3count);
    }
}
/*
Enter size of puzzle (integer between 3 and 6 inclusive): 4
Enter number of hints (positive integer): 7
Enter facing, row, and buildings, separated by spaces, in that order: 0 3 1
Enter facing, row, and buildings, separated by spaces, in that order: 1 0 4
Enter facing, row, and buildings, separated by spaces, in that order: 1 1 2
Enter facing, row, and buildings, separated by spaces, in that order: 1 3 2
Enter facing, row, and buildings, separated by spaces, in that order: 2 2 3
Enter facing, row, and buildings, separated by spaces, in that order: 2 3 2
Enter facing, row, and buildings, separated by spaces, in that order: 3 3 2

Enter attempted solution:
Enter row 1: 1 1 0 4
Enter row 2: 3 0 4 2
Enter row 3: 4 3 2 1
Enter row 4: 2 4 1 3
Counts of Error 1: 1
Counts of Error 2: 1
Counts of Error 3: 0
 */