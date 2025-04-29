package task1.model;

/**
 * represents different types of game objects that can appear in the game.
 * each game object has a unique character symbol associated with it for display.
 */
public enum GameObject {
    /** represents the ground in the game */
    GROUND('G'),
    /** represents lava in the game */
    LAVA('L'),
    /** represents obstacles in the air in the game */
    AIROBSTACLE('O'),
    /** represents empty space where player can move in */
    EMPTY(' '),
    /** represents the goal that the player wants to reach */
    TARGET('Z');

    /** a character that represents an object in the game */
    private char symbol;

    /**
     * constructor to set symbol for for the object
     * 
     * @param symbol the symbol which represents the object
     */
    GameObject(char symbol) {
        this.symbol = symbol;
    }

    /** getter for {@link model.GameObject#symbol}
     * {@link model.GameObject#symbol} is an attribute that represents object type in the game
     * 
     * @return symbol
     */
    public char getSymbol() {
        return symbol;
    }
}