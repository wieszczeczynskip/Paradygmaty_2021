
public class main {
    public static void main(String[] args) throws InterruptedException {
        Czajnik czajnik = new Czajnik(2000);
        Osoba o1 = new Osoba(350, 7000, "syn", czajnik);
        Osoba o2 = new Osoba(400, 8000, "tata", czajnik);
        Osoba o3 = new Osoba(200, 9000, "mama", czajnik);
        Osoba o4 = new Osoba(300, 11000, "corka", czajnik);


        czajnik.napelnij();
        czajnik.nalej(o1);
        while(true) {

        }
    }
}
