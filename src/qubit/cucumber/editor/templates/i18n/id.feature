# language: id
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/id/features/addition.feature
# Updated: Tue May 25 15:52:00 +0200 2010
Fitur: Addition
  Untuk menghindari kesalahan konyol 
  Sebagai orang yang gak bisa matematika
  Aku ingin diberi tahu jumlah dua bilangan 

  Skenario konsep: Menjumlahkan dua bilangan
    Dengan aku sudah masukkan <input_1> ke kalkulator
    Dan aku sudah masukkan <input_2> ke kalkulator
    Ketika aku tekan <button>
    Maka hasilnya harus <output> di layar

  Contoh:
    | input_1 | input_2 | button | output |
    | 20      | 30      | add    | 50     |
    | 2       | 5       | add    | 7      |
    | 0       | 40      | add    | 40     |
