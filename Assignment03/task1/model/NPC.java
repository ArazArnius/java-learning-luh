package model;

/**
 * represents the NPC (non playable character) that is gonna be moving in the game.
 * the NPC can either be standing or crouching
 */
public class NPC {
    /** represents the x-coordinate of the NPC */
    private int x_coordinate;
    /** indicates whether the NPC is crouching or standing */
    private boolean is_crouching;

    public NPC(int x_coordinate, boolean is_crouching) {
        this.x_coordinate = x_coordinate;
        this.is_crouching = is_crouching;
    }
    /** getter method for {@link model.NPC#x_coordinate} attribute */
    public int getXCoordinate() {
        return x_coordinate;
    }

    /** setter method for {@link model.NPC#x_coordinate} attribute
     * {@link model.NPC#x_coordinate} represents the x-coordinate of the NPC
     * 
     * @param x_coordinate
     */
    public void setXCoordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    /** getter method for {@link model.NPC#is_crouching} attribute
     * {@link model.NPC#is_crouching} indicates whether the NPC is crouching or standing
     * 
     * @return is_crouching
     */
    public boolean getIsCrouching() {
        return is_crouching;
    }

    /** alter method for {@link model.NPC#is_crouching} attribute to make NPC stand */
    public void stand() {
        is_crouching = false;
    }

    /** alter method for {@link model.NPC#is_crouching} attribute to make NPC crouch */
    public void crouch() {
        is_crouching = true;
    }

    /** method to move the NPC one unit to the right
     * increases {@link model.NPC#x_coordinate} by one
     */
    public void walkRight() {
        x_coordinate += 1;
    }

    /** method for the NPC to dash (move to right by 2 units)
     * dashing is only possible if {@link model.NPC#is_crouching} is false (the NPC is standing)
     * if the character is crouching then nothing happens when this method is called
     */
    public void dashRight() {
        if (is_crouching) {
            return;
        }

        x_coordinate += 2;
    }
}