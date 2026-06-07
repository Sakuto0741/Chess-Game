package chess.model.pieces;

import chess.model.*;
import java.util.ArrayList;

/**
 * Represents the Bishop piece in chess.
 * Inherints from the base {@link Piece} class and defines the specific
 * properties to a bishop to a Bishop, such as its values is 3.
 */
public class Bishop extends Piece {
    public final Delta[] DIRECTIONS = {
        new Delta(1, 1), new Delta(-1, 1),
        new Delta(1, -1), new Delta(-1, -1)
    };

    /**
     * Constructs the Bishop piece with the id and an assigned color.
     * Initializes the pieces type as "Bishop" and sets its value as 3.
     * 
     * @param id Numeric identifier for this specific Bishop.
     * @param color The color of the piece.
     */
    public Bishop(int id, ColorPiece color, boolean positionInitial){
        super(id, color, positionInitial);
        super.typePiece = "Bishop";
        super.value = 3;
    }

    @Override
    public ArrayList<Position> mov(Piece[][] board, Position position){
        ArrayList<Position> positions = new ArrayList<>();
        for(Delta d : DIRECTIONS){
            scanDirection(d, board, position, positions);
        }
        return positions;
    }
}