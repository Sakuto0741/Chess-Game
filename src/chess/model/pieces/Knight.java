package chess.model.pieces;

import chess.model.*;

public class Knight extends Piece {
    public Knight(int id, ColorPiece color){
        super(id, color);
        super.typePiece = "Knight";
        super.value = 3;
    }
}
