package no.miles.uibinf101;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String fornavn;
    private String etternavn;
    private List<Fag> fag;

    public Student(String fornavn, String etternavn) {
        if(fornavn == null || etternavn == null) {
            throw new IllegalArgumentException("Både fornavn og etternavn må oppgis");
        }

        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fag = new ArrayList<Fag>();
    }

    public String lagKarakterutskrift() {

        String rapport = "Studentrapport\n";
        rapport += "Student: " + fornavn + " " + etternavn + "\n\n";

        if(fag.size() == 0) {
            rapport += "Ingen fag funnet";
        } else {
            rapport = rapport + "Kode\tFagnavn\tKarakter\n";
            int sumKarakterer = 0;
            int sumStudiepoeng = 0;
            int antallfag = 0;
            for(Fag faget : fag) {
                String karakter = String.valueOf(faget.getKarakter());
                if(karakter.equals("0") || karakter.equals("1")) {
                    karakter = "Stryk";
                } else {
                    sumStudiepoeng += faget.getAntallStudiepoeng();
                    sumKarakterer += faget.getKarakter();
                    antallfag += 1;
                }
                rapport += faget.getKode() + "\t" + faget.getNavn() + "\t" + karakter + "\n";
            }
            rapport += "\n";
            rapport += "Gjennomsnittskarakter:" + (sumKarakterer * 1.0 / antallfag) + "\n";
            rapport += "Antall beståtte studiepoeng:" + sumStudiepoeng + "\n";
        }

        System.out.println(rapport);

        return rapport;
    }

    public void leggTilFag(Fag fag) {
        this.fag.add(fag);
    }
}