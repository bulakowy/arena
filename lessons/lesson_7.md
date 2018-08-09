## Lekcja 7

1. Rozszerz klasę `Creature` o zmienną instancyjną `name` typu `String`. Dostosuj implementację
klas zależnych do tej zmiany.

2. W klasie `FightService` napisz nową metodę, która przyjmie kolekcję postaci, wygeneruje listę
unikalnych par (wykorzystaj metodę napisaną w lekcji 6) i przeprowadzi walkę dla każdej pary.
Za każdą wygraną walkę postać otrzymuje 1 pkt. Na koniec wszystkich walk, powinna istnieć możliwość
uzyskania informacji, ile punktów zdobyła każda z postaci i jakimi rezultatami zakończyły się wszystkie 
pojedynki.

3. Zmodyfikuj powyższą metodę w taki sposób, aby walki przeprowadzane były równolegle (tj. w osobnych wątkach).