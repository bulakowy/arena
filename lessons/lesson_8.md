## Lekcja 8

1. Dodaj do aplikacji mozliwosc przeprowadzenia turnieju dla zgloszonych postaci. W tym celu nalezy zaimplementowac 
dwie nowe funkcjonalnosci:  
-- dodawanie zawodnika do turnieju - parametrami wyjsciowymi metody powinny byc:
typ postaci, imie postaci, sila, zrecznosc, obrona, wytrzymalosc, liczba punktow zycia i nazwa typu pancerza
-- przeprowadzenie turnieju - walczy kazdy z kazdym

2. Przywroc w klasie `ArenaApplication` annotacje @SpringBootApplication i metode `main`:
```java
    public static void main(String[] args) {
        SpringApplication.run(ArenaApplication.class, args);
    }
```

3. Stwórz nową klasę `FightController`, ktora zaimplementuje 3 metody restowe:  
-- zglaszanie zawodnika do turnieju (POST)  
-- przeprowadzenie walki (POST)
-- pobranie wyniku turnieju (GET)
   
### Do czytania:
- https://spring.io/guides/gs/rest-service/