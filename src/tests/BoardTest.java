package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Board;
import main.Marble;
import main.Position;

public class BoardTest {

    Board board;

    @Before
    public void setUp() {
        board = new Board();

        board.getBoardArray()[0][12] = new Marble(0, 3, new Position(0, 12));
        board.getBoardArray()[1][11] = new Marble(0, 3, new Position(1, 11));
        board.getBoardArray()[1][13] = new Marble(0, 3, new Position(1, 13));
    }

    @Test
    //Checks if a spot is both unoccupied and within the boundaries of the game board.
    public void isEmptySpotOnBoardTest() {
        assertTrue(board.isEmptySpotOnBoard(new Position(5, 13)));
        assertTrue(board.isEmptySpotOnBoard(new Position(3, 9)));
        assertFalse(board.isEmptySpotOnBoard(new Position(0, 12)));
        assertFalse(board.isEmptySpotOnBoard(new Position(4, 9)));
    }

    @Test
    public void returnsFalseIfNotOnBoardTest() {
        assertFalse(board.isWithinBoardBoundaries(new Position(5, 0)));
        assertFalse(board.isWithinBoardBoundaries(new Position(10,3)));
    }

    @Test
    public void returnsTrueIfOnBoardTest() {
        assertTrue(board.isWithinBoardBoundaries(new Position(2, 10)));
        assertTrue(board.isWithinBoardBoundaries(new Position(4, 10)));


        assertTrue(board.isWithinBoardBoundaries(new Position(4, 8)));
        assertTrue(board.isWithinBoardBoundaries(new Position(3, 13)));
        assertTrue(board.isWithinBoardBoundaries(new Position(4, 14)));
        assertTrue(board.isWithinBoardBoundaries(new Position(12, 24)));
    }
    
    @Test 
    //Check if filled spot returns false.
    public void returnsFalseIfOccupiedTest() {
        assertFalse(board.isSpotUnoccupied(new Position(0, 12)));
    }

    @Test
    //Check if empty spot returns true.
    public void returnsTrueIfUnoccupiedTest() {
        assertTrue(board.isSpotUnoccupied(new Position(12,1)));
    }



}
