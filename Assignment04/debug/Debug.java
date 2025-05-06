package debug;

import debug.model.*;

public class Debug {
  public static void main(String[] args) {
    Animal[] animals = new Animal[3];
    animals[0] = new Animal("Kangaroo Bob", 2, 2);
    animals[1] = new Dog("Barks");
    animals[2] = new Monkey("King Kong");
    for (int i = 0; i < animals.length; ++i) {
      System.out.println(animals[i]);
    }
  }
}

/*
.\debug\model\Dog.java:3: error: cannot find symbol
public class Dog extends Animal{
                         ^
  symbol: class Animal

.\debug\model\Dog.java:7: error: constructor Animal in class Animal cannot be applied to given types;
    super(name);
    ^
  required: String
  found:    String
  reason: Animal(String) is not public in Animal; cannot be accessed from outside package

.\debug\model\Dog.java:13: error: name_ has private access in Animal
    return super.name_;
*/