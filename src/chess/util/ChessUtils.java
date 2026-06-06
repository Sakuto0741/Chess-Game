package chess.util;

import chess.model.*;

public final class ChessUtils {
    private ChessUtils(){
        throw new UnsupportedOperationException("Utility Class");
    }

    public static boolean isOccupied(Piece[][] board, Position position){
        int indexI = position.toMatrixRow();
        int indexJ = position.toMatrixCol();

        return board[indexI][indexJ] != null;
    }

    public static boolean isEnemy(Piece[][] board, ColorPiece color, Position position){
        int indexI = position.toMatrixRow();
        int indexJ = position.toMatrixCol();

        return board[indexI][indexJ].getColor().getId() != color.getId();
    }
}
