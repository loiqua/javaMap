package com.marcheur.demo;

import com.marcheur.Carte;
import com.marcheur.MarcheurBlanc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMarcheurBlanc {

    private Carte carte;

    @BeforeEach
    void setUp() {
        carte = new Carte();
        String[] lieux = {"HEI", "Pullman", "Balançoire", "ESTI", "Boulevard de l'Europe", "Nexta", "Marais", "Sekolintsika"};
        for (String lieu : lieux) {
            carte.ajouterLieu(lieu);
        }

        String[][] rues = {
                {"HEI", "Pullman", "Rue Andriantsihoarana"},
                {"Pullman", "Balançoire", "Rue Ranaivo"},
                {"Balançoire", "ESTI", null},
                {"Balançoire", "Boulevard de l'Europe", null},
                {"Pullman", "Nexta", null},
                {"HEI", "Marais", null},
                {"Marais", "Sekolintsika", null}
        };

        for (String[] rue : rues) {
            carte.ajouterRue(rue[0], rue[1], rue[2]);
        }
    }

    @Test
    void testMarcheAleatoireVersESTI() {
        MarcheurBlanc marcheur = new MarcheurBlanc(carte, "Bjarni", "HEI");
        marcheur.setDestination("ESTI");
        List<String> chemin = marcheur.marcherAleatoirement();
        assertTrue(chemin.contains("ESTI"));
    }

    @Test
    void testMarcheAleatoireVersNexta() {
        MarcheurBlanc marcheur = new MarcheurBlanc(carte, "Bjarni", "HEI");
        marcheur.setDestination("Nexta");
        List<String> chemin = marcheur.marcherAleatoirement();
        assertTrue(chemin.contains("Nexta"));
    }

    @Test
    void testMarcheAleatoireVersBoulevardDeLEurope() {
        MarcheurBlanc marcheur = new MarcheurBlanc(carte, "Bjarni", "HEI");
        marcheur.setDestination("Boulevard de l'Europe");
        List<String> chemin = marcheur.marcherAleatoirement();
        assertTrue(chemin.contains("Boulevard de l'Europe"));
    }

    @Test
    void testMarcheAleatoireVersMarais() {
        MarcheurBlanc marcheur = new MarcheurBlanc(carte, "Bjarni", "HEI");
        marcheur.setDestination("Marais");
        List<String> chemin = marcheur.marcherAleatoirement();
        assertTrue(chemin.contains("Marais"));
    }

    @Test
    void testMarcheAleatoireVersSekolintsika() {
        MarcheurBlanc marcheur = new MarcheurBlanc(carte, "Bjarni", "HEI");
        marcheur.setDestination("Sekolintsika");
        List<String> chemin = marcheur.marcherAleatoirement();
        assertTrue(chemin.contains("Sekolintsika"));
    }

    @Test
    void testCheminContientLieuDepart() {
        MarcheurBlanc marcheur = new MarcheurBlanc(carte, "Bjarni", "HEI");
        marcheur.setDestination("ESTI");
        List<String> chemin = marcheur.marcherAleatoirement();
        assertEquals("HEI", chemin.get(0));
    }

    @Test
    void testChangerDestinationEnCoursDeRoute() {
        MarcheurBlanc marcheur = new MarcheurBlanc(carte, "Bjarni", "HEI");
        marcheur.setDestination("ESTI");
        List<String> chemin1 = marcheur.marcherAleatoirement();
        assertTrue(chemin1.contains("ESTI"));

        marcheur.setDestination("Nexta");
        List<String> chemin2 = marcheur.marcherAleatoirement();
        assertTrue(chemin2.contains("Nexta"));
    }
}