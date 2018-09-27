1. Lombok
- Dodaj w `pom.xml` zależność do projektu lombok (https://projectlombok.org/):
```xml
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.16.22</version>
	<scope>provided</scope>
</dependency>
```
- Zainstaluj plugin lombok w IntelliJ: `File -> Settings -> Plugins -> Browse repositories... -> Lombok Plugin`
- W klasie `Creature` usuń wszystkie gettery i zastąp je anotacją na klasie `@Getter`.
- W zależności od upodobań, możesz od teraz stosować anotacje udostępniane przez lombok: @Data, @Value, @Getter itd. 
lub pisać własne implementacje getterów, setterów itd.

2. Obsługa błędów w serwisach REST-owych
- Zmodyfikuj jedną z metod REST-owych w taki sposób, aby w przypadku błędu rzucała wyjątek nowego typu, np. `NoTournamentDefinedException`.
- Stwórz nową klasę `ArenaApiError`, która będzie służyła do zwracania informacji o błędzie.
- Stwórz nową klasę `RestExceptionHandler` do obsługi wyjątków, która będzie miała za zadanie tłumaczyć wyjątki rzucone z kontrolera na obiekty klasy `ArenaApiError`. Przykłądowa implementacja:
```java
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        ArenaApiError arenaApiError = new ArenaApiError(HttpStatus.BAD_REQUEST, error, ex.getMessage());
        return new ResponseEntity<>(arenaApiError, arenaApiError.getStatus());
    }

    @ExceptionHandler(NoSuchTournamentException.class)
    protected ResponseEntity<Object> handleNoSuchTournamentException(
            NoSuchTournamentException ex) {
        ArenaApiError arenaApiError = new ArenaApiError(HttpStatus.NOT_FOUND, "No such tournament: " + ex.getId(), ex.getMessage());
        return new ResponseEntity<>(arenaApiError, arenaApiError.getStatus());
    }
}
```


3. Instalacja i konfiguracja połączenia z MySQL
- Pobierz i zainstaluj MySQL: https://dev.mysql.com/downloads/windows/installer/8.0.html

### Do oglądania:
- https://projectlombok.org/ - 3-minutowy film z wprowadzeniem do lomboka

### Do czytania:
- http://jnb.ociweb.com/jnb/jnbJan2010.html - jak używać lomboka
- https://www.toptal.com/java/spring-boot-rest-api-error-handling - obługa błędów w serwisach REST-owych
- https://spring.io/guides/gs/accessing-data-mysql/ - jak się dostać do danych w bazie MySQL