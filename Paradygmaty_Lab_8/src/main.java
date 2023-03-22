import javax.swing.*;

public class main {
    public static void main(String[] args) {
        Kula kula = new Kula(5, "pilka");
        Prostopadloscian p = new Prostopadloscian(2, 3, 4, "klatka");
        Walec walec = new Walec(5, 10, "walek");
        Pakunkowy elf1 = new Pakunkowy(100, 400);
        Papier prezent1 = elf1.opakuj(kula);
        System.out.println(prezent1);
        Papier prezent2 = elf1.opakuj(p);
        System.out.println(prezent2);
        Papier prezent3 = elf1.opakuj(walec);
        System.out.println(prezent3);

        //BP
        double[] wymiary1 = new double[] {5};
        PrezentBP paczka1 = new PrezentBP(RodzajPaczki.KULA, "pilka", wymiary1);
        double[] wymiary2 = new double[] {2, 3, 4};
        PrezentBP paczka2 = new PrezentBP(RodzajPaczki.PROSTOPADLOSCIAN, "klatka", wymiary2);
        double[] wymiary3 = new double[] {5, 10};
        PrezentBP paczka3 = new PrezentBP(RodzajPaczki.WALEC, "walek", wymiary3);
        PakunkowyBP elfBP = new PakunkowyBP(100, 400);
        PapierBP opakowany1 = elfBP.opakuj(paczka1);
        PapierBP opakowany2 = elfBP.opakuj(paczka2);
        PapierBP opakowany3 = elfBP.opakuj(paczka3);
        System.out.println(opakowany1);
        System.out.println(opakowany2);
        System.out.println(opakowany3);
    }
}
