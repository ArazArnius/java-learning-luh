## 🧪 **Prog2 Klausur – Überarbeitete Aufgabenstellung (Deutsch)**

### **\[1] Programmieraufgabe**

Bearbeiten Sie die folgenden Teilaufgaben (a) bis (d). Die Aufgaben bauen aufeinander auf.

---

#### **(a) Interface-Definition**

Definieren Sie ein Interface mit dem Namen `Grade`, das:

* `Comparable<Grade>` erweitert.
* Die Methode `double meanGrade()` deklariert.
* Die `toString()`-Methode überschreibt und folgenden String zurückgibt:

```java
"Mean Grade: " + meanGrade()
```

---

#### **(b) Klassen-Implementierung**

Implementieren Sie eine Klasse `Student`, die:

* Das Interface `Grade` implementiert.
* Zwei ganzzahlige Attribute `mathGrade` und `csGrade` besitzt.
* Die Methode `meanGrade()` als Durchschnitt dieser beiden Noten implementiert.
* Die `toString()`-Methode wie in Teil (a) gefordert überschreibt.

---

#### **(c) Generische Methode: Runs erkennen**

Schreiben Sie eine statische, generische Methode:

```java
public static <T extends Comparable<T>> ArrayList<ArrayList<T>> getRuns(ArrayList<T> list)
```

* Diese Methode zerlegt die gegebene Liste in *Runs*, das heißt in maximal lange Teilfolgen, die entweder streng **aufsteigend** oder **streng absteigend** sind.
* Die Methode gibt eine Liste dieser Teilfolgen zurück.

---

#### **(d) Anwendung schreiben**

Schreiben Sie eine Applikation, die:

* Eine Liste zufälliger `Student`-Objekte erzeugt.
* Die Methode `getRuns` aus Teil (c) auf diese Liste anwendet.
* Die erkannten Runs ausgibt.

---

## 📘 **Translated Version (English)**

### **\[1] Programming Exam Task**

Complete the following sub-tasks (a) to (d). The tasks build on one another.

---

#### **(a) Interface Definition**

Define an interface named `Grade` that:

* Extends `Comparable<Grade>`.
* Declares the method `double meanGrade()`.
* Overrides the `toString()` method to return:

```java
"Mean Grade: " + meanGrade()
```

---

#### **(b) Class Implementation**

Implement a class `Student` that:

* Implements the `Grade` interface.
* Has two integer fields: `mathGrade` and `csGrade`.
* Implements `meanGrade()` as the average of the two grades.
* Overrides `toString()` as described in part (a).

---

#### **(c) Generic Method: Detect Runs**

Write a static, generic method:

```java
public static <T extends Comparable<T>> ArrayList<ArrayList<T>> getRuns(ArrayList<T> list)
```

* The method breaks the list into *runs*, i.e., maximal-length sublists that are either strictly **increasing** or strictly **decreasing**.
* It returns a list of these runs.

---

#### **(d) Write an Application**

Create an application that:

* Generates a list of random `Student` objects.
* Applies the `getRuns` method from (c) to this list.
* Outputs the detected runs.
