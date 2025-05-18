package treasurehunt.actions;

public enum Action {
    A('A'),
    B('B');

    final char action;

    Action(char action) {
        this.action = action;
    }

    public char str() {
        return action;
    }
}