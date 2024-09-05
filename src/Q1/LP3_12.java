package Q1;

import Utils.Console;

public class LP3_12 {
    static class Spending {
        private int food;
        private double foodPercent;
        private int cloth;
        private double clothPercent;
        private int entert;
        private double entertPercent;
        private int rent;
        private double rentPercent;
        private int total;

        public Spending(int f, int c, int e, int r) {
            food = f;
            cloth = c;
            entert = e;
            rent = r;
            total = f + c + e + r;
        }

        public void calcPercents() {
            foodPercent = food / (double)total * 100;
            clothPercent = cloth / (double)total * 100;
            entertPercent = entert / (double)total * 100;
            rentPercent = rent / (double)total * 100;
        }

        public double getFoodPercent() { return foodPercent; }
        public double getClothPercent() { return clothPercent; }
        public double getEntertPercent() { return entertPercent; }
        public double getRentPercent() { return rentPercent; }
    }

    public static void main(String[] args) {
        Console.println("Enter the amount spent last month on each of the following:");
        int food = Console.input("Food: $");
        int cloth = Console.input("Clothing: $");
        int entert = Console.input("Entertainment: $");
        int rent = Console.input("Rent: $");
        Spending spending = new Spending(food, cloth, entert, rent);
        spending.calcPercents();
        Console.println("Category\t\tBudget");
        Console.println("Food\t\t\t" + spending.getFoodPercent() + "%");
        Console.println("Clothing\t\t" + spending.getClothPercent() + "%");
        Console.println("Entertainment\t" + spending.getEntertPercent() + "%");
        Console.println("Rent\t\t\t" + spending.getRentPercent() + "%");
    }
}
/*
Enter the amount spent last month on each of the following:
Food: $350
Clothing: $300
Entertainment: $200
Rent: $1250
Category		Budget
Food			16.666666666666664%
Clothing		14.285714285714285%
Entertainment	9.523809523809524%
Rent			59.523809523809526%
 */