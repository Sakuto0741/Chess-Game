package chess.util;

public final class PositionUtils{
    private PositionUtils(){
        throw new UnsupportedOperationException("Utility Class");
    }

    public static char toAlgebraicNotactionCol(String notation){
        return notation.charAt(0);
    }

    public static int toAlgebraicNotactionRow(String notation){   // !!! Establecer solo numeros.
        return  notation.charAt(1) - '0';
    }
}