package chess.model.pieces;

import chess.model.*;

public class King extends Piece {
    public King(int id, ColorPiece color){
        super(id, color);
        super.typePiece = "King";
        super.value = Integer.MAX_VALUE;
    }
}