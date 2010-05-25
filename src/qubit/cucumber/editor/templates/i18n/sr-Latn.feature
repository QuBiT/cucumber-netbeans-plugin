# language: sr-Latn
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/sr-Latn/features/sabiranje.feature
# Updated: Tue May 25 15:52:20 +0200 2010
Funkcionalnost: Sabiranje
  Da bih izbegao smešne greske
  Kao matematička neznalica
  Želim da mogu da izračunam zbir dva broja

  Struktura scenarija: Dodaj dva broja
    Zadato Unesen <input_1> broj u kalkulator
    I Unesen <input_2> broj u kalkulator
    Kada pritisnem <button>
    Onda bi trebalo da bude <output> prikazano na ekranu

  Primeri:
    | input_1 | input_2 | button | output |
    | 20      | 30      | add    | 50     |
    | 25      | 45      | add    | 70     |		
    |  7      | 77      | add    | 84     |
    | 11      | 12      | add    | 23     |