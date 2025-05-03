package task1.gates;

public class HalfAdder {
    private Gate[] rsrc = new Gate[2]; // why must I initialize it here?

    public HalfAdder(){
        rsrc[0] = new XorGate();
        rsrc[1] = new AndGate();
    }

    public boolean[] add(boolean a, boolean b) {
        boolean[] result = new boolean[2];

        // the sum is in [0] and carry in [1]
        result[0] = rsrc[0].evaluate(a, b);
        result[1] = rsrc[1].evaluate(a, b);

        return result;
    }

    public void info() {
        for (Gate i : rsrc) {
            i.table();
        }
    }
}