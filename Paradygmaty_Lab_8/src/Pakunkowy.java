public class Pakunkowy {

    private double min;
    private double max;

    public Pakunkowy(double min, double max) {
        this.min = min;
        this.max = max;
    }



    public Papier opakuj(Prezent prezent) {
        if (prezent.area() < min) {
            return new PapierCzerwony(prezent);
        }
        if (prezent.area() > max) {
            return new PapierZolty(prezent);
        }
        return new PapierNiebieski(prezent);
    }
}
