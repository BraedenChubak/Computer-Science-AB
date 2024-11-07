package Q2;

import java.util.*;

public class Prog1060b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = "";
        Queue<Integer> queue = new LinkedList<Integer>();
        while (!command.equalsIgnoreCase("E")) {
            System.out.print("Enter Command A)dd, D)elete, E)xit: ");
            command = input.next();
            if (command.equalsIgnoreCase("A")) {
                System.out.print("Enter number: ");
                int num = input.nextInt();
                queue.add(num);
                System.out.println("This is the list.");
                for (int i : queue) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } else if (command.equalsIgnoreCase("D")) {
                System.out.print("Enter number: ");
                int num = input.nextInt();
                if (!queue.remove(num)) {
                    System.out.println("Number does not exist in list.");
                } else {
                    System.out.println("This is the list.");
                    for (int i : queue) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                }
            } else if (!command.equalsIgnoreCase("E")) {
                System.out.println("Invalid Command!");
            } else {
                System.out.println("Exiting Program.");
            }
        }
    }
}
/*
Enter Command A)dd, D)elete, E)xit: A
Enter number: 7
This is the list.
7
Enter Command A)dd, D)elete, E)xit: A
Enter number: 12
This is the list.
7 12
Enter Command A)dd, D)elete, E)xit: A
Enter number: 3
This is the list.
7 12 3
Enter Command A)dd, D)elete, E)xit: D
Enter number: 8
Number does not exist in list.
Enter Command A)dd, D)elete, E)xit: D
Enter number: 7
This is the list.
12 3
Enter Command A)dd, D)elete, E)xit: A
Enter number: 31
This is the list.
12 3 31
Enter Command A)dd, D)elete, E)xit: A
Enter number: 25
This is the list.
12 3 31 25
Enter Command A)dd, D)elete, E)xit: A
Enter number: 9
This is the list.
12 3 31 25 9
Enter Command A)dd, D)elete, E)xit: A
Enter number: 17
This is the list.
12 3 31 25 9 17
Enter Command A)dd, D)elete, E)xit: D
Enter number: 25
This is the list.
12 3 31 9 17
Enter Command A)dd, D)elete, E)xit: D
Enter number: 25
Number does not exist in list.
Enter Command A)dd, D)elete, E)xit: E
Exiting Program.
 */