package com.marcheur;

import com.marcheur.carte.Carte;
import com.marcheur.parcours.Parcours;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class MarcheurApplication {

    private static final Logger logger = Logger.getLogger(MarcheurApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(MarcheurApplication.class, args);
    }

    @PostConstruct
    public void run() {
        Carte carte = new Carte();
        String[] lieux = {"HEI", "Pullman", "Balançoire", "ESTI", "Boulevard de l'Europe", "Nexta", "Marais", "Sekolintsika"};
        for (String lieu : lieux) {
            carte.ajouterLieu(lieu);
        }

        String[][] rues = {
                {"HEI", "Pullman", "Rue Andriantsihoarana"},
                {"Pullman", "Balançoire", "Rue Ranaivo"},
                {"Balançoire", "ESTI", "Rue Balançoire-ESTI"},
                {"Balançoire", "Boulevard de l'Europe", "Rue Balançoire-Boulevard"},
                {"Pullman", "Nexta", "Rue Pullman-Nexta"},
                {"HEI", "Marais", "Rue HEI-Marais"},
                {"Marais", "Sekolintsika", "Rue Marais-Sekolintsika"}
        };

        for (String[] rue : rues) {
            carte.ajouterRue(rue[0], rue[1], rue[2]);
        }

        Parcours parcours = new Parcours(carte);
        MarcheurBlanc marcheur = new MarcheurBlanc("Bjarni", "HEI", parcours);
        marcheur.setDestination("ESTI");
        List<String> chemin = marcheur.marcherAleatoirement();
        logger.info("Chemin vers ESTI: " + chemin);
    }
}
