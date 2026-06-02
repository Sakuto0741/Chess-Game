package chess.engine.setup;

import chess.model.*;
import chess.model.pieces.*;

public class StandardSetup implements BoardSetup {
    public final int cantPlayer = 2;

    public StandardSetup(){}

    @Override
    public Piece[][] generateBoard(){
        Piece[][] board = new Piece[8][8];
        ColorPiece white = new ColorPiece(1, "White", 1);
        ColorPiece black = new ColorPiece(2, "Black", 2);
        
        // Kings Position
        board[7][4] = new King(1, white);
        board[0][4] = new King(1, black);

        // Queens Position
        board[7][3] = new Queen(1, white);
        board[0][3] = new Queen(1, black);

        // Bishops Position
        for(int i = 1; i <= 2; i++){
            board[7][3*i - 1] = new Bishop(i, white);
            board[0][3*i - 1] = new Bishop(i, black);
        }

        // Knights Position
        for(int i = 1; i <= 2; i++){
            board[7][5*i - 4] = new Knight(i, white);
            board[0][5*i - 4] = new Knight(i, black);
        }

        // Rooks Position
        for(int i = 1; i <= 2; i++){
            board[7][7*i - 7] = new Rook(i, white);
            board[0][7*i - 7] = new Rook(i, black);
        }

        // Pawns Position
        for(int i = 1; i <= 8; i++){
            board[6][i-1] = new Pawn(i, white);
            board[1][i-1] = new Pawn(i, black);
        }

        return board;
    }
}
