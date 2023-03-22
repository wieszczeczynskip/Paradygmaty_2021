public class PapierZolty extends Papier{
    public PapierZolty(Prezent prezent) {
        super(prezent);
    }

    @Override
    public String toString() {
        return "Papier zolty: \n" + super.toString();
    }
}
