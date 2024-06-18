package com.marcheur.carte;

import java.util.ArrayList;
import java.util.List;

public class Lieu {
    private final String nom;
    private final List<Rue> rues;

    public Lieu(String nom) {
        this.nom = nom;
        this.rues = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Rue> getRues() {
        return rues;
    }

    public void addRue(Rue rue) {
        rues.add(rue);
    }
}
