package com.marcheur;

import lombok.Getter;

import java.util.*;

@Getter
public class Carte {
    private final Map<String, Lieu> lieux = new HashMap<>();
    private final List<Rue> rues = new ArrayList<>();

    public void ajouterLieu(String nom) {
        if (!lieux.containsKey(nom)) {
            lieux.put(nom, new Lieu(nom));
        }
    }

    public void ajouterRue(String nomLieu1, String nomLieu2, String nomRue) {
        if (lieux.containsKey(nomLieu1) && lieux.containsKey(nomLieu2)) {
            Lieu lieu1 = lieux.get(nomLieu1);
            Lieu lieu2 = lieux.get(nomLieu2);
            Rue rue = new Rue(lieu1, lieu2, nomRue);
            lieu1.ajouterRue(rue);
            lieu2.ajouterRue(rue);
            rues.add(rue);
        }
    }

    public Lieu obtenirLieu(String nom) {
        return lieux.get(nom);
    }
}