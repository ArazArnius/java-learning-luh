### 🇩🇪 **Aufgabe 2 – Textanalyse nach Wortlänge**

**Aufgabenstellung:**
Schreiben Sie ein Programm, das einen vom Benutzer eingegebenen Text analysiert.
Analysieren Sie, welche Wörter mit welcher Wortlänge im Text enthalten sind.
Geben Sie für jede vorkommende Wortlänge **alle Wörter mit gleicher Länge** in einer Zeile aus.
Die Ausgabe soll nach **aufsteigender Wortlänge** sortiert sein.
Die Wortlänge (z. B. 3, 4, 5, …) soll vor den Wörtern in der Ausgabe stehen.

Die Texteingabe erfolgt zur Laufzeit über die Konsole.
Nach jeder Analyse soll der Benutzer gefragt werden, ob er einen weiteren Text analysieren möchte. Bei Eingabe von „j“ wird eine neue Eingabe abgefragt, bei „n“ wird das Programm beendet.

**Hinweise:**

* Benutzen Sie `String.split(" +")` oder ähnliche Methoden zur Zerlegung in Wörter.
* Zur Gruppierung nach Wortlänge können Sie z. B. `Map<Integer, List<String>>` oder `TreeMap` verwenden.
* Die Klassen `Scanner`, `Map`, `List`, `TreeMap`, `ArrayList` etc. befinden sich in `java.util`.

**Beispielausgabe:**

```
Aufgabe 2 von Maxi Musterperson, Start:
Wie lautet Ihre Eingabe?
> Dieser Text dient als Beispieleingabe für die obige Aufgabe
Ausgabe:
3: als für die
4: Text
5: dient obige
6: Dieser
7: Aufgabe
15: Beispieleingabe
Wollen Sie noch einen Text analysieren (j/n)?
> n
Aufgabe 2 Ende.
```

---

### 🇬🇧 **Task 2 – Text Analysis by Word Length**

**Instructions:**
Write a program that analyzes a text entered by the user.
The program should detect which words of which lengths appear in the text.
For each word length, output all words of that length in a line, preceded by the length itself (e.g., `4: text word`).
The output should be sorted by **increasing word length**.

The user should enter the text during program runtime via the console.
After analyzing the input, the program should ask the user whether they want to analyze another text. If the user enters “y”, the process repeats. If “n”, the program exits.

**Hints:**

* Use `String.split(" +")` or similar to split the text into words.
* You can use `Map<Integer, List<String>>` or `TreeMap` to group words by length.
* Relevant classes include `Scanner`, `Map`, `List`, `TreeMap`, `ArrayList` etc., found in `java.util`.

**Sample Output:**

```
Task 2 by Maxi Musterperson, Start:
What is your input?
> This text serves as example input for the task above
Output:
2: as
3: for the
4: text task
5: serves input
6: above
7: example
Do you want to analyze another text (y/n)?
> n
Task 2 end.
```
