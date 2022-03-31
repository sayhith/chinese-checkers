import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public static void main(String[] args) {
        Board chineseCheckers = new Board();
        chineseCheckers.initBoard();
        boolean won = false;

        do {
            chineseCheckers.printBoard(chineseCheckers.drawBoard());
            Position pos = UserInput.askUserForMarbleCoords();
            Marble marble = chineseCheckers.getBoardArray()[pos.x][pos.y];

            marble.moveOver(chineseCheckers);
            won = checkIfWon(chineseCheckers, marble, chineseCheckers.getEndZones()[marble.getOppColour()]);
        }
        while (won == false); 
        System.out.println("Congratulations! You have won the game.");
    }

    public static boolean checkIfWon(Board board, Marble marble, Position[] lop) {
        ArrayList<Marble> sameColouredMarbles = new ArrayList<Marble>();
        for (Marble[] marbleArray : board.boardArray) {
            for (Marble m : marbleArray) {
                if ((m != null) && (m.colour == marble.colour)) {
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