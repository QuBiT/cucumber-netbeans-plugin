# language: lv
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/lv/features/addition.feature
# Updated: Tue May 25 15:52:08 +0200 2010
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
    | 20         | 30         | add  | 50        |
    | 2          | 5          | add  | 7         |
    | 0          | 40         | add  | 40        |
