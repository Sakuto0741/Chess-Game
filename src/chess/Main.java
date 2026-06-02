package chess;

import chess.ui.ConsoleRenderer;

class Main {
    public static void main(String[] args) {
        ConsoleRenderer console = new ConsoleRenderer();
        console.electionTypeGame();
        console.intergaceInitial();
        console.printBoard();
    }
}
