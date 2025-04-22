package aufgabe3;
import aufgabe3.data.*;

class DebugMain {
    public static void main(String[] args) {
        DebugData a = new DebugData(3.4, 5.6); // DebugData not imported
        DebugData b = new DebugData(1.0, 1.0);
        // Result should be approx. 5.18
        System.out.println(String.format("The distance between %s and %s is %g",
            a.str(), b.str(), a.distance(b)));
    }
}

/*
.\aufgabe3\DebugMain.java:5: error: cannot find symbol
        DebugData a = new DebugData(3.4, 5.6);
        ^
    symbol:   class DebugData
    location: class DebugMain

.\aufgabe3\DebugMain.java:6: error: cannot find symbol
        DebugData a = new DebugData(3.4, 5.6); // DebugData not imported
        ^
    symbol:   class DebugData
    location: class DebugMain

.\aufgabe3\DebugMain.java:6: error: incompatible types: possible lossy conversion from double to int
        DebugData a = new DebugData(3.4, 5.6); // DebugData not imported

.\aufgabe3\data\DebugData.java:16: error: method pow in class Math cannot be applied to given types;
        return Math.pow(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
                    ^
    required: double,double
    found:    double
    reason: actual and formal argument lists differ in length

and the logical error distance mehtod

Error: Could not find or load main class .\aufgabe3\DebugMain
Caused by: java.lang.ClassNotFoundException: /\aufgabe3\DebugMain
fix:
// javac aufgabe3/*.java aufgabe3/data/*.java
// java aufgabe3.DebugMain
*/