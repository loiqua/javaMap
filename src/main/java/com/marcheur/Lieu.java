package com.marcheur;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Lieu {
    private final String nom;
    private final List<Rue> rues = new ArrayList<>();

    public void ajouterRue(Rue rue) {
        rues.add(rue);
    }
}