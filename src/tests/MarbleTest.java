package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Board;
import main.Marble;
import main.Position;

public class MarbleTest {
    Board board;

    @Before
    public void setUp() {
        board = new Board();
        board.initBoard();
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
    public void getAdjacentSpotsTest() {
        Marble marble = board.getBoardArray()[3][11];
        Marble marble2 = board.getBoardArray()[11][21];
        marble.moveManually(board, new Position(4, 12));
        marble2.moveManually(board, new Position(9, 19));

        List<Position> adjSpots = marble.getAdjacentSpots(board);
        assertEquals(5, adjSpots.size());
        assertTrue(adjSpots.contains(new Position(3, 11)));
        assertTrue(adjSpots.contains(new Position(4, 10)));
        assertTrue(adjSpots.contains(new Position(5, 11)));
        assertTrue(adjSpots.contains(new Position(5, 13)));
        assertTrue(adjSpots.contains(new Position(4, 14)));

        List<Position> adjSpots2 = board.getBoardArray()[10][20].getAdjacentSpots(board);
        assertEquals(2, adjSpots2.size());
        assertTrue(adjSpots2.contains(new Position(11, 21)));
        assertTrue(adjSpots2.contains(new Position(10, 18)));
        
    }

    @Test
    public void getJumpingSpotsTest() {
        Marble marble = board.getBoardArray()[4][4];
        List<Position> lop = new ArrayList<Position>();
        List<Position> jmpSpots = marble.getJumpingSpots(board, 4, 4, lop);

        assertEquals(2, jmpSpots.size());
        assertTrue(jmpSpots.contains(new Position(6, 6)));
        assertTrue(jmpSpots.contains(new Position(4, 8)));
    }
    
    @Test
    public void moveManuallyTest() {
        Marble marble = board.getBoardArray()[2][14];
        marble.moveManually(board, new Position(4, 12));

        assertEquals(null, board.getBoardArray()[2][14]);
        assertEquals(new Position(4, 12), marble.getPos());
        assertEquals(marble, board.getBoardArray()[4][12]);
    }

    @Test
    public void moveOverValidSpotTest() {
        Marble marble = board.getBoardArray()[2][12];
        marble.moveOver(board, 14, 4);
        assertEquals(marble, board.getBoardArray()[4][14]);
        assertEquals(new Position(4, 14), marble.getPos());
    }

    @Test
    public void moveOverInvalidSpotTest() {
        Marble marble = board.getBoardArray()[2][12];
        marble.moveOver(board, 13, 3);
        assertEquals(marble, board.getBoardArray()[2][12]);
    }
}
