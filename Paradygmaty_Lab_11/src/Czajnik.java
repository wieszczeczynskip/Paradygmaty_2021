import static java.lang.Thread.sleep;

public class Czajnik {
    int pojemnosc;
    int zawartosc;
    boolean czyGotuje;

    public Czajnik(int maxPojemnosc) {
        pojemnosc = maxPojemnosc;
        zawartosc = 0;
        czyGotuje = false;
    }

    public void napelnij() throws InterruptedException {
        zawartosc = pojemnosc;
        czyGotuje = true;
        sleep(10000);
        notify();
        czyGotuje = false;
    }

    void nalej(int ilosc){
        if (ilosc > zawartosc) {
            napelnij();
        }
        zawartosc = zawartosc - ilosc;
    }
}
