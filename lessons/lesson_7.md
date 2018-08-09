## Lekcja 7

1. Rozszerz klasę `Creature` o zmienną instancyjną `name` typu `String`. Dostosuj implementację
klas zależnych do tej zmiany.  
UWAGA: Zapewnij, żeby każda postać miała inne imię.

2. W klasie `FightService` napisz nową metodę, która przyjmie kolekcję postaci, wygeneruje listę
unikalnych par (wykorzystaj metodę napisaną w lekcji 6) i przeprowadzi walkę dla każdej pary.
Za każdą wygraną walkę postać otrzymuje 1 pkt. Na koniec wszystkich walk, powinna istnieć możliwość
uzyskania informacji, ile punktów zdobyła każda z postaci i jakimi rezultatami zakończyły się wszystkie 
pojedynki.

3. Zmodyfikuj powyższą metodę w taki sposób, aby walki przeprowadzane były równolegle (tj. w osobnych wątkach).

### Do czytania:
- Immutable objects in Java: http://www.javapractices.com/topic/TopicAction.do?Id=29
- Defensive copying: http://www.javapractices.com/topic/TopicAction.do?Id=15
- Threads in Java: http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html
- ExecutorService: https://www.baeldung.com/java-executor-service-tutorial
 