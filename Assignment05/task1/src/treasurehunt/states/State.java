package states;
import actions.Action;

/**
 * Represents a state in the finite deterministic automaton.
 */
public interface State {
    /**
     * Performs the state transition based on the current state and the given action.
     *
     * @param action the action taken
     * @return the next state after transition
     */
    State transition(Action action);

    /**
     * Returns just the name of the state.
     *
     * @return the state name
     */
    String str();

    /**
     * Returns a description of the state and possible transitions.
     *
     * @return information about the state
     */
    String info();
}