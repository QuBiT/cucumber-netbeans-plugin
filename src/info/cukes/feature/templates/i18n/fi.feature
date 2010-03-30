# language: fi
Ominaisuus: Jakolasku
Välttyäkseen hölmöiltä virheiltä
Kassanhoitajan on voitava laskea osamäärä

  Tapaus: Kokonaislukujen jakolasku
    Oletetaan että olen syöttänyt laskimeen luvun 3
    Ja että olen syöttänyt laskimeen luvun 2
    Kun painan "jaa"
    Niin laskimen ruudulla pitäisi näkyä tulos 1.5# empty feature file

# language: fi
Ominaisuus: Yhteenlasku
Välttyäkseni hölmöiltä virheiltä
Koska olen laskutaidoton
Haluan että yhteenlaskut lasketaan puolestani

  Tapausaihio: Kahden luvun summa
    Oletetaan että olen syöttänyt laskimeen luvun <luku_1>
    Ja että olen syöttänyt laskimeen luvun <luku_2>
    Kun painan "<nappi>"
    Niin laskimen ruudulla pitäisi näkyä tulos <tulos>

  Tapaukset:
    | luku_1 | luku_2 | nappi | tulos |
    | 20 | 30 | summaa | 50 |
    | 2 | 5 | summaa | 7 |
    | 0 | 40 | summaa | 40 |