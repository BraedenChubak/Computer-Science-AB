package Q1.Prog285b;

public class Cl285b implements Comparable<Cl285b>{
    private int id;
    private int code;
    private double sales;
    private double comm;

    private void calc() {
        if (code == 17) {
            if (sales <= 3500) {
                comm = 0.095 * sales;
            } else {
                comm = 0.095 * 3500 + 0.12 * (sales - 3500);
            }
        } else if (code == 5 || code == 8) {
            if (sales <= 5000) {
                comm = 0.075 * sales;
            } else {
                comm = 0.075 * 3500 + 0.085 * (sales - 5000);
            }
        }
    }

    public Cl285b(int id, int code, double sales) {
        this.id = id;
        this.code = code;
        this.sales = sales;
        this.comm = 0;
        calc();
    }

    public String toString() {
        return String.format("%d\t%d\t$%.2f\t$%.2f", id, code, sales, comm);
    }

    public int compareTo(Cl285b o) {
        return id - o.id;
    }
}
