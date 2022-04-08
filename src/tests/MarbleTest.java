package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Board;
import main.Marble;
import main.Position;

public class MarbleTest {
    Board board;
    // Marble marble;
    // Marble marble2;
    // Marble marble3;
    // Marble marble4;
    // Marble marble5;

    @Before
    public void setUp() {
        board = new Board();
        board.initBoard();

        // marble = board.getBoardArray()[0][12];
        // marble2 = board.getBoardArray()[9][3];
        // marble3 = board.getBoardArray()[4][4];
        // marble4 = board.getBoardArray()[2][14];
        // marble5 = board.getBoardArray()[3][13];
    }

    @Test
    public void noValidSpotsTest() {
        Marble marble = board.getBoardArray()[0][12];
        List<Position> validSpots = marble.getValidSpots(board);
        assertEquals(0, validSpots.size());
    }

    @Test
    public void validAdjacentSpotsTest() {
        Marble marble = board.getBoardArray()[9][3];

        List<Position> validSpots = marble.getValidSpots(board);
        assertEquals(2, validSpots.size());
        assertTrue(validSpots.contains(new Position(8, 4)));
        assertTrue(validSpots.contains(new Position(9, 5)));
    }

    @Test
    public void validJumpingSpotsTest() {
        Marble marble = board.getBoardArray()[4][4];

        List<Position> validSpots = marble.getValidSpots(board);
        assertEquals(2, validSpots.size());
        assertTrue(validSpots.contains(new Position(4, 8)));
        assertTrue(validSpots.contains(new Position(6, 6)));
    }

    @Test
    public void manyValidSpotsTest() {
        Marble marble = board.getBoardArray()[2][14];
        Marble marble2 = board.getBoardArray()[3][13];
        marble.moveManually(board, new Position(4, 12));

        List<Position> validSpots = marble2.getValidSpots(board);
        assertEquals(3, validSpots.size());
        assertTrue(validSpots.contains(new Position(2, 14)));
        assertTrue(validSpots.contains(new Position(5, 11)));
        assertTrue(validSpots.contains(new Position(4, 14)));
    }
    
    @Test
    public void moveManuallyTest() {
        Marble marble = board.getBoardArray()[2][14];
        marble.moveManually(board, new Position(4, 12));

        assertEquals(null, board.getBoardArray()[2][14]);
        assertEquals(new Position(4, 12), marble.getPos());
        assertEquals(marble, board.getBoardArray()[4][12]);
    }
}
