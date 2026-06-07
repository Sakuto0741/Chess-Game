package chess.model;

import chess.util.ChessUtils;
import java.util.ArrayList;

/**
 * Represents a chess piece.
 * Serves as the base class for specific piece type, managing
 * their identity, color and identifier generation.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */

public abstract class Piece {
    // Identity attributes
    private final int id;
    private final ColorPiece color;
    protected String typePiece;
    private boolean positionInitial;

    // Analysis attributes
    protected int value;
    
    /**
     * Constructs a piece with numeric identificator and an assigned color.
     * 
     * @param id A numeric identifier for the piece.
     * @param color The color of the piece.
     */
    public Piece(int id, ColorPiece color, boolean positionInitial){
        this.id = id;
        this.color = color;
        this.positionInitial = positionInitial;
    }

    /**
     * Evalutes a single target position and adds it to valid moves list
     * if it is empty or occupied by an enemy piece.
     * 
     * @param delta The direction offset to evaluate.
     * @param board The current state of the chess board.
     * @param origin The starting position of the piece.
     * @param resutl The list where the valid target positions are stored.
     */
    protected void addIfValid(Delta delta, Piece[][] board, Position origin, ArrayList<Position> result){
        Position candidate = origin.add(delta, board.length, board[0].length);
        if(candidate == null) return;

        if(ChessUtils.isOccupied(board, candidate)){
            if(ChessUtils.isEnemy(board, this.getColor(), candidate)){
                result.add(candidate);
            }
            return;
        }
        result.add(candidate);
    }

    /**
     * Recursively scans a straight line direction on the board, adding all valid
     * position to the result until an obstacle or the edge the board is hit.
     * 
     * @param delta The directional step vector for the scan.
     * @param board The current state of the chess board.
     * @param origin The starting position for the current step.
     * @param result The list colleting all valid recheable positions.
     */
    protected void scanDirection(Delta delta, Piece[][] board, Position origin,
                                 ArrayList<Position> result){
        Position candidate = origin.add(delta, board.length, board[0].length);
        if(candidate == null) return;

        if(ChessUtils.isOccupied(board, candidate)){
            if(ChessUtils.isEnemy(board, this.getColor(), candidate)){
                result.add(candidate);
                return;
            }else{
                return;
            }
        }
        result.add(candidate);

        // Recursibility step for the next scan of the position
        scanDirection(delta, board, origin, result);
    }

    public abstract ArrayList<Position> mov(Piece[][] board, Position position);

    /**
     * Gets the movement direction modifier based on the piece's color.
     * 
     * @return A Delta object representing the forward direction.
     */
    public Delta direction(){
        return this.color.getDirection();
    }

    /** @return The numeric indentifier of the piece. */
    public int getId(){ return this.id; }

    /** @return The color of the piece. */
    public ColorPiece getColor(){ return this.color; }

    /** @return The position state of the piece (e.g., 'true' for the initial position). */
    public boolean isInitialPosition(){ return this.positionInitial; }

    /**
     * Generates a unique text identifier for the piece (e.g., "WN1" for White Knight 1).
     * If the piece is a Knight, it assined the letter 'N' to prevent a naming
     * conflict with the King ('K').
     * 
     * @return A string representing the unique identifier of the piece.
     */
    public String getIdentificator(){
        // ASCII code 78 corresponds to the letter 'N' (to differenttiate Knight from King)
        char identificatorTypePiece = (!typePiece.equals("Knight"))? typePiece.charAt(0) : (char) 78;
        return String.valueOf(this.color.getColor().charAt(0))
            + identificatorTypePiece
            + this.id;
    }

    /**
     * Toggle the initial position status of the piece.
     */
    public void setPositionInitial(){
        this.positionInitial = !this.positionInitial;
    }
}
