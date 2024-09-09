package Q1;

import Utils.Console;

public class Prog82a {
    static class Ticket {
        private int limit;
        private int speed;

        public Ticket(int l, int s) {
            limit = l;
            speed = s;
        }

        public int getTicketCost() {
            return 20 + (speed - limit) * 5;
        }
    }

    public static void main(String[] args) {
        int limit = Console.input("Enter speed limit: ");
        int speed = Console.input("Enter car's speed: ");
        Ticket ticket = new Ticket(limit, speed);
        System.out.println("The fine is: $" + ticket.getTicketCost() + ".00");
    }
}
/*
Enter speed limit: 35
Enter car's speed: 52
The fine is: $105.00
 */