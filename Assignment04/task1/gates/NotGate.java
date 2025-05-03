package task1.gates;

public class NotGate extends Gate {
    public NotGate() {
        super("NOT");
    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        return !a;
    }
}