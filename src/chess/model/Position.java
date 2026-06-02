package chess.model;

import chess.util.PositionUtils;

public class Position {
    private char col;
    private int row;

    public Position(char col, int row){
        this.col = col;
        this.row = row;
    }
    
    public int toMatrizCol(){ return this.col - 'a'; }
    public int toMatrizRow(){ return 8 - this.row; }

    public static Position fromMatriz(int col, int row){
        return new Position((char) ('a' + col), row + 1);
    }

    public static Position fromInput(String notation){
        return new Position(PositionUtils.toAlgebraicNotactionCol(notation), 
                            PositionUtils.toAlgebraicNotactionRow(notation));
    }

    // Getters
    public char getCol(){ return this.col; }
    public int getRow(){ return this.row; }

    // Setters
    public void setCol(char newCol){ this.col = newCol; }
    public void setRow(int newRow){ this.row = newRow; }
}