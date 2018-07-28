## Lekcja 2

1. Stwórz enum o nazwie `CreatureType` i dodaj do niego typy wszystkich
postaci, które do tej pory zdefiniowaliśmy: HUMAN, ELF itd.  
Tutaj możesz poczytać o klasach typu enum:
https://javastart.pl/baza-wiedzy/darmowy-kurs-java/zaawansowane-programowanie/enum

2. Zmodyfikuj typ zmiennej instancyjnej `creatureType` w klasie `Creature` 
ze `String` na `CreatureType`.

3. Zmodyfikuj konstruktor klasy `Creature`, tak aby uwzględniał zmianę typu
`creatureType`.

4. Usuń parametr `creatureType` ze wszystkich konstuktorów klas dziedziczących 
po `CreatureType`. Każda klasa przy wywoływaniu konstruktora nadrzędnego
powinna przekazać odpowiednią wartość parametru `creatureType`.

5. Popraw wywołanie konstruktora w klasie `ArenaApplication` i uruchom
aplikację - powinna zachowywać się bez zmian, tj. wypisać parametry stworzonej
postaci.
