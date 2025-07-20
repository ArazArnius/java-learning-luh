package CarColor;
import java.awt.Color;

public class Car {
    private int vmax;

    public Car(int vmax) {
        this.vmax = vmax;
    }

    @Override
    public String toString() {
        return "Car with " + vmax + "km/h";
    }

    public static void main(String[] args) {
        Car x6 = new Car(280);
        System.out.println(x6);

        Car x3 = new Car(200) {
            private Color color = Color.WHITE;

            @Override 
            public String toString() {
                return "A " + color + " " + super.toString();
            }
        };

        System.out.println(x3);
    }
}