package ch.zhaw.javacert.uebungen.Woche2.Uebung2;

/**
 * @author rschilling
 */
public class Main {

    public static void main(String[] args) {
        Kunde k1 = new Kunde("Meier", "Hans", 1);
        Kunde k2 = new Kunde("Müller", "Peter", 2);
        Kunde k3 = new Kunde("Meier", "Hans", 1);

        System.out.println("Vergleich k1-k2: " + k1.equals(k2));
        System.out.println("Vergleich k1-k3: " + k1.equals(k3));
        System.out.println("Vergleich k2-k3: " + k2.equals(k3));
    }
}
