public class Game {
    public static void main(String[] args) {
        Board chineseCheckers = new Board();
        chineseCheckers.initBoard();
        String[][] stringArray = chineseCheckers.drawBoard();
        chineseCheckers.printBoard(stringArray);
        chineseCheckers.selectPiece();
        chineseCheckers.printBoard(chineseCheckers.drawBoard());
    }
}