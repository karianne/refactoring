package no.miles.uibinf101;

public class Student {

    private Navn navn;
    private Fagliste alleFag;
    private String rapport;

    public Student(Navn navn) {
        this.navn = navn;

        this.alleFag = new Fagliste();
    }

    public String lagKarakterutskrift() {

        rapport = skrivOverskrift();

        if(harIngenFag()) {
            skrivIngenFag();
        } else {
            skrivKaraktertabell();
        }

        return rapport;
    }

    private void skrivKaraktertabell() {
        skrivTabelloverskrift();
        for(Fag fag : alleFag) {
            skrivTabellinje(fag, finnKarakterSomString(fag));
        }
        rapport += "\n";
        rapport += "Gjennomsnittskarakter:" + alleFag.getGjennomsnittskarakter() + "\n";
        rapport += "Antall beståtte studiepoeng:" + alleFag.getSumStudiepoeng() + "\n";
    }

    private String finnKarakterSomString(Fag fag) {
        String karakter = String.valueOf(fag.getKarakter());
        if(fag.erStryk()) {
            karakter = "Stryk";
        }
        return karakter;
    }

    private void skrivTabellinje(Fag faget, String karakter) {
        rapport += faget.getKode() + "\t" + faget.getNavn() + "\t" + karakter + "\n";
    }

    private void skrivTabelloverskrift() {
        rapport = rapport + "Kode\tFagnavn\tKarakter\n";
    }

    private void skrivIngenFag() {
        rapport += "Ingen fag funnet";
    }

    private boolean harIngenFag() {
        return alleFag.size() == 0;
    }

    private String skrivOverskrift() {
        String rapport = "Studentrapport\n";
        rapport += "Student: " + navn.formaterFulltNavn() + "\n\n";
        return rapport;
    }

    public void leggTilFag(Fag fag) {
        this.alleFag.add(fag);
    }
}