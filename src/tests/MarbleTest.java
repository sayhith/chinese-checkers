package tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Board;
import main.Marble;
import main.Position;

public class MarbleTest {
    Board board;
    Marble marble;

    @Before
    public void setUp() {
        board = new Board();
        board.initBoard();

        marble = new Marble(0, 0, null);
        marble = board.getBoardArray()[12][0];
    }

    @Test
    public void noValidSpotsTest() {
        List<Position> ab = marble.getValidSpots(board);
        assertTrue(ab.size() == 0);
    }
    
}
