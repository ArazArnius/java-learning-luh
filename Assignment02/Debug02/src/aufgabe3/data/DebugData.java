package aufgabe3.data;

import java.lang.Math;

// This class is representing a cartesian coordinate in a 2d space with double coordinates.
public class DebugData { // class not defined public
    private double x;
    private double y;
    
    public DebugData(double x, double y) { // taking int and assigining them to double values
        this.x = x;
        this.y = y;
    }
    
    public double distance(DebugData other) {
        return Math.pow(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2), 0.5); // logical error distance is (x^2 + y^2)^0.5, and given only one argument to the Math.pow()
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.x;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public String str() {
        return String.format("(%g, %g)", this.x, this.y);
    }
}