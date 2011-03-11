package no.miles.uibinf101;

public class Fag {
    private String kode;
    private String navn;
    private int karakter;
    private int antallStudiepoeng;

    public Fag(String kode, String navn, int karakter, int antallStudiepoeng) {
        this.kode = kode;
        this.navn = navn;
        this.karakter = karakter;
        this.antallStudiepoeng = antallStudiepoeng;
    }

    public String getKode() {
        return kode;
    }

    public String getNavn() {
        return navn;
    }

    public int getKarakter() {
        return karakter;
    }

    public int getAntallStudiepoeng() {
        return antallStudiepoeng;
    }
}
