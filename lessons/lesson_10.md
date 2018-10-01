1. Konfiguracja schematu bazy danych
- Uruchom klienta mysql, stwórz w bazie danych nowy schemat i użytkownika z prawami do schematu:
```
mysql> \connect root@localhost
mysql> \sql
mysql> create database arena;
mysql> create user 'arena'@'localhost' identified by 'arena';
mysql> grant all on arena.* to 'arena'@'localhost';
```
- Skonfiguruj połączenie do schematu w wybranych przez siebie kliencie SQL, np. MySQL Workbench.

2. Konfiguracja połączenia z bazą danych w aplikacji
- W pliku pom.xml dodaj następujące zależności:
```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
</dependency>
```
- W pliku application.properties skonfiguruj połączenie z bazą danych:
```properties
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/arena
spring.datasource.username=arena
spring.datasource.password=arena
```
- Uruchom aplikację. Jeśli wszystko zostało poprawnie skonfigurowane, aplikacja powinna wystartować bez błędów.

3. Zapisywanie / odczytywanie obiektów z bazy danych.
- Stwórz nową klasę reprezentującą turniej w bazie danych `Tournament.java` (lub dodaj anotacje do istniejącej klasy,
jeśli już posiadasz obiekt przechowujący informację o turnieju):
```java
@Entity
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer capacity;
    private Integer points;

}
```
- Stwórz nową klasę odpowiedzialną za dostęp do tabeli `tournamet`:
```java
@Repository
public interface TournamentRepository extends CrudRepository<TournamentDto, Integer> {
}
```

