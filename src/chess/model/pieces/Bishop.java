package chess.model.pieces;

import chess.model.*;

public class Bishop extends Piece {
    public Bishop(int id, ColorPiece color){
        super(id, color);
        super.typePiece = "Bishop";
        super.value = 3;
    }
}