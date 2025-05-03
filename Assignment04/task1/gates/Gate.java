package task1.gates;

public class Gate {
    protected String symbol;

    public Gate(String symbol) {
        this.symbol = symbol;
    }

    public static int boolToInt(boolean a) {
        return (a ? 1 : 0);
    }

    public boolean evaluate(boolean a, boolean b) {
        return false;
    }

    public void table() {
        System.out.println("A | B | A " + symbol + " B");
        
        for (boolean a : new boolean[] {false, true}) {
            for (boolean b: new boolean[] {false, true}) {
                System.out.println(boolToInt(a) + " | " + boolToInt(b) + " |    " + boolToInt(evaluate(a, b)));
            }
        }

        System.out.println();
    }
}