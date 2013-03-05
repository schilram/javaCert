package ch.zhaw.javacert.uebungen.Woche2.Uebung2;

/**
 * @author rschilling
 */
public class Kunde {

    private String name;
    private String nachname;
    private Integer kdNr;

    public Kunde(final String name, final String nachname, final Integer kdNr) {
        this.name = name;
        this.nachname = nachname;
        this.kdNr = kdNr;
    }

    public int getKdNr() {
        return kdNr;
    }

    public void setKdNr(final int kdNr) {
        this.kdNr = kdNr;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(final String nachname) {
        this.nachname = nachname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof Kunde) {
            final Kunde k = (Kunde) o;
            if (hashCode() == k.hashCode()
                    && name.equals(k.getName())
                    && nachname.equals(k.getNachname())
                    && kdNr.equals(k.getKdNr())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int i = 13;
        return (((i + kdNr) * i  + name.length()) * i + nachname.length()) * i;
    }

    @Override
    public String toString() {
        return (kdNr + " - " + +" - ")
    }
}
