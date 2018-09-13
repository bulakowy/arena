## Lekcja 8

1. Dodaj do aplikacji mozliwosc przeprowadzenia turnieju dla zgloszonych postaci. W tym celu nalezy zaimplementowac 
dwie nowe funkcjonalnosci:  
\- dodawanie zawodnika do turnieju - parametrami wyjsciowymi metody powinny byc:
typ postaci, imie postaci, sila, zrecznosc, obrona, wytrzymalosc, liczba punktow zycia i nazwa typu pancerza  
\- przeprowadzenie turnieju - walczy kazdy z kazdym

2. Przywroc w klasie `ArenaApplication` annotacje @SpringBootApplication i metode `main`:
    ```java
    public static void main(String[] args) {
        SpringApplication.run(ArenaApplication.class, args);
    }
    ```

3. Stwórz nową klasę `FightController`, ktora zaimplementuje nastepujace metody restowe:  
    \- stworzenie nowego turnieju (POST), turniej jest opisywany dwoma parametrami: liczba uczestników
    i liczba punktów do rozdysponowania miedzy umiejetnosci (suma wszystkich umiejetnosci powinna byc = tej liczbie).  
    Oczekiwany format requestu:
    ```json
        {
          "capacity": 10,
          "points": 30
        }
    ```  
    \- pobranie informacji o turnieju (GET) - zwraca informacje ile jest miejsc w turnieju i ile z nich jest juz zajetych    
    \- pobranie listy zawodnikow zgloszonych do turnieju (GET) - zwraca liste zgloszonych zawodnikow razem z parametrami  
    \- pobranie liczby punktow do rozdysponowania miedzy poszczegolne umiejetnosci (GET) - suma wszystkich umiejetnosci zglaszanego zawodnika powinna byc rowna tej wartosci   
    \- zglaszanie zawodnika do turnieju (POST) - zgloszenie powinno byc w postaci jsona o nastepujacym formacie:
    ```json
    {
      "creatureType": "ELF",
      "name": "Sample name",
      "strength": 10,
      "dexterity": 10,
      "defence": 10,
      "endurance": 10,
      "lifePoints": 10,
      "protectionItem": "HELM"
    }
    ```
    \- przeprowadzenie turnieju (POST)  
    \- pobranie wynikow turnieju (GET)

### Do czytania:
- https://spring.io/guides/gs/rest-service/