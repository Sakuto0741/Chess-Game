package chess.model.pieces;

import chess.model.*;
import java.util.ArrayList;

/**
 * Represents the Queen piece in chess.
 * Inherints from the base {@link Piece} class and defines the specific
 * properties to a queen, such as its values is 9.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */
public class Queen extends Piece {
    public final Delta[] DIRECTIONS = {
        new Delta(1, 0), new Delta(-1, 0),
        new Delta(0, 1), new Delta(0, -1),
        new Delta(1, 1), new Delta(-1, 1),
        new Delta(1, -1), new Delta(-1, -1)
    };

    /**
     * Constructs the Queen pieces with the id and an assigned color.
     * Initializes the pieces type as "Queen" and sets its value as 9.
     * 
     * @param id Numeric identifier for this specific Quenn.
     * @param color The color of the piece.
     */
    public Queen(int id, ColorPiece color, boolean positionInitial){
        super(id, color, positionInitial);
        super.typePiece = "Queen";
        super.value = 9;
    }

    public ArrayList<Position> mov(Piece[][] board, Position position){
        ArrayList<Position> positions = new ArrayList<>();
        for(Delta d : DIRECTIONS){
            scanDirection(d, board, position, positions);
        }
        return positions;
    }
}
