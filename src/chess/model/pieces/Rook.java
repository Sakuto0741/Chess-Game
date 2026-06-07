package chess.model.pieces;

import chess.model.*;
import java.util.ArrayList;

/**
 * Represents the Rook piece in chess.
 * Inherints from the base {@link Piece} class and defines the specific
 * properties to a rook, such as its value is 5.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */
public class Rook extends Piece {
    public final Delta DIRECTIONS[] = {
        new Delta(1, 0), new Delta(-1, 0),
        new Delta(0, 1), new Delta(0, -1)
    };

    /**
     * Constructs the Rook pieces with the id and an assigned color.
     * Initializes the pieces type as "Rook" and sets its value as 5.
     * 
     * @param id Numeric identifier for this specific Rook.
     * @param color The color of the piece.
     */
    public Rook(int id, ColorPiece color, boolean positionInitial){
        super(id, color, positionInitial);
        super.typePiece = "Rook";
        super.value = 5;
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
