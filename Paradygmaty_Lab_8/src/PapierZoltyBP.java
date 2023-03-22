public class PapierZoltyBP extends PapierBP{
    public PapierZoltyBP(PrezentBP prezent) {
        super(prezent);
    }

    @Override
    public String toString() {
        return "Papier zolty: \n" + super.toString();
    }
}
