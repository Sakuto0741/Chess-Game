package chess.model;

/**
 * Represents a directional offset on the chess board, used for calculating
 * potential moves and attacks for pieces.
 * 
 * @author @Sakuto0741
 * @version 1.0
 */
public class Delta {
    public final int dCol;
    public final int dRow;

    /**
     * Constructs a new Delta with the specified column and row offsets.
     * 
     * @param dCol The change in column.
     * @param dRow The change in row.
     */
    public Delta(int dCol, int dRow){
        this.dCol = dCol;
        this.dRow = dRow;
    }

    /**
     * Scales the delta by a given factor.
     * 
     * @param factor The factor by which to scale the delta.
     * @return A new Delta object with scaled offsets.
     */
    public Delta scale(int factor){
        return new Delta(dCol*factor, dRow*factor);
    }

    /**
     * Returns the negation of this delta.
     * 
     * @return A new Delta object with negated offsets.
     */
    public Delta negate(){
        return new Delta(-dCol, -dRow);
    }
}
