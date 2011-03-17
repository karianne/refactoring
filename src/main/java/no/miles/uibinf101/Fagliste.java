package no.miles.uibinf101;

import java.util.ArrayList;

public class Fagliste extends ArrayList<Fag> {

    private int sumKarakterer = 0;
    int sumStudiepoeng = 0;
    int antallFag = 0;

    @Override
    public boolean add(Fag fag) {
        if(!fag.erStryk()) {
            sumKarakterer += fag.getKarakter();
            sumStudiepoeng += fag.getAntallStudiepoeng();
            antallFag += 1;
        }
        return super.add(fag);
    }

    public int getSumKarakterer() {
        return sumKarakterer;
    }

    public int getSumStudiepoeng() {
        return sumStudiepoeng;
    }

    public int getAntallFag() {
        return antallFag;
    }

    public double getGjennomsnittskarakter() {
        return sumKarakterer * 1.0 / antallFag;
    }
}
