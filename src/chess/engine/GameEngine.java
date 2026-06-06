package chess.engine;

import chess.engine.setup.*;
import chess.model.*;

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

        this.gameStatus = true;
        this.cantMove = 0;
    }

    public void typeGame(int election){
        switch (election) {
            case 1 -> setup = new StandardSetup();
            default -> throw new AssertionError();
        }
    }

    public Piece[][] getBoard() { return board; }
    public ColorPiece getTurn() { return turn; }
    public int getMoves(){ return cantMove; }
    public boolean isGameAtive(){ return this.gameStatus; }
}
