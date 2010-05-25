# language: fr
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/fr/features/addition.feature
# Updated: Tue May 25 15:51:55 +0200 2010
Fonctionnalité: Addition
  Afin de gagner du temps lors du calcul de la facture
  En tant que commerçant
  Je souhaite pouvoir faire une addition

  Plan du Scénario: Addition de deux nombres
    Soit une calculatrice
    Et que j'entre <a> pour le premier nombre
    Et que je tape sur la touche "+"
    Et que j'entre <b> pour le second nombre
    Lorsque je tape sur la touche "="
    Alors le résultat affiché doit être <somme>

    Exemples:
      | a | b | somme |
      | 2 | 2 | 4     |
      | 2 | 3 | 5     |
