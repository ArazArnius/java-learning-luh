package treasurehunt.states;
import treasurehunt.actions.Action;

/**
 * Represents the state Treasure Island in the automaton.
 */
public class TreasureIsland implements State {
    /**
     * Performs the state transition based on the current state and the given action.
     *
     * @param action the action taken
     * @return the next state after transition
     */
    @Override
    public State transition(Action action) {
        // no actions can be done in Treasure Island
        return this;
    }

    /**
     * Returns just the name of the state.
     *
     * @return the state name
     */
    @Override
    public String str() {
        return "Treasure Island";
    }

    /**
     * Returns a description of the state and possible transitions.
     *
     * @return information about the state
     */
    @Override
    public String info() {
        return str() + 
            "\nAction A -> " + transition(Action.A).str() +
            "; Action B -> " + transition(Action.B).str();
    }

    /**
     * Test method for TreasureIsland state.
     */
    public static void main(String[] args) {
        TreasureIsland obj = new TreasureIsland();
        System.out.println("Current state: " + obj.str());
        System.out.println("If action A: " + obj.transition(Action.A).str());
        System.out.println("If action B: " + obj.transition(Action.B).str());
        System.out.println("All possible actions from " + obj.info());
    }
}