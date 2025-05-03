# Task 1: circuit simulation

in this task, we will step by step build a half adder that should add two bits
boolean values are to be understood as binary numbers:
true represents 1 and false represents 0

---

## a) create the class `Gate`

* implement the method
  `public boolean evaluate(boolean a, boolean b)`
  which always returns false
* implement the method
  `public void table()`
  which prints a truth table like in figure 1
* use two nested loops to go through all truth values
* calculate and print the result using evaluate()
* the class should have a string attribute symbol
  this stores the symbol of the operation
  and should also be used in the truth table output
  
* Figure 1) Truth table of XOR
  | A | B | Y = A ⊕ B |
  |---|---|-----------|
  | 0 | 0 |     0     |
  | 0 | 1 |     1     |
  | 1 | 0 |     1     |
  | 1 | 1 |     0     |

---

## b) create the class `NotGate`

* this class should extend (inherit from) Gate
* NotGate represents an inverter
* override the method
  public boolean evaluate(boolean a, boolean b)
  so that it returns the inverted value of a
* ignore the value of b
* also implement the classes AndGate and OrGate

  * both inherit from Gate
  * AndGate returns the logical AND of a and b
  * OrGate returns the logical OR of a and b

---

## c) create the class `XorGate`

* this class extends Gate and represents the xor gate
* first, think about how to build an xor gate using and, or, and not gates
* the truth table in figure 1 can help
* implement a constructor that stores the needed gates inside the class
* override the method
  `public boolean evaluate(boolean a, boolean b)`
  and implement the xor logic using the stored gates
* use the evaluate methods of those gates to do the calculation

---

## d) create the class `HalfAdder`

* this class does not extend Gate, but it uses them
* store the needed gates in a Gate[] array
* look up which gates you need for sum s and carry c
  → [https://en.wikipedia.org/wiki/Half\_adder](https://en.wikipedia.org/wiki/Half_adder)
* implement the method
  `public boolean[] add(boolean a, boolean b)`
  this should return an array of two values:

  * the first entry is the sum s
  * the second is the carry c
* also implement the method
  `void info()`
  this should print info about all stored gates including their truth tables

---

## e) write the main method

* inside the main method of the Main class, ask for user input from console

* the program should:

  1. ask for two boolean values a and b
  2. use the half adder to add them
  3. print the result to the console
  4. then exit

* example output:

  
  enter the first boolean value: true  
  enter the second boolean value: true  
  the sum is 0, the carry is 1  
  

* finally, call info() to print details about all gates used