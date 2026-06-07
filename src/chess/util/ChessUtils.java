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
        if(position == null) return false;
        int indexI = position.toMatrixRow();
        int indexJ = position.toMatrixCol();
        
        if(board[indexI][indexJ] == null) return false;
        return board[indexI][indexJ].getColor().getId() != color.getId();
    }

    public static Position positionPiece(Piece[][] board, ColorPiece color, String piece){
        String pieceIdentidicator = color.getColor().charAt(0) + piece;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == null) continue;
                if(!board[i][j].getIdentificator().equals(pieceIdentidicator)) continue;
                return Position.fromMatrix(i, j);
            }
        }
        return null;
    }

    public static boolean isValidPiece(Piece[][] board, ColorPiece color, String piece){
        String pieceIdentidicator = color.getColor().charAt(0) + piece;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == null) continue;
                if(!board[i][j].getIdentificator().equals(pieceIdentidicator)) continue;
                return true;
            }
        }
        return false;
    }
}
