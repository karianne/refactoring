package no.miles.uibinf101;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentTest {
    private static final String FORNAVN = "Kåre";
    private static final String ETTERNAVN = "Test";
    private Student student;
    private static final Fag INF100 = new Fag("INF100", "Java-1", 4, 10);
    private static final Fag INF101 = new Fag("INF101", "Java-2", 6, 10);
    private static final Fag STRYKFAG = new Fag("STRYKFAG", "Infvit", 1, 10);

    @Before
    public void setup() {
        student = new Student(new Navn(FORNAVN, ETTERNAVN));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullSomFornavnGirFeil() {
        new Student(new Navn(null, ETTERNAVN));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullSomEtternavnGirFeil() {
        new Student(new Navn(FORNAVN, null));
    }

    @Test
    public void ingenFagGirTomRapport() {
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("Ingen fag funnet"));
    }

    @Test
    public void ettFagGirIkkeTomRapport() {
        student.leggTilFag(INF100);
        String rapport = student.lagKarakterutskrift();
        assertFalse(rapport.contains("Ingen fag funnet"));
    }

    @Test
    public void rapportHarOverskrift() {
        student.leggTilFag(INF100);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("Studentrapport\n"));
    }

    @Test
    public void rapportHarStudentnavn() {
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("Student:"));
        assertTrue(rapport.contains(FORNAVN));
        assertTrue(rapport.contains(ETTERNAVN));
    }

    @Test
    public void rapportHarIngenGjennomsnittskarakterDersomDetIkkeErNoenFag() {
        String rapport = student.lagKarakterutskrift();
        assertFalse(rapport.contains("Gjennomsnittskarakter\n"));
    }

    @Test
    public void rapportHarGjennomsnittskarakterDersomDetErNoenStudenter() {
        student.leggTilFag(INF100);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("Gjennomsnittskarakter:"));
    }

    @Test
    public void rapportHarAntallBestaatteStudiepoengDersomDetErNoenStudenter() {
        student.leggTilFag(INF100);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("Antall beståtte studiepoeng:"));
    }

    @Test
    public void antallBestaatteStudiepoengForEttTipoengsfagMedBestaattKarakterEr10() {
        student.leggTilFag(INF100);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("studiepoeng:10"));
    }

    @Test
    public void antallBestaatteStudiepoengForToTipoengsfagMedBestaattKarakterEr20() {
        student.leggTilFag(INF100);
        student.leggTilFag(INF101);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("studiepoeng:20"));
    }

    @Test
    public void antallBestatteStudiepoengForEttTipoengsfagOgEtStrykfagEr10() {
        student.leggTilFag(INF100);
        student.leggTilFag(STRYKFAG);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("studiepoeng:10"));
    }
    
    @Test
    public void gjennomsnittskarakterForEttBestaattFagErLikKarakterenIFaget() {
        student.leggTilFag(INF100);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("karakter:4.0"));
    }

    @Test
    public void gjennomsnittskarakterForToBestatteFagErLikKaraktereneIFagetDeltPaaTo() {
        student.leggTilFag(INF100);
        student.leggTilFag(INF101);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("karakter:5.0"));
    }

    @Test
    public void rapportSkalSkriveUtStrykForKarakterDersomDetErStrykkarakter() {
        student.leggTilFag(STRYKFAG);
        String rapport = student.lagKarakterutskrift();
        assertTrue(rapport.contains("Stryk"));
        assertFalse(rapport.contains("1.0"));
    }
    
}