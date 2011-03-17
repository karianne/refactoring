package no.miles.uibinf101;

public class Navn {
    private final String fornavn;
    private final String etternavn;

    public Navn(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        validerNavn();
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void validerNavn() {
        if(getFornavn() == null || getEtternavn() == null) {
            throw new IllegalArgumentException("Både fornavn og etternavn må oppgis");
        }
    }

    public String formaterFulltNavn() {
        return getFornavn() + " " + getEtternavn();
    }
}
