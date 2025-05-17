## Task 1: Treasure Hunt

In this task, you will implement a **finite deterministic automaton**.
Finite automata consist of a finite set of **states**. Depending on the current state and an **input** (later called "action"), the automaton either transitions to another state or remains in the same one.

**Deterministic** means that for every input in a given state, there is **exactly one unique next state**.

Finite automata have:

* a **start state**
* and optionally one or more **goal (final) states**

The goal is to implement the automaton shown in **Figure 1**.
States are represented by **islands**.
**Arrows** represent **transitions**.
In each state, the inputs **A** and **B** are possible.
Arrows that are not shown represent transitions that lead **back to the same state**.

Create a suitable **package structure** on your own.
Write **JavaDoc comments** for all classes, methods, and member variables you create or modify.
Follow the JavaDoc conventions used so far.

---

### a) Enum Type `Action`

Implement the enum type `Action`, which can have the values `"A"` and `"B"`.
Also implement the method:

```java
public char str()
```

which returns a unique character representation of the value.

---

### b) Interface `State`

Create the interface `State`, which defines the following methods:

```java
public State transition(Action action);
public String str();
public String info();
```

* `transition`: performs the state transition based on the current state and the given action. It returns the **next state**.
* `info()`: returns a **description** of the current state and the possible transitions (e.g., “Action A → Shipwreck Bay; Action B → Musket Hill”).
* `str()`: returns just the **name** of the state.

---

### c) Concrete State Classes

For each state shown in **Figure 1**, create a separate class with the corresponding state/island name, implementing the `State` interface from part (b).

---

### d) Class `StateMachine`

Implement the class `StateMachine`, which represents the **entire automaton**.
It should store:

* the **current state** (as an attribute)
* a boolean indicating whether the **goal state** has been reached.

The **start state** is `Pirates’ Island`.
The **goal state** is `Treasure Island`.

Add a `main` method to this class that provides a **command-line interface (CLI)**.
The CLI should repeatedly ask the user to choose between actions `"A"` and `"B"`, until the goal state is reached.

After each state transition, print the `info()` output of the current state.

Once the goal state is reached, output the **entire path** taken from the start to the goal.
