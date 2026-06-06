package chess.model;

/**
 * Represents a color in the game of chess and managed the turn order
 *  of the players.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */

public class ColorPiece {
    private final int id;
    private final String color;
    private final Delta direction;
    private final int gameTurn;

    /**
     * Constructs a piece color with unique id, its name, and an assigned turn.
     * 
     * @param id Unique numeric identifier for the color.
     * @param color Name of the color (e.g., "White" or "Black").
     * @param direction The delta representing the direction of movement for this color.
     * @param gameTurn A numeric value representing the turn order for this color.
     */
    public ColorPiece(int id, String color, Delta direction, int gameTurn){
        this.id = id;
        this.color = color;
        this.direction = direction;
        this.gameTurn = gameTurn;
    }

    /** @return The unique numeric identifier for the color. */
    public int getId(){ return this.id; }

    /** @return The name of the color. */
    public String getColor(){ return this.color; }

    /** @return The direction associated with the color. */
    public Delta getDirection(){ return this.direction; }

    /** @return The numeric value representing the turn order for this color. */
    public int getGameTurn(){ return this.gameTurn; }
}
