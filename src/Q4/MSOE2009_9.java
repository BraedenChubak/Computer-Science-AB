package Q4;

import java.util.*;

public class MSOE2009_9 {
    public static int find(int curPerson, int target, int curSep, int[][] connections, boolean[] usedPeople, boolean found) {
        usedPeople[curPerson] = true;
        if (connections[curPerson][target] != 9999) { return 1; }
        for (int i = 0; i < connections.length; i++) {
            if (connections[i][curPerson] != 9999 && !usedPeople[i]) {
                System.out.println(curPerson + " to " + i);
                if (find(i, target, curSep+1, connections, usedPeople, false) != 9999) {
                    return curSep + find(i, target, curSep+1, connections, usedPeople, true);
                }
            }
        }
        if (!found) { return 9999;}
        else {
            int used = 0;
            for (int i = 0; i < usedPeople.length; i++) {
                if (usedPeople[i]) { used++; }
            }
            return used;
        }
    }
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
            connections[r][c] = 1;
            connections[c][r] = 1;
        }

        System.out.print("Enter user1: ");
        int from = input.nextInt();
        System.out.print("Enter user2: ");
        int to = input.nextInt();

        boolean[] usedPeople = new boolean[n];
        Arrays.fill(usedPeople, false);

        int minSep = find(from, to, 0, connections, usedPeople, false);
        if (from == to) { minSep = 0; }

        System.out.println("Degrees of separation: " + minSep);
    }
}
/*
Enter N: 7
Enter # of connections: 5
4 6
0 6
5 0
2 0
3 1
Enter user1: 4
Enter user2: 2
4 to 6
6 to 0
Degrees of separation: 3
 */