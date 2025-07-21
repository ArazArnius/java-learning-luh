### 🇩🇪 **Aufgabe 1 – Box sortieren nach Gewicht**

**Aufgabenstellung:**
Implementieren Sie eine Klasse `Box` mit den Attributen `String content` und `Integer weight`.
Die Klasse `Box` soll das Interface `Comparable<Box>` implementieren, wobei nach dem Gewicht (`weight`) verglichen wird.
Überschreiben Sie außerdem die Methode `toString()`, sodass Inhalt und Gewicht ausgegeben werden – siehe Beispiel.

Erzeugen Sie im `main()`-Teil fünf `Box`-Objekte mit beliebigem Inhalt (z. B. „Content Type 0“ bis „Content Type 4“) und zufälligem Gewicht zwischen 1 und 20 (Zufallszahlen mit `java.util.Random`).
Speichern Sie die Objekte in einer `List<Box>` (z. B. als `ArrayList`).
Geben Sie zuerst die unsortierte Liste aus. Dann sortieren Sie die Liste mit `Collections.sort()` und geben anschließend die sortierte Liste aus.

**Hinweise:**

* Verwenden Sie `java.util.List`, `ArrayList`, `Collections` und `Random`.
* Die Ausgabe soll der untenstehenden Beispielausgabe ähneln.

**Beispielausgabe:**

```
Aufgabe 1 von Maxi Musterperson, Start:
Unsortierte Liste:
Box mit Content Type 0 wiegt 8 kg.
Box mit Content Type 1 wiegt 18 kg.
Box mit Content Type 2 wiegt 9 kg.
Box mit Content Type 3 wiegt 4 kg.
Box mit Content Type 4 wiegt 19 kg.
Sortierte Liste:
Box mit Content Type 3 wiegt 4 kg.
Box mit Content Type 0 wiegt 8 kg.
Box mit Content Type 2 wiegt 9 kg.
Box mit Content Type 1 wiegt 18 kg.
Box mit Content Type 4 wiegt 19 kg.
Aufgabe 1 Ende.
```

---

### 🇬🇧 **Task 1 – Sort Boxes by Weight**

**Instructions:**
Implement a class `Box` with the attributes `String content` and `Integer weight`.
The class `Box` should implement the interface `Comparable<Box>`, comparing by `weight`.
Override the `toString()` method so that it outputs the content and weight – see the example below.

In your `main()` method, create five `Box` objects with content like “Content Type 0” to “Content Type 4” and random weight between 1 and 20 (using `java.util.Random`).
Store them in a `List<Box>` (for example, an `ArrayList`).
First print the unsorted list. Then use `Collections.sort()` to sort the list and print it again.

**Hints:**

* Use `java.util.List`, `ArrayList`, `Collections`, and `Random`.
* Your output should look similar to the sample below.

**Sample output:**

```
Task 1 by Maxi Musterperson, Start:
Unsorted list:
Box with Content Type 0 weighs 8 kg.
Box with Content Type 1 weighs 18 kg.
Box with Content Type 2 weighs 9 kg.
Box with Content Type 3 weighs 4 kg.
Box with Content Type 4 weighs 19 kg.
Sorted list:
Box with Content Type 3 weighs 4 kg.
Box with Content Type 0 weighs 8 kg.
Box with Content Type 2 weighs 9 kg.
Box with Content Type 1 weighs 18 kg.
Box with Content Type 4 weighs 19 kg.
Task 1 end.
```
