package chess.engine;

import chess.engine.setup.*;
import chess.model.*;
import chess.util.ChessUtils;
import java.util.ArrayList;

/**
 * The GameEngine class serves as the central controller for managing the state
 * and flow of a chess game. It initializes the game board, manages player turns,
 * and tracks the overall game status. The engine interacts with various components
 * such as BoardSetup to generate the initial board configuration and ColorPiece to
 * manage player turns and piece movements.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */
public class GameEngine {
    private BoardSetup setup;
    private Piece board[][];
    private ColorPiece turn;
    private int cantMove;
    private boolean gameStatus;

    public GameEngine(){}

    public void starGame(){
        board = setup.generateBoard();

        this.turn = setup.getTurnOrder()[0];
        this.cantMove = 0;
        this.gameStatus = true;
    }

    public void eventMove(String piece, Position position){
        Position positionPiece = ChessUtils.positionPiece(this.board, this.turn, piece);
        if(positionPiece == null){
            System.out.printf("Piece %s invalid for turn %s", piece, this.turn.getColor());
            return;
        }

        int indexI = positionPiece.toMatrixRow();
        int indexJ = positionPiece.toMatrixCol();
        Piece pieceCurrent = this.board[indexI][indexJ];
        ArrayList<Position> positionsValid = pieceCurrent.mov(this.board, positionPiece);

        for(Position positionValid : positionsValid){
            if(!position.equals(positionValid)) continue;
            this.board[indexI][indexJ] = null;
            this.board[position.toMatrixRow()][position.toMatrixCol()] = pieceCurrent;
            this.cantMove++;
            this.turn = this.setup.getTurnOrder()[this.cantMove%this.setup.getPlayers()];
            return;
        }
        System.out.printf("Position %s invalid for the piece %s", position.algebraicPosition(), piece);
    }

    public BoardSetup[] getAvailable(){
        return BoardSetup.getAvailable();
    }

    public void typeGame(int election){
        BoardSetup modes[] = getAvailable();
        if(election < 1 || election > modes.length)
            throw new IllegalArgumentException("Invalid mode: " + election);

        setup = modes[election - 1];
    }

    public Piece[][] getBoard() { return this.board; }
    public ColorPiece getTurn() { return this.turn; }
    public int getMoves(){ return this.cantMove; }
    public BoardSetup getSetup(){ return setup; }
    public boolean isGameAtive(){ return this.gameStatus; }
}
