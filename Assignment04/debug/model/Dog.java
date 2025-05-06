package debug.model;
import debug.Animal; // was not imported

public class Dog extends Animal{
    
  public Dog(String name) {
    super(name);
  }


  // @Override
  // public String getName() {
  //   return super.getName(); // added getName() instead of trying to access the field directly
  // }

  @Override
  public int getArms() {
    return 4;
  }

  @Override
  public int getLegs() {
    return 4;
  }

  @Override
  public String toString() {
    return String.format("%s is a dog with %d legs and %d arms.", this.getName(), this.getArms(), this.getLegs());
  }
}