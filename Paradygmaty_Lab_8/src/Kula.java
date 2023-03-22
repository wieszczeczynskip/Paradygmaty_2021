public class Kula extends Prezent{
    private double promien;

    public Kula(double promien, String nazwa) {
        super(nazwa);
        this.promien = promien;
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    @Override
    public double area() {
        return 4*Math.PI*promien*promien;
    }

    @Override
    public String toString() {
        return "Kula:\nPromien: " + promien + "\n" + super.toString();
    }
}
