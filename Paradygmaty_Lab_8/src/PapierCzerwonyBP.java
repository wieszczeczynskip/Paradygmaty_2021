public class PapierCzerwonyBP extends PapierBP{
    public PapierCzerwonyBP(PrezentBP prezent) {
        super(prezent);
    }

    @Override
    public String toString() {
        return "Papier czerwony: \n" + super.toString();
    }
}
