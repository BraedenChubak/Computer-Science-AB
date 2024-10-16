package Q1.Pelican37_8;


public class Pelican37_8 implements LinearFunctionMethods {
    private double m;
    private double b;

    public Pelican37_8(double m, double b) {
        this.m = m;
        this.b = b;
    }

    public double getSlope() { return m; }
    public double getYintercept() { return b; }
    public double getRoot() { return -b/m; }

    public double getYvalue(double x) {
        return m * x + b;
    }
    public double getXvalue(double y) {
        return (y - b) / m;
    }
}
