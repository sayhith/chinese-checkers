package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Marble 
 */
 public class Marble {
    int colour;
    int oppColour;
    Position pos;

    public Marble(int colour, int oppColour, Position pos) {
        this.colour = colour;
        this.oppColour = oppColour;
        this.pos = pos;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public int getOppColour() {
        return oppColour;
    }

    public void setOppColour(int oppColour) {
        this.oppColour = oppColour;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public List<Position> getValidSpots(Board b) {
        List<Position> validSpots = new ArrayList<Position>();
        validSpots.addAll(getAdjacentSpots(b));
        List<Position> jumpingSpots = new ArrayList <Position>();
        validSpots.addAll(getJumpingSpots(b, pos.y, pos.x, jumpingSpots));
        // Remove position of current marble so its own position is not a valid move 
        validSpots.remove(getPos());
        return validSpots;
    }

    public List<Position> getAdjacentSpots(Board b) {
        List<Position> adjacentSpots = new ArrayList<Position> ();
        adjacentSpots.add(new Position(pos.y-2, pos.x));
        adjacentSpots.add(new Position(pos.y+2, pos.x));
        adjacentSpots.add(new Position(pos.y-1, pos.x-1));
        adjacentSpots.add(new Position(pos.y-1, pos.x+1));
        adjacentSpots.add(new Position(pos.y+1, pos.x-1));
        adjacentSpots.add(new Position(pos.y+1, pos.x+1));

        List<Position> validAdjacentSpots = new ArrayList<Position>();

        for (Position p : adjacentSpots) {
            if (b.isEmptySpotOnBoard(p)) {
                validAdjacentSpots.add(p);
            }
        } return validAdjacentSpots;
    }
    

    public List<Position> getJumpingSpots(Board b, int y, int x, List<Position> validJumpingSpots) {

        List<Position> jumpingSpots = new ArrayList<Position>();

        if (b.isOccupiedSpotOnBoard(new Position(y, x-2))) {
            jumpingSpots.add(new Position(y, x-4));
        }

        if (b.isOccupiedSpotOnBoard(new Position(y, x+2))) {
            jumpingSpots.add(new Position(y, x+4));
        }

        if (b.isOccupiedSpotOnBoard(new Position(y-1, x-1))) {
            jumpingSpots.add(new Position(y-2, x-2));
        }

        if (b.isOccupiedSpotOnBoard(new Position(y+1, x-1))) {
            jumpingSpots.add(new Position(y+2, x-2));
        }

        if (b.isOccupiedSpotOnBoard(new Position(y-1, x+1))) {
            jumpingSpots.add(new Position(y-2, x+2));
        }

        if (b.isOccupiedSpotOnBoard(new Position(y+1, x+1))) {
            jumpingSpots.add(new Position(y+2, x+2));
        }

        for (Position p : jumpingSpots) {
            if ((b.isEmptySpotOnBoard(p) && !(validJumpingSpots.contains(p)))) {
                validJumpingSpots.add(p);
                getJumpingSpots(b, p.y, p.x, validJumpingSpots);
            }
        }
        return validJumpingSpots;
    }

    public void moveOver(Board b) {
        Position startingPos = pos;

        Position nextSpot = UserInput.askUserForMoveCoords();

        if (getValidSpots(b).contains(nextSpot)) {
            setPos(nextSpot); 
            Marble[][] board = b.getBoardArray();
            board[nextSpot.y][nextSpot.x] = this;
            board[startingPos.y][startingPos.x] = null;
        }
        else {
            System.out.println("Please select another spot.");
            moveOver(b);
        }
    }

    public List<String> ListOfPosToString(List<Position> lop) {
        List<String> listOfString = new ArrayList<String>();
        for (Position p: lop) {
            listOfString.add("(" + p.getX() + "," + p.getY() + ")");
        }
        return listOfString;
    }
}
