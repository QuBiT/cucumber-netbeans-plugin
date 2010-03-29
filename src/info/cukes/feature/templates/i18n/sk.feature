# language: sk
Požiadavka: Sčítavanie
Aby som sa vyhol hlúpym chybám
Ako matematický idiot
Chcem vedieť ako sa sčítavajú dve čísla

  Náčrt Scenáru: Sčítanie dvoch čísel
    Pokiaľ Zadám číslo <vstup_1> do kalkulačky
    A Zadám číslo <vstup_2> do kalkulačky
    Keď Stlačím tlačidlo <tlačidlo>
    Tak Výsledok by mal byť <výstup>

  Príklady:
    | vstup_1 | vstup_2 | tlačidlo | výstup |
    | 20 | 30 | add | 50 |
    | 2 | 5 | add | 7 |
    | 0 | 40 | add | 40 |

# language: sk
Požiadavka: Delenie
Aby som sa vyhol hlúpym chybám
Pokladníci musia vedieť vypočítať podiel

  Scenár: Prirodzené čísla
    Pokiaľ Zadám číslo 3 do kalkulačky
    A Zadám číslo 2 do kalkulačky
    Keď Stlačím tlačidlo divide
    Tak Výsledok by mal byť 1.5