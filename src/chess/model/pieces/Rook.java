package chess.model.pieces;

import chess.model.*;

public class Rook extends Piece {
    public Rook(int id, ColorPiece color){
        super(id, color);
        super.typePiece = "Rook";
        super.value = 5;
    }
}
