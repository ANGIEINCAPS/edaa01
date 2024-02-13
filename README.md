# edaa01
## lab1


## lab2
### F1
- **NullPointerException** in `Scheduler.machineWithLeastToDo` at lines 19 and 34
- **ArrayIndexOutOfBoundsException** `Scheduler.printSchedule` at line 49

### F2 
Lambdametoden beskriver hur `tempJobList` ska sorteras - i detta fall ska tiderna sorteras i fallande ordning. Det blev logikfel när `j1.getTime` subtraherades med `j2.getTime()`.

I `assignJob()` blev `scheduledTime` tiden till det senaste jobbet istället för den totala tiden för samtliga jobb tillagda till maskinen.

### F3
Man kan använda sig av den abstrakta datatypen **PriorityQueue** som prioriterar olika objekt beroende på värde. Ergo hade man med hjälp av denna datatyp kunnat hämta maskinen med minst schemalagd tid.

### F4
a. 20 rader skrivs ut. Ja, en for-each loop itererar från the första elementet till det sista.

b. 10 rader för 10 unika nummer. Nej, man kan inte garantera att ett hashset skriver ut i den ordning man insatte i.

c. `Map<String, Integer> m = new HashMap<String, Integer>();`

d. Man använder sig av `containsKey()` för att undersöka om en nyckel finns i en given map.
