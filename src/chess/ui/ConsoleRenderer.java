package chess.ui;

import chess.engine.*;
import chess.model.Piece;
import java.util.Scanner;

public class ConsoleRenderer {
    private final GameEngine engine = new GameEngine();

    public ConsoleRenderer(){}

    public void electionTypeGame(){
        int election;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Type Game");
            election = sc.nextInt();
        }
        engine.typeGame(election);
    }

    public void intergaceInitial(){ // Sin terminar
        this.engine.starGame();
    }

    public void printBoard(){
        Piece matriz[][] = this.engine.getBoard();
        int i_matriz = 0;

        int lengthBoard = (int)2*matriz.length + 1;
        for(int i = 0; i < lengthBoard*lengthBoard; i++){
            int i_b = i/lengthBoard;
            int j_b = i % lengthBoard;
            if(i_b == 0 && j_b == 0){
                System.out.print("┌");
            } else if(i_b == 0 && j_b == (lengthBoard - 1)){
                System.out.print("┐");
            } else if(i_b == (lengthBoard - 1) && j_b == 0){
                System.out.print("└");
            } else if(i_b == (lengthBoard - 1) && j_b == (lengthBoard - 1)){
                System.out.print("┘");
            } else if(i_b % 2 == 0 && j_b == 0){
                System.out.print("├");
            } else if(i_b % 2 == 0 && j_b == (lengthBoard - 1)){
                System.out.print("┤");
            } else if(i_b == 0 && j_b % 2 == 0){
                System.out.print("┬");
            } else if(i_b == (lengthBoard - 1) && j_b % 2 == 0){
                System.out.print("┴");
            } else if(i_b % 2 == 0 && j_b % 2 == 1){
                System.out.print("───");
            } else if(i_b % 2 == 1 && j_b % 2 == 0){
                System.out.print("│");
            } else if(i_b % 2 == 0 && j_b % 2 == 0){
                System.out.print("┼");
            } else{
                Piece piece = matriz[i_matriz/matriz.length][i_matriz%matriz.length];
                if(piece == null){
                    System.out.print("   ");
                } else {
                    System.out.print(piece.getIdentificator());
                }
                i_matriz++;
            }

            if(j_b == lengthBoard - 1)
                System.out.println();
        }
    }
}
