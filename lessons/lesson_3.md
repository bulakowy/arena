## Lekcja 3

1. Stwórz nową klasę `CreatureFactory`.

2. W klasie `CreatureFactory` stwórz prywatną metodę, która zwróci losowy typ
postaci.  
Sygnatura metody: `CreatureType randomCreatureType()`

3. Stwórz kolejną metodę, która zwróci losową liczbę z zadanego przedziału
(obustronnie domkniętego).  
Sygnatura metody: `int random(int min, int max)`

4. Zaimplementuj metodę, która zwróci losową postać z losowymi wszystkimi 
parametrami. W implementacji wykorzystaj metody `randomCreatureType`
i `random`.  
Sygnatura metody: `Creature randomCreature()`

5. Wykorzystaj metody `randomCreature` i `random` do napisanie kolejnej,
która wygeneruje zadaną liczbę losowych postaci o losowych parametrach.  
Sygnatura metody: `List<Creature> randomCreatureList(int listSize)`

6. W klasie `ArenaApplication` w metodzie `main` wywołaj `randomCreatureList`
z wybraną przez siebie długością listy i wypisz na ekran wygenerowane postacie.

7. Stwórz nowy interfejs o nazwie `Fightable` i w tym interfejsie dodaj 3 metody:   
\- `int attack()`  
\- `void dodge(int potentialDamage)`  
\- `boolean isAlive()`

8. Zaimplementuj w klasie `Creature` interfejs `Fightable`:  
metoda `attack`:  
\- atak udaje się, jeśli dexterity atakującego > losowa liczba z przedziału
[1, 10]  
\- w przypadku udanego ataku, metoda zwraca potencjalne obrażenia = strength
\+ losowa liczba z przedziału [0, 3]  
\- w przypadku nieudanego ataku, metoda zwraca 0  
\- metoda powinna wypisać na ekran informacje, czy atak sie udał i jakie
są potencjalne obrazenia)  
metoda `dodge`:  
\- unik udaje się, jeśli defence > losowa liczba z przedziału [1, 10]  
\- jeśli unik się udał, metoda wypisuje na ekran tę informacje i kończy działanie  
\- jeśli unik się nie udał, metoda wylicza faktyczne obrażenia = potencjalne
obrażenia - endurance i jeśli wynik > 0 faktyczne obrażenia należy odjąć od
punktów życia; metoda wypisuje na ekran informację o faktycznych obrażeniach  
\- na koniec należy sprawdzić, czy liczba pozostałych po uniku punktów życia > 0;
jeśli nie, ofiara nie żyje i tę informację też wypisujemy na ekran  
metoda `isAlive`:  
\- zwraca `true`, jeśli liczba punktów życia > 0 
  
9. Stwórz nową klasę `FightService` z jedną publiczną metodą `fight`, która
jako parametry będzie przyjmować dwie postaci i nie będzie zwracać wyniku.  
Sygnatura metody: `void fight(Creature c1, Creature c2)`  

10. Zaimplementuj w metodzie `fight` logikę przeprowadzania walki zgodnie
z następującym schematem:    
Powtarzaj dopóki któraś z postaci nie zginie:  
c1.attack  
c2.dodge  
c2.attack (tylko jeśli c2 wciąż żyje)  
c1.dodge

11. W klasie `ArenaApplication` wygeneruj 2 losowe postaci i wywołaj dla nich
metodę `fight` z klasy `FightService`.  
