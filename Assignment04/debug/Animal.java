package debug;

public class Animal {
  private String name_;
  private int legs_;
  private int arms_;


  protected Animal(String name, int legs, int arms) {
    this.name_ = name;
    this.legs_ = legs;
    this.arms_ = arms;
  }

  protected Animal(String name) { // default access modifier: class itself and classes in same package (not subclasses)
    this(name, 0, 0);
  }


  public String getName() {
    return this.name_;
  }

  public int getArms() {
    return this.arms_;
  }

  public int getLegs() {
    return this.legs_;
  }

  @Override
  public String toString() {
    return String.format("%s is an animal with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}