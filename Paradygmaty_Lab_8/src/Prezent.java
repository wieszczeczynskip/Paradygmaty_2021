public class Prezent {

    private String nazwa;

    public Prezent(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getName() {
        return nazwa;
    }

    public void setName(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Nazwa: " + nazwa + "\n";
    }

    public double area() {
        return 1;
    }
}
