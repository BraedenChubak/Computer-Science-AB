package Q2;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataStructures.CircularDeque;
import DataStructures.CircularQueue;

@SuppressWarnings("unchecked")

public class Pelican52_6 {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/Marquee.dat"));

            while (file.hasNext()) {
                int numShift = file.nextInt();
                file.nextLine();
                String preShift = file.nextLine();
                CircularDeque shifter = new CircularDeque<String>(preShift.length());
                for (int i = 0; i < preShift.length(); i++) {
                    shifter.enqueueRear(preShift.substring(i,i+1));
                }
                for (int i = 0; i < numShift; i++) {
                    shifter.enqueueRear(shifter.dequeueFront());
                }
                for (int i = 0; i < 40; i++) {
                    System.out.print(shifter.dequeueFront());
                }
                System.out.println();
            }

            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
.85  VIGN 14.82  MOT 26.87  JDSU 1.95  P
 IBM 12.66  COK 11.86  AL 22.00VSSL 22.8
P 23.27  CSCO 19.86  ZQ 12.75  BTDF 22.9
 */