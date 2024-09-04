package Q1;

import java.util.*;

public class LP3_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double cost = 0.0;
        System.out.print("Enter tuition cost: ");
        cost += input.nextDouble();
        System.out.print("Enter rent cost: ");
        cost += input.nextDouble();
        System.out.print("Enter books cost: ");
        cost += input.nextDouble();
        System.out.print("Enter food cost: ");
        cost += input.nextDouble();
        System.out.print("Enter other costs: ");
        cost += input.nextDouble();
        System.out.print("Enter scholarship offset: ");
        cost -= input.nextDouble();
        System.out.print("Enter grant offset: ");
        cost -= input.nextDouble();
        System.out.print("Enter other offsets: ");
        cost -= input.nextDouble();
        cost = (double)Math.round(cost*100) / 100;
        System.out.println("Total cost of college will be $" + cost);
    }
}
/*
Enter tuition cost: 2321.36
Enter rent cost: 354.11
Enter books cost: 411.76
Enter food cost: 558.23
Enter other costs: 295.66
Enter scholarship offset: 1500.00
Enter grant offset: 350.00
Enter other offsets: 175.00
Total cost of college will be $1916.12
 */