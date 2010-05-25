# language: eo
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/eo/features/adicio.feature
# Updated: Tue May 25 15:51:44 +0200 2010
Trajto: Adicio
  Por eviti stultajn erarojn
  Kiel stultulo in matematiko
  Mi volas ke mi estu ebla adicii du nombrojn

  Konturo de la scenaro: Adiciu du nombrojn
    Donitaĵo mi entajpas <nombro_1> en kalkulilo
    Kaj mi entajpas <nombro_2> en kalkulilo
    Se mi premas <butono>
    Do la rezulto devas esti <rezulto>

  Ekzemploj:
    | nombro_1 | nombro_2 | butono | rezulto |
    | 20       | 30       | add    | 50      |
    | 2        | 5        | add    | 7       |
    | 0        | 40       | add    | 40      |
