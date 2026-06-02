package chess.engine;

import chess.engine.setup.*;
import chess.model.*;

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
