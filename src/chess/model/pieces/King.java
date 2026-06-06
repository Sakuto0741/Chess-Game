package chess.model.pieces;

import chess.model.*;
import java.util.ArrayList;

/**
 * Represents the King piece in chess.
 * Inherints from the base {@link Piece} class and defines the specific
 * properties to a king, such as its infinates relative values.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */
public class King extends Piece {
    public static Delta[] MOVES = {
        new Delta(1, 0), new Delta(-1, 0),
        new Delta(0, 1), new Delta(0, -1),
        new Delta(1, 1), new Delta(-1, 1),
        new Delta(1, -1), new Delta(-1, -1)
    };

    /**
     * Constructs the King pieces with the id and an assigned color.
     * Initializes the pieces type as "King" and sets its value to the maximum
     * integer representation, as losing the King means losing the game.
     * 
     * @param id Numeric identifier for this specific King.
     * @param color The color of the piece.
    */
   public King(int id, ColorPiece color, boolean positionInitial){
       super(id, color, positionInitial);
       super.typePiece = "King";
       // Integer.MAX_VALUE is used because the King has the infinate value in the chess evaluation
        super.value = Integer.MAX_VALUE;
    }

    public ArrayList<Position> mov(Piece[][] board, Position position){
        ArrayList<Position> positions = new ArrayList<>();
        for(Delta d : MOVES){
            addIfValid(d, board, position, positions);
        }
        return positions;
    }
}