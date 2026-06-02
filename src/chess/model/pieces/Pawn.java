package chess.model.pieces;

import chess.model.*;

public class Pawn extends Piece {
    public Pawn(int id, ColorPiece color){
        super(id, color);
        super.typePiece = "Pawn";
        super.value = 1;
    }
}