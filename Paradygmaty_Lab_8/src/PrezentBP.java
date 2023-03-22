import java.util.Arrays;

public class PrezentBP {
    private RodzajPaczki rodzaj;
    private String nazwa;
    private double[] dims;

    public PrezentBP(RodzajPaczki rodzaj, String nazwa, double[] dims) {
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
        this.dims = dims;
    }

    public RodzajPaczki getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(RodzajPaczki rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double[] getDims() {
        return dims;
    }

    public void setDims(double[] dims) {
        this.dims = dims;
    }

    public double area() {
        switch (rodzaj) {
            case KULA:
                return 4*Math.PI*dims[0]*dims[0];
            case PROSTOPADLOSCIAN:
                return dims[0]*dims[1]*dims[2];
            case WALEC:
                return 2*Math.PI*dims[0]*(dims[0]+dims[1]);
        }
        return 1;
    }

    @Override
    public String toString() {
        return rodzaj +
                "\n Nazwa: " + nazwa + "\n";
    }
}
