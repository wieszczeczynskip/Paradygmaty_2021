public class Papier {

    private Prezent prezent;

    public Papier(Prezent prezent) {
        this.prezent = prezent;
    }

    @Override
    public String toString() {
        return prezent.toString();
    }
}
