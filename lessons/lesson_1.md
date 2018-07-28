## Lekcja 1

1. Zainstaluj Java JDK 8.

2. Zainstaluj IntelliJ IDEA.

3. Po zainstalowaniu stwórz nowy projekt za pomoca Spring Initializr
(https://start.spring.io/) bez żadnych dodatkowych bibliotek. Wypełnij pola 
wartościami:  
\- group: com.example  
\- artifact: arena

4. Otwórz klasę `ArenaApplication` (`Ctrl + N`) i usuń adnotację 
`@SpringBootApplication` oraz całe ciało metody `main`. Usuń klasę 
`ArenaApplicationTests`.

5. Stwórz nową abstrakcyjną klasę `Creature` (w pakiecie `com.example.arena`).
W klasie `Creature` zdefiniuj zmienną `creatureType` typu `String` oraz 
następujące prywatne zmienne instancyjne typu `Integer`:  
\- `strength`  
\- `dexterity`  
\- `defence`  
\- `endurance`  
\- `lifePoints`  

    Do każdej zmiennej stwórz getter zgodnie z konwencją:  
    ```java
    Integer getStrength() {   
        return strength;
    }
    ```  

6. Stwórz publiczny konstruktor, który przyjmuje tyle parametrów, ile jest 
zmiennych instancyjnych i inicjuje wszystkie zmienne przekazanymi wartościami.

7. Dodaj implementację metody `toString()`, która powinna wypisać wszystkie 
parametry postaci.

8. Stwórz klasy dziedziczące po klasie `Creature`:  
\- `Elf` 
\- `Human` 
\- `Halfing`  
\- `Troll`  
\- `Orc`  
\- `Dwarf`

9. W każdej z klas zaimplementuj konstruktor, który przyjmie 6 parametrów 
i wywoła konstruktor klasy nadrzędnej. Konstruktor nadrzędny wywołuje się za 
pomocą `super()`. 

10. W klasie `ArenaApplication` w funkcji `main` stwórz instancję jednej 
z klas (np. Human) i wywołaj na niej metodę `toString()`. Wynik wypisz
na ekran.
Do wypisywania służy:
`System.out.println()`
Po uruchomieniu aplikacji (`Shift + F10`) powinieneś zobaczyć na ekranie
wszystkie parametry postaci.
