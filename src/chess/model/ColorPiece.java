package chess.model;

public class ColorPiece {
    private final int id;
    private final String color;
    private final int gameTurn;

    public ColorPiece(int id, String color, int gameTurn){
        this.id = id;
        this.color = color;
        this.gameTurn = gameTurn;
    }

    // Getters
    public int getId(){ return this.id; }
    public String getColor(){ return this.color; }
    public int getGameTurn(){ return this.gameTurn; }
}
