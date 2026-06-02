package chess.model;

public class Piece {
    private final int id;
    private final ColorPiece color;
    protected String typePiece;

    // Atributos de analisis
    protected int value;
    
    public Piece(int id, ColorPiece color){
        this.id = id;
        this.color = color;
    }

    public int getId(){ return this.id; }
    public ColorPiece getColor(){ return this.color; }

    public String getIdentificator(){
        char identificatorTypePiece = (!typePiece.equals("Knight"))? typePiece.charAt(0) : (char) 78;
        return String.valueOf(this.color.getColor().charAt(0))
            + identificatorTypePiece
            + this.id;
    }
}
