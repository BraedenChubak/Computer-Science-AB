package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Passenger {
    char name;
    double x;
    double y;

    public Passenger(char n, double x, double y) {
        name = n;
        this.x = x;
        this.y = y;
    }
}

class Cab {
    int id;
    double x;
    double y;

    public Cab(int i, double x, double y) {
        id = i;
        this.x = x;
        this.y = y;
    }
}

public class MSOE2013_9 {
    static double distance(double x1, double y1, double x2, double y2) {
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }

    public static void main(String[] args) {
        try {
            var cabsfile = new Scanner(new File("Langdat/cabs.txt"));
            int numCabs = cabsfile.nextInt();
            ArrayList<Cab> cabs = new ArrayList<>();
            for (int i = 0; i < numCabs; i++) {
                double cabx = cabsfile.nextDouble();
                double caby = cabsfile.nextDouble();
                Cab curcab = new Cab(i, cabx, caby);
                cabs.add(curcab);
            }
            cabsfile.close();

            var passfile = new Scanner(new File("Langdat/passengers.txt"));
            int numPass = passfile.nextInt();
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            ArrayList<Passenger> passengers = new ArrayList<>();
            for (int i = 0; i < numPass; i++) {
                double passx = passfile.nextDouble();
                double passy = passfile.nextDouble();
                Passenger curpass = new Passenger(alphabet.charAt(i), passx, passy);
                passengers.add(curpass);
            }
            passfile.close();

            for (Passenger p : passengers) {
                if (cabs.size() == 0) {
                    return;
                }
                double mindis = distance(p.x, p.y, cabs.get(0).x, cabs.get(0).y);
                Cab mincab = cabs.get(0);
                for (int i = 1; i < cabs.size(); i++) {
                    if (mindis > distance(p.x, p.y, cabs.get(i).x, cabs.get(i).y)) {
                        mindis = distance(p.x, p.y, cabs.get(i).x, cabs.get(i).y);
                        mincab = cabs.get(i);
                    }
                }
                System.out.println("Cab " + mincab.id + " dispatched to Passenger " + p.name);
                cabs.remove(mincab);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Cab 2 dispatched to Passenger A
Cab 0 dispatched to Passenger B
Cab 9 dispatched to Passenger C
Cab 6 dispatched to Passenger D
Cab 7 dispatched to Passenger E
Cab 3 dispatched to Passenger F
Cab 8 dispatched to Passenger G
Cab 1 dispatched to Passenger H
Cab 4 dispatched to Passenger I
Cab 5 dispatched to Passenger J
 */