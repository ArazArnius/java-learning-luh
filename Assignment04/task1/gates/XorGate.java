package task1.gates;

public class XorGate extends Gate {
    private AndGate and;
    private OrGate or;
    private NotGate not;

    public XorGate() {
        super("XOR");
        and = new AndGate();
        or = new OrGate();
        not = new NotGate();
    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        // a XOR b := (!a & b) | (a & !b)
        boolean left = and.evaluate(not.evaluate(a, a), b);
        boolean right = and.evaluate(a, not.evaluate(b, b));

        return or.evaluate(left, right);
    }
}