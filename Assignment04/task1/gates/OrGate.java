package task1.gates;

public class OrGate extends Gate {
    public OrGate(){
        super("OR");
    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        return a || b;
    }
}