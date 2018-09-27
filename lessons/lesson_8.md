## Lekcja 8

1. Dodaj do aplikacji możliwość przeprowadzenia turnieju dla zgłoszonych postaci. W tym celu należy zaimplementować:  
\- nową klasę reprezentującą turniej: klasa powinna przechowywać informacje o:  
\-- liczbie zawodników, którzy mogą wziąć udział w turnieju  
\-- sumie punktów umiejętności, którą musi posiadać każdy zgłoszony zawodnik  
\-- zgłoszonych zawodnikach - w formie wybranej kolekcji / mapy  
\- dodawanie zawodnika do turnieju - parametrami wejściowymi metody powinny być:
typ postaci, imię postaci, siła, zręczność, obrona, wytrzymałość, liczba punktów życia i nazwa typu pancerza  
\- przeprowadzenie turnieju - walczy każdy z każdym

2. Przywróć w klasie `ArenaApplication` annotację `@SpringBootApplication` i metode `main`:
    ```java
    public static void main(String[] args) {
        SpringApplication.run(ArenaApplication.class, args);
    }
    ```

3. Stwórz nową klasę `FightController`, która zaimplementuje następujace metody restowe:  
    \- stworzenie nowego turnieju (POST), turniej jest opisywany dwoma parametrami: liczba uczestników
    i liczba punktów do rozdysponowania między umiejetności (siła, zręczność, obrona, wytrzymałość i liczba punktów życia) 
	- suma wszystkich umiejętnosci powinna byc równa tej liczbie.  
    Oczekiwany format body requestu:
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