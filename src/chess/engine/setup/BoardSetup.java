package chess.engine.setup;

import chess.model.ColorPiece;
import chess.model.Piece;

public abstract class BoardSetup {
    private static final BoardSetup[] REGISTERED = {
        new StandardSetup()
    };

    protected final String name;
    protected final int rows;
    protected final int cols;
    protected final int players;
    protected final int piecePlayer;
    protected final String description;


    protected BoardSetup(String name, int rows, int cols, int players,
        int piecePlayer, String description){
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.players = players;
        this.piecePlayer = piecePlayer;
        this.description = description;
    }

    public abstract Piece[][] generateBoard();
    public abstract ColorPiece[] getTurnOrder();

    public String getName(){ return name; }
    public int getRows(){ return rows; }
    public int getCols(){ return cols; }
    public int getPlayers(){ return players; }
    public String getDescription(){ return description; }

    public static BoardSetup[] getAvailable(){ return REGISTERED; }
}
