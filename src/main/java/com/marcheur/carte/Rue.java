package com.marcheur.carte;

public class Rue {
    private final Lieu lieu1;
    private final Lieu lieu2;
    private final String nom;

    public Rue(Lieu lieu1, Lieu lieu2, String nom) {
        this.lieu1 = lieu1;
        this.lieu2 = lieu2;
        this.nom = nom;
    }

    public Lieu getLieu1() {
        return lieu1;
    }

    public Lieu getLieu2() {
        return lieu2;
    }

    public String getNom() {
        return nom;
    }
}
