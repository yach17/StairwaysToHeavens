package fr.yach17.sth.domain;



public class EscalierDroitContraintes {
    private final Dimension hauteur;
    private final Dimension longueurTremie;
    private final Dimension hauteurSousPlafond;


    private EscalierDroitContraintes(Dimension hauteur, Dimension longueurTremie, Dimension hauteurSousPlafond) {
        this.hauteur = hauteur;
        this.longueurTremie = longueurTremie;
        this.hauteurSousPlafond = hauteurSousPlafond;
    }

    public static Builder builder(){
        return new Builder();
    }

    public Dimension getHauteur() {
        return hauteur;
    }

    public Dimension getLongueurTremie() {
        return longueurTremie;
    }

    public Dimension getHauteurSousPlafond() {
        return hauteurSousPlafond;
    }

    public static class Builder {
        private Dimension hauteur;
        private Dimension longueurTremie;
        private Dimension hauteurSousPlafond;

        public Builder setHauteur(Dimension hauteur) {
            this.hauteur = hauteur;
            return this;
        }

        public Builder setLongueurTremie(Dimension longueurTremie) {
            this.longueurTremie = longueurTremie;
            return this;
        }

        public Builder setHauteurSousPlafond(Dimension hauteurSousPlafond) {
            this.hauteurSousPlafond = hauteurSousPlafond;
            return this;
        }

        public EscalierDroitContraintes build() {
            return new EscalierDroitContraintes(hauteur, longueurTremie, hauteurSousPlafond);
        }
    }
}
