## Lekcja 4

1. Stwórz nowy enum `BodyPart` z wartosciami HEAD, LEFT_ARM, RIGHT_ARM, TRUNK,
LEFT_LEG, RIGHT_LEG.

2. W każdej z części ciała zdefiniuj prawdopodobieństwo trafienia i premię
za trafienie w tę część ciała:  
\- HEAD - 5%, +3  
\- LEFT_ARM, RIGHT_ARM - 10%, +1   
\- TRUNK - 30%, 0  
\- LEFT_LEG, RIGHT_LEG - 5%, +2
  
3. W klasie `Creature` zdefiniuj nową metodę, która zwroci trafioną część ciała
zgodnie z powyższymi prawdopodobieństwami. Jeżeli żadna z części ciała nie
została trafiona, powinien zostać rzucony wyjatek.

4. Zmodyfikuj metodę `attack` w taki sposób, aby jej logika wyglądała
następująco:    
\- wylosuj trafioną część ciała    
\- jeśli udało się w coś trafić, wylicz potencjalne obrażenia jak do tej pory
i dodaj premię za trafioną część ciała  
\- jeśli nie udało się w nic trafić, spróbuj uderzyć ponownie - ponowne
uderzenie udaje się, jeśli dexterity > wylosowana liczba z przedziału 1-10  
\- zwróć wynik ataku (trafiona część ciała, potencjalne obrażenia, za którym 
razem się udało)  
\- wypisuj komunikaty informujące o tym co się dzieje

5. Zmodyfikuj metodę `fight` w klasie `FightService`, tak aby uwzględniała nowy 
interfejs metody `attack`.

6. Rozszerz metodę `fight` w klasie `FightService` w taki sposób, aby na koniec 
walki wyświetlała statystyki:  
\- ile razy w trakcie walki została trafiona każda część ciała  
\- jaka część ciała była trafiana najczęściej  
\- jaki był najsilniejszy cios i kto go zadał  
UWAGA: Zadanie moze być łatwiejsze do implementacji, jeśli zmienisz 
  interfejs metody `dodge`
 
