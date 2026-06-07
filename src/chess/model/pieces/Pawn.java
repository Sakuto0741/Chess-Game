package chess.model.pieces;

import chess.model.*;
import chess.util.ChessUtils;
import java.util.ArrayList;

/**
 * Represents the Pawn piece in chess.
 * Inherints from the base {@link Piece} class and defines the specific
 * properties to a pawn and your moves.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */
public class Pawn extends Piece {

    /**
     * Constructs the Pawn pieces with the id and an assigned color.
     * Initializes the pieces type as "King" and sets its value as 1.
     * 
     * @param id Numeric identifier for this specific Pawn.
     * @param color The color of the piece.
     */
    public Pawn(int id, ColorPiece color, boolean positionInitial){
        super(id, color, positionInitial);
        super.typePiece = "Pawn";
        super.value = 1;
    }

    protected Delta[] getCapture(){
        if(direction().dRow != 0){
            return new Delta[]{
                new Delta(1, direction().dRow),
                new Delta(-1, direction().dRow)
            };
        }else if(direction().dCol != 0){
            return new Delta[]{
                new Delta(direction().dCol, 1),
                new Delta(direction().dCol, -1),
            };
        }
        return null;
    }

    protected void scanMovePawn(Delta delta, Piece[][] board, Position origin, ArrayList<Position> result){
        for(int i = 1; i <= 2; i++){
            Delta d = new Delta(delta.dCol*i, delta.dRow*i);
            Position candidate = origin.add(d, board.length, board[0].length);
            if(candidate == null) return;

            if(ChessUtils.isOccupied(board, candidate)){
                return;
            }
            result.add(candidate);
            if(!this.isInitialPosition())
                return;
        }
    }

    @Override
    public ArrayList<Position> mov(Piece[][] board, Position position){
        ArrayList<Position> positions = new ArrayList<>();
        scanMovePawn(direction(), board, position, positions);
        for(Delta d : getCapture()){
            if(!ChessUtils.isEnemy(board, this.getColor(), position.add(d)))
                continue;
            addIfValid(d, board, position, positions);
        }
        return positions;
    }
}