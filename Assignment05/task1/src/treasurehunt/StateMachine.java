package treasurehunt;
import treasurehunt.actions.*;
import treasurehunt.states.*;
import java.util.Scanner;

public class StateMachine {
    private State current;
    private boolean isGoal;

    public StateMachine() {
        this.current = new PiratesIsland(); // the start state
        this.isGoal = false;
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
        if (this.current.str().equals("Treasure Island")) { // goal is reached
            isGoal = true;
        }
    }

    public boolean getIsGoal() {
        return isGoal;
    }

    public static void main(String[] args) {
        StateMachine automaton = new StateMachine();
        Scanner sc = new Scanner(System.in);
        StringBuilder path = new StringBuilder();
        int step = 1;

        while (true) { // cli
            if (automaton.getIsGoal()) {
                System.out.println("\n\nCongrats! You found the treasure!\nThe path you have taken is:\n" + path);
                break;
            }

            System.out.print("\nYou are currently at: " + automaton.getCurrent().str() +
                                "\nPlaces up ahead:\n" + automaton.getCurrent().info() +
                                "\nPlease choose one A/B: ");

            String choice = sc.nextLine().toLowerCase();
            Action action; // causes a problem?

            switch (choice) {
                case "a": {
                    action = Action.A;
                    break;
                }
                case "b": {
                    action = Action.B;
                    break;
                }
                default: {
                    System.out.println("Invalid path!");
                    continue;
                }
            }

            path.append(step++ +  ". " + automaton.getCurrent().str() + "; "); // putting this line here so it doesn't add it to path if input is invalid
            automaton.setCurrent(automaton.getCurrent().transition(action));
        }

        sc.close();
    }
}