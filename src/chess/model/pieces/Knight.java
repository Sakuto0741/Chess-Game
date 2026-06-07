package chess.model.pieces;

import chess.model.*;
import java.util.ArrayList;

/** 
 * Represents the Knight piece in chess.
 * Inherints from the base {@link Piece} class and defines the specific
 * properties to a knight, such as its values is 3.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */
public class Knight extends Piece {
    public final Delta[] MOVES = {
        new Delta(2, 1), new Delta(-2, 1),
        new Delta(2, -1), new Delta(-2, -1),
        new Delta(1, 2), new Delta(-1, 2),
        new Delta(1, -2), new Delta(-1, -2)
    };

    /**
     * Constructs the Knight pieces with the id and an assigned color.
     * Initializes the pieces type as "Knight" and sets its value as 3.
     * 
     * @param id Numeric identifier for this specific Knight.
     * @param color The color of the piece.
     */
    public Knight(int id, ColorPiece color, boolean positionInitial){
        super(id, color, positionInitial);
        super.typePiece = "Knight";
        super.value = 3;
    }

    @Override
    public ArrayList<Position> mov(Piece[][] board, Position position){
        ArrayList<Position> positions = new ArrayList<>();
        for(Delta d : MOVES){
            addIfValid(d, board, position, positions);
        }
        return positions;
    }
}
