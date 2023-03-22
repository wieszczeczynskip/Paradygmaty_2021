public class Prostopadloscian extends Prezent{
    private double a;
    private double b;
    private double c;

    public Prostopadloscian(double a, double b, double c, String nazwa) {
        super(nazwa);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double area() {
        return a*b*c;
    }

    @Override
    public String toString() {
        return "Prostopadloscian: \nWymiary: " + a + "x" + b + "x" + c + "\n" + super.toString();
    }
}
