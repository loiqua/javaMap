package com.marcheur;

import com.marcheur.carte.Rue;
import com.marcheur.parcours.Parcours;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MarcheurBlanc {
    private final String nom;
    private String lieuActuel;
    private String destination;
    private final Parcours parcours;
    private final List<String> chemin;
    private final Set<String> lieuxVisites;

    public MarcheurBlanc(String nom, String lieuDepart, Parcours parcours) {
        this.nom = nom;
        this.lieuActuel = lieuDepart;
        this.parcours = parcours;
        this.chemin = new ArrayList<>();
        this.lieuxVisites = new HashSet<>();
        this.chemin.add(lieuDepart);
        this.lieuxVisites.add(lieuDepart);
    }

    public String getNom() {
        return nom;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<String> marcherAleatoirement() {
        Random random = new Random();

        while (!lieuActuel.equals(destination)) {
            List<Rue> rues = parcours.obtenirRues(lieuActuel);
            if (rues == null || rues.isEmpty()) {
                if (chemin.size() > 1) {
                    chemin.remove(chemin.size() - 1);
                    lieuActuel = chemin.get(chemin.size() - 1);
                } else {
                    break;
                }
                continue;
            }

            Collections.shuffle(rues, random);

            List<Rue> ruesDisponibles = new ArrayList<>();
            for (Rue rue : rues) {
                String prochainLieu = rue.getLieu1().getNom().equals(lieuActuel) ? rue.getLieu2().getNom() : rue.getLieu1().getNom();
                if (!lieuxVisites.contains(prochainLieu) || prochainLieu.equals(destination)) {
                    ruesDisponibles.add(rue);
                }
            }

            if (ruesDisponibles.isEmpty()) {
                if (chemin.size() > 1) {
                    chemin.remove(chemin.size() - 1);
                    lieuActuel = chemin.get(chemin.size() - 1);
                } else {
                    break;
                }
                continue;
            }

            Rue rue = ruesDisponibles.get(random.nextInt(ruesDisponibles.size()));
            String prochainLieu = rue.getLieu1().getNom().equals(lieuActuel) ? rue.getLieu2().getNom() : rue.getLieu1().getNom();
            chemin.add(prochainLieu);
            lieuActuel = prochainLieu;
            lieuxVisites.add(prochainLieu);
        }

        return chemin;
    }
}
