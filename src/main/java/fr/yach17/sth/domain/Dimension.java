package fr.yach17.sth.domain;

/**
 * Created by SaYaQuenGa on 05/02/2015.
 * représente une longueur
 */
public class Dimension {
    private double valeur;
    private Unit unite;

    private Dimension(Number valeur, Unit unite) {
        this.valeur = valeur.doubleValue();
        this.unite = unite;
    }

    public static Dimension from(Number longueur, Unit unite) {
        return new Dimension(longueur, unite);
    }

    public double getValeurEn(Unit targetUnit) {
        return  valeur * targetUnit.facteur / unite.facteur;
    }

    public Dimension diviserPar(Number diviseur) {
        return from(this.getValeurEn(unite) / diviseur.doubleValue(), unite);
    }

    /**
     * une dimension divisée par une dimension donne un simple nombre
     * @param diviseur la dimension par laquelle on divise
     * @return le résultat sous la forme d'un nombre sans dimension
     */
    public double diviserPar(Dimension diviseur) {
        return valeur / diviseur.getValeurEn(unite);
    }

    public Dimension multiplierPar(Number facteur) {
        return from(valeur * facteur.doubleValue(), unite);
    }

    public Dimension ajouter(Dimension autre) {
        return from(autre.getValeurEn(unite) + valeur, unite);
    }

    public Dimension soustraire(Dimension autre) {
        return from(valeur - autre.getValeurEn(unite), unite);
    }


    /**
     * Unités de valeur (système métrique pour l'instant)
     */
    public static enum Unit {
        CENTIMETRES(10), METRES(1000), MILLIMETRES(1);
        private final int facteur;

        Unit(int facteur) {
            this.facteur = facteur;
        }


    }
}
