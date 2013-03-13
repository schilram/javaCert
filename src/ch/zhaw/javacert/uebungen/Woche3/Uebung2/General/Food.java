package ch.zhaw.javacert.uebungen.Woche3.Uebung2.General;

/**
 * @author rschilling
 */
public class Food {
    private String name;
    private String beschreibung;

    private int tara;
    private int netto;
    private int brutto;

    private void countTara() {
        tara = brutto - netto;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(final String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(final int tara) {
        this.tara = tara;
    }

    public int getNetto() {
        return netto;
    }

    public void setNetto(final int netto) {
        this.netto = netto;
    }

    public int getBrutto() {
        return brutto;
    }

    public void setBrutto(final int brutto) {
        this.brutto = brutto;
    }
}
