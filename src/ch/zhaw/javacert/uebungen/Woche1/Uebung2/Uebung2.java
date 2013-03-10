package ch.zhaw.javacert.uebungen.Woche1.Uebung2;

/**
 * @author: rschilling
 */
public class Uebung2 {
// ------------------------------ FIELDS ------------------------------

    public static final String STATIC_STRING = "finaler String";

    private static int z = 5;

    public String publicString;
    public int publicInt;

    private int x, y;

    private String string;
    private Integer integer;

// -------------------------- STATIC METHODS --------------------------

    static {
        z = z * z;
        System.out.println("static Initializer");
    }

// --------------------------- CONSTRUCTORS ---------------------------

    public Uebung2(final String string) {
        this.string = string;
        System.out.println("Constructor");
    }

    {
        x = 1;
        y = 2;
        System.out.println("Initializer");
    }

    public static void main(final String[] args) {
        final Uebung2 u = new Uebung2("was");

    }
}
