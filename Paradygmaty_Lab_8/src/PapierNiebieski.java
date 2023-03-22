public class PapierNiebieski extends Papier{
    public PapierNiebieski(Prezent prezent) {
        super(prezent);
    }

    @Override
    public String toString() {
        return "Papier niebieski: \n" + super.toString();
    }
}
