public class PapierNiebieskiBP extends PapierBP{
    public PapierNiebieskiBP(PrezentBP prezent) {
        super(prezent);
    }

    @Override
    public String toString() {
        return "Papier niebieski: \n" + super.toString();
    }
}
