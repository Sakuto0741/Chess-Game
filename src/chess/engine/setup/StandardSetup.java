package chess.engine.setup;

import chess.model.*;
import chess.model.pieces.*;

public class StandardSetup implements BoardSetup {
    public final int cantPlayer = 2;
    public final int cantPieces = 16;
    public final int boardSizeCol = 8;
    public final int boardSizeRow = 8;
    public final int totalPieces = cantPlayer * cantPieces;

    public StandardSetup(){}

    @Override
    public Piece[][] generateBoard(){
        Piece[][] board = new Piece[boardSizeRow][boardSizeCol];
        ColorPiece white = new ColorPiece(1, "White", new Delta(0, 1), 1);
        ColorPiece black = new ColorPiece(2, "Black", new Delta(0, -1), 2);
        
        // Kings Position
        board[7][4] = new King(1, white, true);
        board[0][4] = new King(1, black, true);

        // Queens Position
        board[7][3] = new Queen(1, white, true);
        board[0][3] = new Queen(1, black, true);

        // Bishops Position
        for(int i = 1; i <= 2; i++){
            board[7][3*i - 1] = new Bishop(i, white, true);
            board[0][3*i - 1] = new Bishop(i, black, true);
        }

        // Knights Position
        for(int i = 1; i <= 2; i++){
            board[7][5*i - 4] = new Knight(i, white, true);
            board[0][5*i - 4] = new Knight(i, black, true);
        }

        // Rooks Position
        for(int i = 1; i <= 2; i++){
            board[7][7*i - 7] = new Rook(i, white, true);
            board[0][7*i - 7] = new Rook(i, black, true);
        }

        // Pawns Position
        for(int i = 1; i <= 8; i++){
            board[6][i-1] = new Pawn(i, white, true);
            board[1][i-1] = new Pawn(i, black, true);
        }

        return board;
    }
}
