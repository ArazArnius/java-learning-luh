### **Exam Question**

**(a)** Implement a class `Auto` with the following:

* a private `int vmax` field representing the maximum speed,
* a constructor to initialize `vmax`,
* a `toString()` method that returns a string representation of the object in the format:
  `"Auto with vmax = <value>"`.

**(b)** Write an application class with a `main` method that:

1. Creates an instance of `Auto` and prints it.
2. Creates a second instance of `Auto` using an **anonymous inner class**, which:

   * extends `Auto`,
   * adds a `color` field of type `java.awt.Color`,
   * overrides the `toString()` method to return
     `"Auto with vmax = <value>, color = <color>"`.
3. Prints the second (anonymous) `Auto` object.
