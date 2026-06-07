package chess.engine.setup;

import chess.model.*;
import chess.model.pieces.*;

public class StandardSetup extends  BoardSetup {
    public StandardSetup(){
        super("Standar chess", 8, 8, 2, 16, description());
    }

    public static String description(){
        return "";
    }

    @Override
    public Piece[][] generateBoard(){
        Piece[][] board = new Piece[this.rows][this.cols];
        ColorPiece white = getTurnOrder()[0];
        ColorPiece black = getTurnOrder()[1];
        
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

    @Override
    public ColorPiece[] getTurnOrder(){
        return new ColorPiece[]{
            new ColorPiece(1, "White", new Delta(0, 1), 1),
            new ColorPiece(2, "Black", new Delta(0, -1), 2)
        };
    }
}
