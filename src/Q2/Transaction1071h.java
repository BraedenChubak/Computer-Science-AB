package Q2;

public class Transaction1071h implements Comparable<Transaction1071h> {
    public int prodCode;
    public int quantity;
    public double value;

    public Transaction1071h(int c, int q, double v) {
        prodCode = c;
        quantity = q;
        value = v;
    }

    @Override
    public int compareTo(Transaction1071h o) {
        return 0;
    }
}
