package fr.yach17.sth.domain;

/**
 * Projet StairwaysToHeavens
 * Créé par yach17 le 05/02/2015.
 */
public class EscalierDroitCalculateur {
    private static final Dimension.Unit UNITE_PAR_DEFAUT = Dimension.Unit.CENTIMETRES;

    private static final Dimension ECHAPEE_DEFAUT = Dimension.from(210, UNITE_PAR_DEFAUT);

    private static final Dimension PAS_DE_FOULEE_DEFAUT = Dimension.from(63, UNITE_PAR_DEFAUT);



    public EscalierDroitCalculateur() {
    }

    public EscalierDroit calculerEscalier(EscalierDroitContraintes c) {

        Dimension diviseur = c.getHauteur().soustraire(c.getHauteurSousPlafond()).ajouter(ECHAPEE_DEFAUT);
        Dimension longueurEscalier = c.getHauteur().multiplierPar(c.getLongueurTremie().diviserPar(diviseur));
        int nombreDeMarches = (int) (c.getHauteur().multiplierPar(2).ajouter(longueurEscalier)).diviserPar(PAS_DE_FOULEE_DEFAUT);
        return new EscalierDroit(longueurEscalier, c.getHauteur(), nombreDeMarches);
    }

}
