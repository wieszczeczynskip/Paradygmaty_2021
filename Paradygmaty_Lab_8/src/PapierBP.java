public class PapierBP {
    private PrezentBP prezent;

    public PapierBP(PrezentBP prezent) {
        this.prezent = prezent;
    }

    @Override
    public String toString() {
        return prezent.toString();
    }
}
