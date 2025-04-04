package Q3;

import DataStructures.Dictionary;
import DataStructures.Set;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog402aSet {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prg402a.dat"));
            Dictionary<Integer, Integer> students = new Dictionary<>();
            double avgScore = 0;
            while (file.hasNext()) {
                int id = file.nextInt();
                int score = file.nextInt();
                avgScore += score;
                students.insert(id, score);
            }
            file.close();
            avgScore /= students.size();
            System.out.println("ID\tScore\tDiff");
            Set<Integer> keys = students.keySet();
            for (Integer i : keys) {
                int score = students.get(i);
                double diff = avgScore - score;
                diff = Math.round(diff * 100) / 100.0;
                System.out.println(i + "\t" + score + "\t\t" + diff);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
ID	Score	Diff
213	229	13.62
301	242	0.62
218	243	-0.38
305	265	-22.38
306	262	-19.38
222	223	19.62
223	230	12.62
311	256	-13.38
104	239	3.62
110	238	4.62
321	245	-2.38
112	239	3.62
113	243	-0.38
323	245	-2.38
115	257	-14.38
325	246	-3.38
116	246	-3.38
203	224	18.62
207	228	14.62
123	253	-10.38
208	242	0.62
 */