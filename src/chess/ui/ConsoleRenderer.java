package chess.ui;

import chess.engine.*;
import chess.model.Piece;
import chess.model.Position;
import chess.util.ChessUtils;
import java.util.Scanner;

public class ConsoleRenderer {
    private final GameEngine engine = new GameEngine();
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleRenderer(){}

    public void init(){
        startSection();
    }

    private int nextInt(){
        int election = this.scanner.nextInt();
        this.scanner.nextLine();
        return election;
    }

    public void startSection(){
        String title = "chess";
        String options[] = {
            "Start", "Exit"
        };
        int width = 15;

        ConsoleUI.border(width);
        ConsoleUI.titleCase(title, width);
        ConsoleUI.inner(width);
        ConsoleUI.optionsCase(options, width);
        ConsoleUI.border(width);

        int election = nextInt();
        switch (election) {
            case 1 -> electionModeGameSection();
            case 2 -> endConsole();
            default-> {
                System.out.print("Invalid option" + election);
                startSection();
            }
        }
    }

    public void endConsole(){

    }

    public void electionModeGameSection(){
        String title = "Mode Game";
        String options[] = new String[this.engine.getAvailable().length + 1];
        int width = 25;

        for(int i = 0; i < options.length - 1; i++)
            options[i] = this.engine.getAvailable()[i].getName();
        options[options.length - 1] = "back";

        ConsoleUI.border(width);
        ConsoleUI.titleCase(title, width);
        ConsoleUI.inner(width);
        ConsoleUI.optionsCase(options, width);
        ConsoleUI.border(width);

        int election = nextInt();
        switch (election) {
            case 1 -> {
                this.engine.typeGame(election);
                informationGameModeSection(); 
            }
            case 2 -> startSection();
            default-> {
                System.out.print("Invalid option" + election);
                electionModeGameSection();
            }
        }
    }

    public void informationGameModeSection(){
        String title = "Information Mode Game";
        String subtitle = this.engine.getSetup().getName();
        String description = this.engine.getSetup().getDescription();
        String lists[] = {
            String.format("Board Size: %dx%d", this.engine.getSetup().getRows(), this.engine.getSetup().getCols()),
        };
        String options[] = {
            "Start game",
            "Back",
            "Back to start"
        };
        int width = 50;

        ConsoleUI.border(width);
        ConsoleUI.titleCase(title, width);
        ConsoleUI.inner(width);
        ConsoleUI.subtitleCase(subtitle, width);
        ConsoleUI.p(description, width); // in procesed
        ConsoleUI.listCase(lists, width);
        ConsoleUI.inner(width);
        ConsoleUI.optionsCase(options, width);
        ConsoleUI.border(width);

        int election = nextInt();
        switch (election) {
            case 1 -> {
                this.engine.starGame();
                gameSection();
            }
            case 2 -> electionModeGameSection();
            case 3 -> startSection();
            default-> {
                System.out.print("Invalid option" + election);
                informationGameModeSection();
            }
        }
    }

    public void gameSection(){
        String title = this.engine.getSetup().getName();
        String subtitle = String.format("%d. %s",
            this.engine.getMoves(), this.engine.getTurn().getColor()
        );
        String options[] = {
            "Choose piece to move",
            "Abort"
        };
        int width = 100;

        ConsoleUI.border(width);
        ConsoleUI.titleCase(title, width);
        ConsoleUI.inner(width);
        ConsoleUI.subtitleCase(subtitle, width);
        ConsoleUI.inner(width);
        printBoard();
        ConsoleUI.inner(width);
        ConsoleUI.optionsCase(options, width);

        int election = nextInt();
        switch (election) {
            case 1 -> playMove();
            case 2 -> startSection(); // for the moment
            default-> {
                System.out.print("Invalid option" + election);
                gameSection();
            }
        }
    }

    public void endGameSection(){
        String title = "End game";
        String winnerMsg = "Winner: "; // + color winner;
        String options[] = {
            "Again",
            "Back to start"
        };
        int width = 25;

        ConsoleUI.border(width);
        ConsoleUI.titleCase(title, width);
        ConsoleUI.inner(width);
        ConsoleUI.p(winnerMsg, width);
        ConsoleUI.inner(width);
        ConsoleUI.optionsCase(options, width);

        int election = nextInt();
        switch (election) {
            case 1 -> {
                this.engine.starGame();
                gameSection(); // first other methot to initialiced the board and the engine's attributes
            }
                case 2 -> startSection();
            default-> {
                System.out.print("Invalid option" + election);
                endGameSection();
            }
        }
    }

    public void playMove(){
        String piece;
        Position position;
        do{
            System.out.println(" Piece election (e.g., P1 pawn #1)");
            piece = this.scanner.nextLine().toUpperCase();
            if(!ChessUtils.isValidPiece(this.engine.getBoard(), this.engine.getTurn(), piece))
                System.out.print("Piece invalid: " + piece);
            else
                break;
        }while(true);

        do{
            System.out.println(" Digited the position to move (e.g., e4)");
            try{
                position = Position.fromInput(this.scanner.nextLine().toLowerCase());
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(true);

        this.engine.eventMove(piece, position);
        gameSection();
    }
    
    public void printBoard(){
        Piece board[][] = this.engine.getBoard();
        int lenCol = 2*board.length + 1;
        int lenRow = 2*board[0].length + 1;

        for(int i = 0; i < lenCol; i++){
            for(int j = 0; j < lenRow; j++){
                System.out.print(resolveCell(board, i, j, lenCol, lenRow));
            }
            System.out.println();
        }
    }

    private String resolveCell(Piece[][] board, int i, int j, int lenCol, int lenRow){
        if(isHorizontalBorder(i) && isVerticalBorder(j)) return getCornerChar(i, j, lenCol, lenRow);
        if(isHorizontalBorder(i)) return "───";
        if(isVerticalBorder(j)) return "│";

        int row = i / 2;
        int col = j / 2;
        Piece piece = board[row][col];
        return piece == null ? "   " : piece.getIdentificator();
    }

    private String getCornerChar(int i, int j, int lenCol, int lenRow){
        boolean top = i == 0;
        boolean bottom = i == lenCol - 1;
        boolean right = j == 0;
        boolean left = j == lenRow - 1;

        if(top && right) return "┌";
        if(top && left) return "┐";
        if(bottom && right) return "└";
        if(bottom && left) return "┘";
        if(top) return "┬";
        if(bottom) return "┴";
        if(right) return "├";
        if(left) return "┤";
        return "┼";
    }

    private boolean isHorizontalBorder(int i){ return i%2 == 0; }
    private boolean isVerticalBorder(int j){ return j%2 == 0; }
}
