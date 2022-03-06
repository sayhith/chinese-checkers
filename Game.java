public class Game {
    public static void main(String[] args) {
        Board chineseCheckers = new Board();
        chineseCheckers.initBoard();
        String[][] stringArray = chineseCheckers.stringify2();
        chineseCheckers.printBoard(stringArray);
    }
}