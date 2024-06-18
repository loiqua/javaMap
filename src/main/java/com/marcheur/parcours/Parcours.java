package com.marcheur.parcours;

import com.marcheur.carte.Carte;
import com.marcheur.carte.Rue;
import java.util.List;

public class Parcours {
    private final Carte carte;

    public Parcours(Carte carte) {
        this.carte = carte;
    }

    public List<Rue> obtenirRues(String nomLieu) {
        return carte.getLieu(nomLieu).getRues();
    }
}

