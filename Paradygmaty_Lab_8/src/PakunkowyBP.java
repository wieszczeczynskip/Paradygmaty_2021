public class PakunkowyBP {
    private double min;
    private double max;

    public PakunkowyBP(double min, double max) {
        this.min = min;
        this.max = max;
    }



    public PapierBP opakuj(PrezentBP prezent) {
        if (prezent.area() < min) {
            return new PapierCzerwonyBP(prezent);
        }
        if (prezent.area() > max) {
            return new PapierZoltyBP(prezent);
        }
        return new PapierNiebieskiBP(prezent);
    }
}
