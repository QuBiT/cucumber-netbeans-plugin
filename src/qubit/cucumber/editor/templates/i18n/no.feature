# language: no
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/no/features/summering.feature
# Updated: Tue May 25 15:52:09 +0200 2010
Egenskap: Summering
  For å slippe å gjøre dumme feil
  Som en regnskapsfører
  Vil jeg kunne legge sammen

  Scenario: to tall
    Gitt at jeg har tastet inn 5
    Og at jeg har tastet inn 7
    Når jeg summerer
    Så skal resultatet være 12

  @iterasjon3
  Scenario: tre tall
    Gitt at jeg har tastet inn 5
    Og at jeg har tastet inn 7
    Og at jeg har tastet inn 1
    Når jeg summerer
    Så skal resultatet være 13
