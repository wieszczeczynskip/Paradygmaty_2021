public class Osoba extends Thread{
    String nazwa;
    int kubek;
    int czasPicia;
    Czajnik czajnik;

    public Osoba(int kubek, int czasPicia, String nazwa, Czajnik czajnik) {
        this.nazwa = nazwa;
        this.kubek = kubek;
        this.czasPicia = czasPicia;
        this.czajnik = czajnik;
    }

    void nalej() throws InterruptedException {
        czajnik.nalej(kubek);
        System.out.println(nazwa + " nalał(a) " + kubek + "ml\n");
    }

    @Override
    public void run(){
        while(true) {
            try {
                nalej();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(czasPicia);
            } catch (InterruptedException e) {
                System.out.println("OOPs, I broke the cup :(");
            }
        }
    }
}
