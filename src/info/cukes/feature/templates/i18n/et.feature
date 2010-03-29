# language: et
Omadus: Jagamine
Rumalate vigade vältimiseks
Peavad kassapidajad saama arvutada murdudes

  Stsenaarium: Tavalised numbrid
    Eeldades et olen sisestanud kalkulaatorisse numbri 3
    Ja olen sisestanud kalkulaatorisse numbri 2
    Kui ma vajutan jaga
    Siis vastuseks peab ekraanil kuvatama 1.5

# language: et
Omadus: Liitmine
Selleks et vältida rumalaid vigu
Olles matemaatika-puupea
Tahan et mulle öeldaks kahe numbri summa

  Raamstsenaarium: Liida kaks numbrit
    Eeldades et olen sisestanud kalkulaatorisse numbri <input_1>
    Ja olen sisestanud kalkulaatorisse numbri <input_2>
    Kui ma vajutan <button>
    Siis vastuseks peab ekraanil kuvatama <output>

  Juhtumid:
    | input_1 | input_2 | button | output |
    | 20 | 30 | liida | 50 |
    | 2 | 5 | liida | 7 |
    | 0 | 40 | liida | 40 |