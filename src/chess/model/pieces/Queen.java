package chess.model.pieces;

import chess.model.*;

public class Queen extends Piece {
    public Queen(int id, ColorPiece color){
        super(id, color);
        super.typePiece = "Queen";
        super.value = 9;
    }
}
