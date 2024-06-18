package com.marcheur.carte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carte {
    private final Map<String, Lieu> lieux;
    private final List<Rue> rues;

    public Carte() {
        this.lieux = new HashMap<>();
        this.rues = new ArrayList<>();
    }

    public void ajouterLieu(String nom) {
        lieux.put(nom, new Lieu(nom));
    }

    public void ajouterRue(String nomLieu1, String nomLieu2, String nomRue) {
        Lieu lieu1 = lieux.get(nomLieu1);
        Lieu lieu2 = lieux.get(nomLieu2);
        if (lieu1 != null && lieu2 != null) {
            Rue rue = new Rue(lieu1, lieu2, nomRue);
            rues.add(rue);
            lieu1.addRue(rue);
            lieu2.addRue(rue);
        }
    }

    public Lieu getLieu(String nom) {
        return lieux.get(nom);
    }

    public List<Rue> getRues() {
        return rues;
    }
}
