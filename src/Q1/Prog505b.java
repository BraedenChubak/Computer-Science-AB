package Q1;

import Utils.Console;

import javax.swing.plaf.basic.BasicBorders;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog505b {
    static class Baseball {
        private int[][] hitsAndBats;
        private double[] hitRate;
        private int[] hitDays;
        private int sumHits;
        public Baseball(int[][]hab) {
            hitsAndBats = hab;
            hitRate = new double[7];
            sumHits = 0;
        }

        public void calc() {
            for (int i = 0; i < hitRate.length; i++) {
                hitRate[i] = hitsAndBats[i][0] / (double)hitsAndBats[i][1];
                sumHits += hitsAndBats[i][0];
            }
        }

        public double[] getHitRate() {
            return hitRate;
        }
        public int getSumHits() {
            return sumHits;
        }
     }
    public static void main(String[] args) {
        int[][] hitsAndBats = new int[7][2];
        String[] days = new String[7];
        days[0] = "Monday";
        days[1] = "Tuesday";
        days[2] = "Wednesday";
        days[3] = "Thursday";
        days[4] = "Friday";
        days[5] = "Saturday";
        days[6] = "Sunday";
        try {
            var file = new Scanner(new File("Langdat/prog505d.txt"));

            while (file.hasNext()) {
                String name = file.next() + " " + file.next();
                System.out.print(name + "\t   ");
                for (int i = 0; i < 7; i++) {
                    int hits = file.nextInt();
                    int bats = file.nextInt();
                    hitsAndBats[i][0] += hits;
                    hitsAndBats[i][1] += bats;
                    System.out.print((double)Math.round(hits/(double)bats * 1000) / 1000 + "\t");
                }
                System.out.println();
            }
            Baseball ball = new Baseball(hitsAndBats);
            ball.calc();

            for (int i = 0; i < 7; i++) {
                System.out.printf("%s\t%d\t%.3f\n", days[i], hitsAndBats[i][0], ball.getHitRate()[i]);
            }

            System.out.println("Total Hits: " + ball.getSumHits());

            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Fred Sluggo	   0.5	0.25	0.333	0.25	0.0	0.0	1.0
Lydia Crusher	   0.667	0.667	0.8	0.4	0.25	1.0	0.25
Braeden Boomer	   1.0	0.5	0.625	0.5	0.2	0.333	0.0
Noah Niller	   0.333	0.571	0.333	0.75	0.5	0.333	0.286
Ruben Romper	   0.0	0.333	0.5	0.4	0.286	0.375	0.0
Lisa Longball	   1.0	0.5	0.714	0.25	0.75	0.5	0.2
Claire Corner	   0.25	0.667	0.375	0.444	0.8	0.333	0.2
Jared Just	   1.0	0.5	0.4	0.286	0.125	1.0	0.333
Monday	8	0.471
Tuesday	19	0.514
Wednesday	24	0.522
Thursday	19	0.396
Friday	16	0.356
Saturday	15	0.395
Sunday	12	0.324
Total Hits: 113
 */