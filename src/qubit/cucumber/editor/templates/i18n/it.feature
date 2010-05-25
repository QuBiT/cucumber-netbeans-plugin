# language: it
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/it/features/somma.feature
# Updated: Tue May 25 15:52:01 +0200 2010
Funzionalità: somma
  Per evitare di fare errori stupidi
  Come utente
  Voglio sapere la somma di due numeri

  Scenario: la somma di due numeri
    Dato che ho inserito 5
    E che ho inserito 7
    Quando premo somma
    Allora il risultato deve essere 12
