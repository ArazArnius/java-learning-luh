package task1.gates;

public class AndGate extends Gate {
    public AndGate() {
        super("AND");
    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        return a && b;
    }
}