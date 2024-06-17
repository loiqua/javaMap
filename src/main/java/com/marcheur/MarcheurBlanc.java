package com.marcheur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarcheurBlanc {
    private final Carte carte;
    private final String nom;
    private Lieu lieuActuel;
    private String destination;

    public MarcheurBlanc(Carte carte, String nom, String lieuDepart) {
        this.carte = carte;
        this.nom = nom;
        this.lieuActuel = carte.obtenirLieu(lieuDepart);
    }

    public String getNom() {
        return nom;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<String> marcherAleatoirement() {
        List<String> chemin = new ArrayList<>();
        chemin.add(lieuActuel.getNom());
        Random random = new Random();

        while (!lieuActuel.getNom().equals(destination)) {
            List<Rue> rues = lieuActuel.getRues();
            Rue rue = rues.get(random.nextInt(rues.size()));
            lieuActuel = rue.getLieu1().equals(lieuActuel) ? rue.getLieu2() : rue.getLieu1();
            chemin.add(lieuActuel.getNom());
        }

        return chemin;
    }
}