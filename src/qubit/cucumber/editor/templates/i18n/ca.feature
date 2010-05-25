# language: ca
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/ca/features/suma.feature
# Updated: Tue May 25 15:51:36 +0200 2010
Característica: Suma
  Per evitar fer errors tontos
  Com un matemàtic idiota
  Vull saber la suma dels números

  Esquema de l'escenari: Sumar dos números
    Donat que he introduït <entrada_1> a la calculadora
    I que he introduït <entrada_2> a la calculadora
    Quan premo el <botó>
    Aleshores el resultat ha de ser <resultat> a la pantalla

  Exemples:
    | entrada_1 | entrada_2 | botó | resultat |
    | 20        | 30        | add  | 50       |
    | 2         | 5         | add  | 7        |
    | 0         | 40        | add  | 40       |