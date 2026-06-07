package chess.model;

import chess.util.PositionUtils;

/**
 * Represents a specific position on the chess board using algebraic notation.
 * Manage the conversion between standard chess coordenates (e.g e1)
 * and internal matrix indices (0 - 7).
 * 
 * @author @Sakuto0741
 * @version 1.0
 */
public class Position {
    private final char col;
    private final int row;

    /**
     * Constructs a board position using standard algebraic coordenates.
     * 
     * @param col The algebraic column letter (typically 'a' through 'h').
     * @param row The algebraic row number (typically 1 through 8).
     */
    public Position(char col, int row){
        this.col = col;
        this.row = row;
    }
    
    /**
     * Converts the algebraic column character to zero-based matrix index.
     * 
     * @return The column index for a 2D array (e.g., 'a' maps to 0).
     */
    public int toMatrixCol(){
        // Substracting 'a' converts the char ASCII to a 0-7 range index
        return this.col - 'a';
    }

    /**
     * Converts the algebraic row number to a zero-based matrix index.
     * 
     * @return The row index for a 2D array (e.g., 8 maps to 0).
     */
    public int toMatrixRow(){
        // Chess rows go to 1-8 (bottom-to-top), while matrix indices go to 0-8 (top-to-bottom)
        return 8 - this.row;
    }

    /**
     * Factory method to create a Position instance from matrix coordenates.
     * 
     * @param col The zero-based column index (0 - 7).
     * @param row The zero-based row index (0 - 7).
     * @return A new Position object with algebraics values.
     */
    public static Position fromMatrix(int row, int col){
        // Maps matrix indices back to 'a'-'h' chars and 1-8 rows
        return new Position((char) ('a' + col), 8 - row);
    }

    /**
     * Factory method to parse standard chess input notation.
     * Valied inputs are in the form of a letter followed by a number (e.g., "e4").
     * Throws IllegalArgumentException for invalid formats or out-of-board positions.
     * 
     * @param notation The input string (e.g., "e4").
     * @return A new Position object parsed from input.
     */
    public static Position fromInput(String notation) throws IllegalArgumentException{
        // Valid formats are exactly 2 characters long (e.g., "e4")
        if(notation == null || notation.length() != 2)
            throw new IllegalArgumentException("Invalid notation " + notation);

        char col = PositionUtils.toAlgebraicNotactionCol(notation);
        int row = PositionUtils.toAlgebraicNotactionRow(notation);

        // Validate that the column is between 'a' and 'z' and the row is positive
        if(col < 'a'|| col > 'z') 
            throw new IllegalArgumentException("Invalid position, the notation have a invalid character:" + notation);
        if(row < 1) 
            throw new IllegalArgumentException("Invalid position, the notation have a invalid number:" + notation);

        return new Position(col, row);
    }

    /**
     * Adds a Delta to the current position, returning a new Position object.

     * @param delta The change in column and row to apply to the current position.
     * @return A new Position object resulting from applying the Delta,
     * or null if the resulting position is out of bounds (negative indices).
     */
    public Position add(Delta delta){
        int newCol = toMatrixCol() + delta.dCol;
        int newRow = toMatrixRow() - delta.dRow;
        if(newCol < 0 || newRow < 0) return null;
        return fromMatrix(newRow, newCol);
    }

    /**
     * Adds a Delta to the current position, returning a new Position object.
     * This method also checks if the resulting position is within the specified
     * board limits.
     * 
     * @param delta The change in column and row to apply to the current position.
     * @param maxCol The maximum column index (exclusive).
     * @param maxRow The maximum row index (exclusive).
     * @return A new Position object resulting from applying the Delta,
     * or null if the resulting position is out of bounds.
     */
    public Position add(Delta delta, int maxCol, int maxRow){
        int newCol = toMatrixCol() + delta.dCol;
        int newRow = toMatrixRow() - delta.dRow;
        if(newCol < 0 || newRow < 0 || newCol >= maxCol || newRow >= maxRow) return null;
        return fromMatrix(newRow, newCol);
    }

    /**
     * Checks if this position is equal to another object.
     * Two Position objects are considered equal if they have the same column and
     * row values.
     * 
     * @param obj The object to compare with this position.
     * @return True if the given object is a Position with the same column and row,
     * false otherwise.
     */
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return other.getCol() == this.col && other.getRow() == this.row;
    }

    /**
     * Checks if the given position is in the same column as this position.
     * 
     * @param position The position to compare with this position.
     * @return True if the given position is in the same column, false otherwise.
     */
    public boolean sameCol(Position position){
        return position.getCol() == this.col;
    }

    /**
     * Checks if the given position is in the same row as this position.
     * 
     * @param position The position to compare with this position.
     * @return True if the given position is in the same row, false otherwise.
     */
    public boolean sameRow(Position position){
        return position.getRow() == this.row;
    }

    /**
     * Returns the full algebraic coordenates as text.
     * 
     * @return A text representation of the position (e.g., "e4").
     */
    public String algebraicPosition(){
        return String.valueOf(this.col) + this.row;
    }

    /** @return The column of the position. */
    public char getCol(){ return this.col; }

    /** @return The row of the position. */
    public int getRow(){ return this.row; }
}