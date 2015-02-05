package fr.yach17.sth.domain;

import static java.lang.Math.atan;
import static java.lang.Math.toDegrees;

/**
 * Projet StairwaysToHeavens
 * Créé par yach17 le 04/02/2015.
 */
public class EscalierDroit {
    private final Dimension longueur;
    private final Dimension hauteur;
    private final int nombreMarches;

    public EscalierDroit(Dimension longueur, Dimension hauteur, int nombreMarches) {
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.nombreMarches = nombreMarches;
    }



    public Dimension getLongueur() {
        return longueur;
    }

    public Dimension getHauteur() {
        return hauteur;
    }

    public Dimension getHauteurMarche() {
        return hauteur.diviserPar(nombreMarches);
    }

    public Dimension getGiron() {
        return longueur.diviserPar(nombreMarches);
    }

    public double getPente() {
        return toDegrees(atan(hauteur.diviserPar(longueur)));
    }

    public int getNombreMarches() {
        return nombreMarches;
    }

    public Dimension getPasDeFoulee() {
        return getHauteurMarche().multiplierPar(2).ajouter(getGiron());
    }
}
