public class Walec extends Prezent{
    private double promien;
    private double wysokosc;

    public Walec(double promien, double wysokosc, String nazwa) {
        super(nazwa);
        this.promien = promien;
        this.wysokosc = wysokosc;
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    @Override
    public double area() {
        return 2*Math.PI*promien*(promien+wysokosc);
    }

    @Override
    public String toString() {
        return "Walec: \nPromien: " + promien + "\nWysokosc: " + wysokosc + "\n" + super.toString();
    }
}
