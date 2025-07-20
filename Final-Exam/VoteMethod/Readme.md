**📌 Exam Question VoteMethod**

Implement a utility class and a main application as follows:

1. **Class `Util`**
   Implement a **static generic method**

   ```java
   public static <T> T vote(T a, T b, T c)
   ```

   * It receives three objects of the **same type `T`**.
   * It **returns the object that occurs most frequently** among the three.
   * If all are different, return the **first one (`a`)**.

2. **Class `Application`**

   * Contains the `main(String[] args)` method.
   * Calls the method `Util.vote()` with at least **two example inputs**:

     * `vote("Eimer", "Schaufel", "Eimer")`
     * `vote(2, 2, 2)`
   * Produces the following output format **exactly**:

   ```
   Aufgabe 1 von Max Mustermann, Start:
   Beim Aufruf von vote("Eimer", "Schaufel", "Eimer") ist das Ergebnis -> Eimer
   Beim Aufruf von vote(2, 2, 2) ist das Ergebnis -> 2
   Aufgabe 1, Ende.
   ```

🛈 You may use `.equals()` for comparison of objects.
