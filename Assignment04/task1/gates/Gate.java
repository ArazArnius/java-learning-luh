package task1.gates;

public class Gate {
    protected String symbol;

    public Gate(String symbol) {
        this.symbol = symbol;
    }

    public boolean evaluate(boolean a, boolean b) {
        return false;
    }

    public void table() {
        System.out.println("A | B | Y = A " + symbol + " B");
        
        for (boolean a : new boolean[] {false, true}) {
            for (boolean b: new boolean[] {false, true}) {
                System.out.println(a + " | " + b + " | " + evaluate(a, b));
            }
        }
    }
}