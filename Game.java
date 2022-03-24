import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public static void main(String[] args) {
        Board chineseCheckers = new Board();

        chineseCheckers.initBoard();
        String[][] stringArray = chineseCheckers.drawBoard();
        chineseCheckers.printBoard(stringArray);

        Position pos = UserInput.askUserForMarbleCoords();
        Marble marble = chineseCheckers.getBoardArray()[pos.x][pos.y];
        
        marble.moveOver(chineseCheckers);
        checkIfWon(chineseCheckers, marble, chineseCheckers.getEndZones()[marble.getOppColour()]);

        chineseCheckers.printBoard(chineseCheckers.drawBoard());
    }

    public static boolean checkIfWon(Board board, Marble marble, Position[] lop) {
        ArrayList<Marble> sameColouredMarbles = new ArrayList<Marble>();
        for (Marble[] marbleArray : board.boardArray) {
            for (Marble m : marbleArray) {
                if (m.colour == marble.colour) {
                    sameColouredMarbles.add(m);
                }
            }
        }
        int numMarblesInEndZone = 0;
        for (Marble m: sameColouredMarbles) {
            if (Arrays.asList(lop).contains(m.pos)) {
                numMarblesInEndZone++;
            }
        }
        return (numMarblesInEndZone == 10);
    }

}