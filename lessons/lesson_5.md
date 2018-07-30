## Lekcja 5

1. Dodaj do zależności projektu (plik pom.xml):
    ```xml
    <dependency>
       <groupId>org.powermock</groupId>
       <artifactId>powermock-module-junit4</artifactId>
       <version>2.0.0-beta.5</version>
       <scope>test</scope>
    </dependency>
    <dependency>
       <groupId>org.powermock</groupId>
       <artifactId>powermock-api-mockito2</artifactId>
       <version>2.0.0-beta.5</version>
       <scope>test</scope>
    </dependency>
    <dependency>
       <groupId>org.mockito</groupId>
       <artifactId>mockito-core</artifactId>
       <version>2.8.47</version>
       <type>pom</type>
    </dependency>
   ```
   
2. Napisz test, który zweryfikuje poprawność działania metody `Creature.dodge`.

3. Zamodeluj w aplikacji pancerz, w taki sposób, aby możliwe było zdefiniowanie 
następujących typów pancerza:    
\- hełm - chroni głowę  
\- zbroja - chroni tułów  
\- rękawice - chronią ręce  
\- nagolenniki - chronią nogi  
\- tarcza - chroni wszystko  
Każdy typ pancerza powinien też mieć określoną minimalną i maksymalną ochronę:  
\- hełm: 0-2  
\- zbroja: 0-4  
\- rękawice: 0-3  
\- nagolenniki: 0-2  
\- tarcza - 0-1
  
4. Zmodyfikuj klasę `Creature` w taki sposób, aby każda istota mogła mieć
dowolną ilość pancerza, przy czym nie może mieć dwóch sztuk tego samego.

5. Zmodyfikuj metodę generującą losową postać w taki sposób, aby najpierw
generowana była liczba sztuk pancerza, a następnie losowane były kolejne sztuki
pancerza.

6. Zmodyfikuj metodę `dodge` w taki sposób, aby przy wyliczaniu otrzymanych 
obrażeń była brana pod uwagę ochrona, którą daje pancerz.