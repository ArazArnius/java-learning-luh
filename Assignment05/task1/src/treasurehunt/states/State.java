package states;
Import actions.Action;

// package private access
interface State {
    // no need to explicitly declare methods public as all methods in an interface are public and abstract by default

    // performs the state transition based on the current state and the given action. It returns the next state.
    State transition(Action action);

    // returns a description of the current state and the possible transitions (e.g., “Action A → Shipwreck Bay; Action B → Musket Hill”).
    String str();

    // returns just the name of the state.
    String info();
}