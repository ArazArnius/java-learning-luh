package task1.gates;

public class XorGate extends Gate {
    private AndGate and;
    private OrGate or;
    private NotGate not;

    public XorGate() {
        super("XOR");
        this.and = new AndGate();
        this.or = new OrGate();
        this.not = new NotGate();
        // System.out.println("\n\nXorGate initialized: not = " + not);
    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        // a XOR b := (!a & b) | (a & !b)
        boolean left = and.evaluate(not.evaluate(a, a), b);
        boolean right = and.evaluate(a, not.evaluate(b, b));

        return or.evaluate(left, right);
    }
}