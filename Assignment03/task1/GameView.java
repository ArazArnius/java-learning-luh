import model.*;
/**
 * Jump 'n' Run Game
 * 
 * This class implements the game.
 * 
 * @author Araz Mazaheri; araz.arnius@gmail.com
 * @version April 27th, 2025
*/
public class GameView {
    /** represents the game's world in form of a 2D array */
    GameObject[][] world = new GameObject[3][20];
    /** represents the player which is an NPC in this implementation */
    NPC player;

    public static boolean contains(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    /** constructure to initalize world with a specific format of game objects */
    public GameView(NPC player) {
        this.player = player;
        // intialize the first row
        for (int i = 0; i < world[0].length; i++) {
            if (contains(new int[] {2, 6, 10, 14, 18}, i)) { // the tiles that airobstacle is at
                world[0][i] = GameObject.AIROBSTACLE;
            } else {
                world[0][i] = GameObject.EMPTY;
            }
            
            // initializes the second row
            world[1][i] = GameObject.EMPTY;
        }

        // initialize the third row
        for (int i = 0; i < world[2].length - 1; i++) {
            if (contains(new int[] {4, 8, 12, 16}, i)) { // the tiles that lava is at
                world[2][i] = GameObject.LAVA;
            } else {
                world[2][i] = GameObject.GROUND;
            }
        }

        // last tile is the TARGET('Z')
        world[2][world[2].length - 1] = GameObject.TARGET;
    }

    /** helper method to convert 2D character array to a string
     * 
     * @param text is the 2D char array that's gonna be converted
     * @return result
     */
    public static String twoDCharToString(char[][] text) {
        String result = "";

        for (char[] row : text) {
            for (char c : row) {
                result += c;
            }
            result += '\n';
        }

        return result;
    }

    /** this method returns the printable value to show the game-world
     * first builds a 2D char array from the GameObject[][] world and then converts it to string using twoDCharToString method
     * 
     * @return twoDCharToString(game) 
     */
    public String str() {
        char[][] game = new char[world.length][world[0].length];

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                game[i][j] = world[i][j].getSymbol();
            }
        }

        game[1][player.getXCoordinate()] = 'P';

        // if player is not crouching then player is 2 tiles tall
        if (!player.getIsCrouching()) {
            game[0][player.getXCoordinate()] = 'P';
        }

        return twoDCharToString(game);
    }

    /** this method contains the game rules */
    public void play() {
        while (true) {
            System.out.println(this.str());
            
            // if player is on lava or has reached the target, the game finishes
            if (world[2][player.getXCoordinate()] == GameObject.LAVA ||
                world[2][player.getXCoordinate()] == GameObject.TARGET) {
                System.out.println("\nGame has ended!");
                break;
            }

            // if there's an airobstacle in front of the player, they should crouch
            if (world[0][player.getXCoordinate() + 1] == GameObject.AIROBSTACLE) {
                player.crouch();
            } else if (world[0][player.getXCoordinate()] == GameObject.AIROBSTACLE) {
                player.stand();
            }

            // if there's lava in front of the player, they should dash
            if (world[2][player.getXCoordinate() + 1] == GameObject.LAVA) {
                if (player.getIsCrouching()) {
                    player.stand();
                }
                player.dashRight();
            } else { // if there's no lava then walk normally
                player.walkRight();
            }
        }
    }

    /** this method runs the game */
    public static void main(String[] args) {
        NPC p = new NPC(0, false);
        GameView game1 = new GameView(p);
        game1.play();
    }
}