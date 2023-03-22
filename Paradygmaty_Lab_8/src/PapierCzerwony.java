public class PapierCzerwony extends Papier{

    public PapierCzerwony(Prezent prezent) {
        super(prezent);
    }

    @Override
    public String toString() {
        return "Papier czerwony: \n" + super.toString();
    }
}
