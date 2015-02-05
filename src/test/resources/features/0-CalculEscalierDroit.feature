#language: fr
Fonctionnalité: Calculer les caractétistiques maximales d'un escalier droit
  Connaissant les contraintes de la pièce : trémie existante, recul maximum, calculer le + grand escalier réalisable.
  (indépendemment de toute contrainte technique)
  Les caractéristiques à calculer sont :
  - longueur maximale,
  - angle,
  - giron,
  - hauteur de marche (?)
  - nombre de marches

  Plan du scénario: Calculer  d'un escalier en connaissant hauteur, longueur de trémie et hauteur sous plafond
    Etant donné des contraintes avec une hauteur de <hauteur>, une longueur de trémie de  <longueurTremie>, une hauteur sous plafond de <hauteurSousPlafond>
    Lorsque je calcule les caractéristiques de l'escalier droit
    Alors ses caractéristiques sont les suivantes :
      | caractéristique   | valeur                   |
      | longueur totale   | <longueurTotaleAttendue> |
      | pente             | <penteAttendue>          |
      | nombre de marches | <nombreMarchesAttendues> |
      | hauteur de marche | <hauteurMarcheAttendue>  |
      | giron             | <gironAttendu>           |
      | pas de foulée     | <pasFouleeAttendu>       |

  Exemples:
    | hauteur | longueurTremie | hauteurSousPlafond | longueurTotaleAttendue | penteAttendue | nombreMarchesAttendues | hauteurMarcheAttendue | gironAttendu | pasFouleeAttendu |
    | 275     | 300            | 250                | 351                    | 38            | 14                     | 20                    | 25           | 64               |
