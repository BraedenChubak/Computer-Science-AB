package Q2;

import DataStructures.Queue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Prog1060hQueue {
    public static class Car implements Comparable<Car> {
        public String name;
        public double miles;
        public String size;
        public double[] rates;

        public Car(String n, String s, double m) {
            name = n;
            size = s;
            miles = m;
        }
        public void setRates(double[] r) { rates = r; }

        public void setMiles(double m) { miles = m; }
        public int compareTo(Car o) { return 0; }
        public String toString() { return name + " " + miles; }
    }

    public static void main(String[] args) {
        try {
            var file1 = new Scanner(new File("Langdat/invntory.dat"));
            ArrayList<Queue<Car>> cars = new ArrayList<>();
            Queue<Car> rentedCars = new Queue<>();
            final int NUM_SIZES = 5;

            for (int i = 0; i < NUM_SIZES; i++) {
                cars.add(new Queue<>());
            }

            while (file1.hasNext()) {
                String name = file1.nextLine();
                String size = name.substring(0,1);
                double miles = Double.parseDouble(name.substring(11));
                name = name.substring(1,11);
                Car mcqueen = new Car(name, size, miles);
                switch (mcqueen.size) {
                    case "S" -> cars.get(0).enqueue(mcqueen);
                    case "C" -> cars.get(1).enqueue(mcqueen);
                    case "M" -> cars.get(2).enqueue(mcqueen);
                    case "W" -> cars.get(3).enqueue(mcqueen);
                    case "L" -> cars.get(4).enqueue(mcqueen);
                }
            }
            file1.close();

            var file2 = new Scanner(new File("Langdat/rates.dat"));
            double[][] rates = new double[NUM_SIZES][2];
            int counter = 0;

            while (file2.hasNext()) {
                double perDay = Double.parseDouble(file2.next().substring(1));
                double perMile = file2.nextDouble();
                rates[counter][0] = perDay;
                rates[counter][1] = perMile;
                counter++;
            }
            file2.close();

            var file3 = new Scanner(new File("Langdat/transact.dat"));
            while (file3.hasNext()) {
                String fullRequest = file3.next();
                String command = fullRequest.substring(0,1);
                if (command.equals("L")) {
                    String sizePicked = fullRequest.substring(1);
                    switch (sizePicked) {
                        case "S" -> {
                            System.out.println("Small");
                            for (int i = 0; i < cars.get(0).size(); i++) {
                                Car curCar = cars.get(0).dequeue();
                                System.out.println(curCar);
                                cars.get(0).enqueue(curCar);
                            }
                        }
                        case "C" -> {
                            System.out.println("Compact");
                            for (int i = 0; i < cars.get(1).size(); i++) {
                                Car curCar = cars.get(1).dequeue();
                                System.out.println(curCar);
                                cars.get(1).enqueue(curCar);
                            }
                        }
                        case "M" -> {
                            System.out.println("Midsize");
                            for (int i = 0; i < cars.get(2).size(); i++) {
                                Car curCar = cars.get(2).dequeue();
                                System.out.println(curCar);
                                cars.get(2).enqueue(curCar);
                            }
                        }
                        case "W" -> {
                            System.out.println("Wagon");
                            for (int i = 0; i < cars.get(3).size(); i++) {
                                Car curCar = cars.get(3).dequeue();
                                System.out.println(curCar);
                                cars.get(3).enqueue(curCar);
                            }
                        }
                        case "L" -> {
                            System.out.println("Luxury");
                            for (int i = 0; i < cars.get(4).size(); i++) {
                                Car curCar = cars.get(4).dequeue();
                                System.out.println(curCar);
                                cars.get(4).enqueue(curCar);
                            }
                        }
                    }
                    System.out.println();
                }
                else if (command.equals("R")) {
                    String sizePicked = fullRequest.substring(1);
                    int sizeNum = -1;
                    switch (sizePicked) {
                        case "S" -> sizeNum = 0;
                        case "C" -> sizeNum = 1;
                        case "M" -> sizeNum = 2;
                        case "W" -> sizeNum = 3;
                        case "L" -> sizeNum = 4;
                    }
                    double[] rate = rates[sizeNum];
                    while (cars.get(sizeNum).isEmpty()) {
                        sizeNum++;
                    }
                    Car current = cars.get(sizeNum).dequeue();
                    current.setRates(rate);
                    rentedCars.enqueue(current);
                }
                else if (command.equals("A")) {
                    int days = Integer.parseInt(fullRequest.substring(2,3));
                    double milesAfter = file3.nextDouble();
                    String name = file3.next();

                    Car current = rentedCars.dequeue();
                    while (!current.name.startsWith(name)) {
                        rentedCars.enqueue(current);
                        current = rentedCars.dequeue();
                    }

                    double milesBefore = current.miles;
                    current.setMiles(milesAfter);

                    switch (current.size) {
                        case "S" -> cars.get(0).enqueue(current);
                        case "C" -> cars.get(1).enqueue(current);
                        case "M" -> cars.get(2).enqueue(current);
                        case "W" -> cars.get(3).enqueue(current);
                        case "L" -> cars.get(4).enqueue(current);
                    }

                    double milesDriven = Math.round((milesAfter-milesBefore) * 100) / 100.0;
                    double milesPrice = Math.round(milesDriven * current.rates[1] * 100) / 100.0;
                    double price = Math.round((days * current.rates[0] + milesDriven * current.rates[1]) * 100) / 100.0;

                    System.out.println("INVOICE:" + "\nCar " + current.name + "\nBeginning Mileage: " + milesBefore + "\nEnding Mileage " + milesAfter + "\nMiles Driven: " + milesDriven + " @ " + current.rates[1] + " = $" + (milesPrice) + "\nDays Driven: " + days + " @ " + current.rates[0] + " = $" + (days * current.rates[0]) + "\nCar Type: " + current.size + "\nTotal Amt Due: $" + price);
                    System.out.println();
                }
                else if (command.equals("C")) {
                    System.out.println("Rented Cars:");
                    for (int i = 0; i < rentedCars.size(); i++) {
                        Car c = rentedCars.dequeue();
                        System.out.println(c);
                        rentedCars.enqueue(c);
                    }
                    System.out.println();
                }
                else {
                    break;
                }
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Small
Yugo       3456.3
Chevette   1710.1
RX7        4002.1
Sentra     3007.0

Compact
Shadow     831.2
Topaz      412.5
Contour    1091.7
Fiero      1541.4

Midsize
Cutlass    930.7
Mystique   117.4
LaBaron    831.2
Cougar     1442.2

Wagon
Delta88    2417.7
Caprice    4522.8
Bonneville 5100.0

Luxury
Cadillac   1234.5
Lincoln    8400.2
Corvette   10341.7

Rented Cars:
Yugo       3456.3
Chevette   1710.1
RX7        4002.1
Sentra     3007.0
Shadow     831.2
Topaz      412.5
Contour    1091.7
Fiero      1541.4
Cutlass    930.7
Mystique   117.4
Delta88    2417.7
Cadillac   1234.5
LaBaron    831.2

INVOICE:
Car Yugo
Beginning Mileage: 3456.3
Ending Mileage 3640.0
Miles Driven: 183.7 @ 0.22 = $40.41
Days Driven: 2 @ 18.0 = $36.0
Car Type: S
Total Amt Due: $76.41

INVOICE:
Car Cadillac
Beginning Mileage: 1234.5
Ending Mileage 2801.2
Miles Driven: 1566.7 @ 0.37 = $579.68
Days Driven: 2 @ 34.0 = $68.0
Car Type: L
Total Amt Due: $647.68

INVOICE:
Car Contour
Beginning Mileage: 1091.7
Ending Mileage 2031.7
Miles Driven: 940.0 @ 0.25 = $235.0
Days Driven: 3 @ 20.5 = $61.5
Car Type: C
Total Amt Due: $296.5

Small
Yugo       3640.0

Compact
Contour    2031.7

Midsize
Cougar     1442.2

Wagon
Caprice    4522.8
Bonneville 5100.0

Luxury
Lincoln    8400.2
Corvette   10341.7
Cadillac   2801.2

Rented Cars:
Fiero      1541.4
Cutlass    930.7
Mystique   117.4
Delta88    2417.7
LaBaron    831.2
Chevette   1710.1
RX7        4002.1
Sentra     3007.0
Shadow     831.2
Topaz      412.5

 */