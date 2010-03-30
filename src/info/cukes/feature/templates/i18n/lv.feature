# language: lv
Funkcionalitāte: Saskaitīšana
Lai izvairītos no muļķīgām kļūdām
Kā matemātikas idiots
Es vēlos uzzināt divu skaitļu summu

  Scenārijs pēc parauga: Saskaitīt divus skaitļus
Kad esmu ievadījis kalkulatorā <skaitlis_1>
    Un esmu ievadījis kalkulatorā <skaitlis_2>
    Ja nospiežu pogu <poga>
    Tad rezultātam uz ekrāna ir jābūt <rezultāts>

  Paraugs:
    | skaitlis_1 | skaitlis_2 | poga | rezultāts |
    | 20 | 30 | add | 50 |
    | 2 | 5 | add | 7 |
    | 0 | 40 | add | 40 |

# language: lv
Funkcionalitāte: Dalīšana
Lai izvairītos no muļķīgām kļūdām
Kasieriem ir jāprot aprēķināt daļas

  Scenārijs: Veseli skaitļi
Kad esmu ievadījis kalkulatorā 3
    Un esmu ievadījis kalkulatorā 2
    Ja nospiežu pogu divide
    Tad rezultātam uz ekrāna ir jābūt 1.5
 