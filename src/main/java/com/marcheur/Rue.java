package com.marcheur;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Rue {
    private final Lieu lieu1;
    private final Lieu lieu2;
    private final String nom;
}