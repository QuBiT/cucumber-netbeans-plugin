# language: fr
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
      | 2 | 2 | 4 |
      | 2 | 3 | 5 |

# language: fr
Fonctionnalité: Addition
Afin de financer mon bonus avec l'argent des pigeons
En tant que trader
Je souhaite pouvoir additionner 2 chiffres

  Plan du Scénario: Addition de produits dérivés
    Soit une calculatrice
    Etant donné qu'on tape <a>
    Et qu'on tape <b>
    Lorsqu'on tape additionner
    Alors le résultat doit être <somme>

  Exemples:
    | a | b | somme |
    | 2 | 2 | 4 |
    | 2 | 3 | 5 |