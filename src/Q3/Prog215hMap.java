package Q3;

import DataStructures.Dictionary;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Prog215hMap {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/Prog215h.txt"));
            int conCount = 1;

            while (file.hasNext()) {
                System.out.println("Contestant " + conCount);
                var curCon = new Dictionary<Integer, Double>();
                for (int i = 0; i < 8; i++) {
                    double v = file.nextDouble();
                    System.out.print(v + " ");
                    curCon.insert(i, v);
                }
                int minKey = 0;
                double minVal = curCon.get(0);
                int maxKey = 0;
                double maxVal = curCon.get(0);
                for (int i = 1; i < 8; i++) {
                    if (minVal > curCon.get(i)) {
                        minKey = i;
                        minVal = curCon.get(i);
                    }
                    if (maxVal < curCon.get(i)) {
                        maxKey = i;
                        maxVal = curCon.get(i);
                    }
                }
                double avg = 0;
                for (int i = 0; i < 8; i++) {
                    if (i != minKey && i != maxKey) {
                        avg += curCon.get(i);
                    }
                }
                if (minKey == maxKey) { avg -= curCon.get(minKey); }
                avg /= 6;
                System.out.println("= " + avg);
                conCount++;
            }

            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Contestant 1
8.4 9.1 8.5 8.4 9.1 8.7 8.8 9.1 = 8.766666666666667
Contestant 2
7.0 7.0 7.0 7.0 7.0 7.0 7.0 7.0 = 7.0
Contestant 3
8.0 7.9 8.0 8.0 8.0 8.0 8.0 8.1 = 8.0
Contestant 4
6.1 7.1 8.1 8.1 8.2 8.2 7.2 6.2 = 7.483333333333333
Contestant 5
7.2 7.7 7.8 8.8 7.5 6.3 9.2 7.3 = 7.716666666666666
Contestant 6
6.8 6.9 7.3 8.8 6.7 7.7 7.9 6.3 = 7.216666666666666
 */