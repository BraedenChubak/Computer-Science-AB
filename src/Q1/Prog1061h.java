package Q1;

import DataStructures.DoublyLinkedList;
import java.util.Scanner;

public class Prog1061h {
    public static void main(String[] args) {
        String choice;
        String[] choiceWord = new String[2];
        choiceWord[0] = "";
        choiceWord[1] = "";
        DoublyLinkedList<String> LL = new DoublyLinkedList<>();
        Scanner input = new Scanner(System.in);
        while (!choiceWord[0].equalsIgnoreCase("Q")) {
            System.out.print("Enter Command [A(dd, D(elete, P(rint, Q(uit]: ");
            choice = input.nextLine();
            choiceWord = choice.split(" ");
            if (choiceWord[0].equalsIgnoreCase("A")) {
                LL.addSorted(choiceWord[1]);
            }
            else if (choiceWord[0].equalsIgnoreCase("D")) {
                for (int i = 0; i < LL.size(); i++) {
                    LL.removeObj(choiceWord[1]);
                }
            }
            else if (choiceWord[0].equalsIgnoreCase("P")) {
                for (int i = 0; i < LL.size(); i++) {
                    System.out.print(LL.get(i) + " ");
                }
                System.out.println();
            }
            else if (!choiceWord[0].equalsIgnoreCase("Q")) {
                System.out.println("Unknown Command, try again!");
            }
        }
        System.out.println("Exiting Program...");
    }
}
/*
Enter Command [A(dd, D(elete, P(rint, Q(uit]: A hello
Enter Command [A(dd, D(elete, P(rint, Q(uit]: P
hello
Enter Command [A(dd, D(elete, P(rint, Q(uit]: A world
Enter Command [A(dd, D(elete, P(rint, Q(uit]: P
hello world
Enter Command [A(dd, D(elete, P(rint, Q(uit]: A actually
Enter Command [A(dd, D(elete, P(rint, Q(uit]: P
actually hello world
Enter Command [A(dd, D(elete, P(rint, Q(uit]: D hello
Enter Command [A(dd, D(elete, P(rint, Q(uit]: P
actually world
Enter Command [A(dd, D(elete, P(rint, Q(uit]: Q
Exiting Program...

 */