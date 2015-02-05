package fr.yach17.sth.tests.steps;

import cucumber.api.DataTable;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsque;
import fr.yach17.sth.domain.EscalierDroit;
import fr.yach17.sth.domain.EscalierDroitCalculateur;
import fr.yach17.sth.domain.EscalierDroitContraintes;

import javax.inject.Singleton;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;

import static fr.yach17.sth.domain.Dimension.Unit.CENTIMETRES;
import static fr.yach17.sth.domain.Dimension.from;

/**
 * Projet StairwaysToHeavens
 * Créé par yach17 le 04/02/2015.
 */
@Singleton
public class CalculerCaracteristiquesEscalierDroitSteps {

    private EscalierDroitContraintes contraintes;
    private EscalierDroit escalier;

    @Etantdonné("^^des contraintes avec une hauteur de (\\d+), une longueur de trémie de  (\\d+), une hauteur sous plafond de (\\d+)$")
    public void copntraintesEscalier(int hauteur, int longueurTremie, int hauteurSousPlafond) throws Throwable {
        contraintes = EscalierDroitContraintes.builder()
                .setHauteur(from(hauteur, CENTIMETRES))
                .setLongueurTremie(from(longueurTremie, CENTIMETRES))
                .setHauteurSousPlafond(from(hauteurSousPlafond, CENTIMETRES))
                .build();
    }


    @Lorsque("^je calcule les caractéristiques de l'escalier droit$")
    public void je_calcule_les_caractéristiques_de_l_escalier_droit() throws Throwable {
        escalier = new EscalierDroitCalculateur().calculerEscalier(contraintes);
    }

    @Alors("^ses caractéristiques sont les suivantes :$")
    public void ses_caractéristiques_sont_les_suivantes_(DataTable caracteristiquesAttendues) throws Throwable {
        DataTable caracteristiquesObtenues = createDatatableFrom(escalier);
        caracteristiquesAttendues.diff(caracteristiquesObtenues);
    }

    /**
     * créé et renvoie une DataTable représentant l'escalier en paramètre, dans un format semblable à celui décrit dans la feature
     *
     * @param e l'escalier à représenter sous forme de datatable
     * @return la datatable représentant l'escalier
     */
    private DataTable createDatatableFrom(EscalierDroit e) {
        DecimalFormat df = new DecimalFormat("#");
        return DataTable.create(
                Arrays.asList(
                        Arrays.asList("caractéristique", "valeur"),
                        Arrays.asList("longueur totale", df.format(e.getLongueur().getValeurEn(CENTIMETRES))),
                        Arrays.asList("pente", df.format(e.getPente())),
                        Arrays.asList("nombre de marches", df.format(e.getNombreMarches())),
                        Arrays.asList("hauteur de marche", df.format(e.getHauteurMarche().getValeurEn(CENTIMETRES))),
                        Arrays.asList("giron", df.format(e.getGiron().getValeurEn(CENTIMETRES))),
                        Arrays.asList("pas de foulée", df.format(e.getPasDeFoulee().getValeurEn(CENTIMETRES)))
                ),
                Locale.getDefault(),
                "caractéristique", "valeur"
        );

    }

}
