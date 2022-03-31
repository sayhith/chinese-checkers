import java.util.ArrayList;

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

    public ArrayList<Position> getValidSpots(Board b) {
        ArrayList<Position> validSpots = new ArrayList<Position>();
        validSpots.addAll(getAdjacentSpots(b));
        ArrayList<Position> jumpingSpots = new ArrayList <Position>();
        validSpots.addAll(getJumpingSpots(b, pos.x, pos.y, jumpingSpots));
        return validSpots;
    }

    public ArrayList<Position> getAdjacentSpots(Board b) {
        ArrayList<Position> adjacentSpots = new ArrayList<Position> ();
        adjacentSpots.add(new Position(pos.x-2, pos.y));
        adjacentSpots.add(new Position(pos.x+2, pos.y));
        adjacentSpots.add(new Position(pos.x-1, pos.y-1));
        adjacentSpots.add(new Position(pos.x-1, pos.y+1));
        adjacentSpots.add(new Position(pos.x+1, pos.y-1));
        adjacentSpots.add(new Position(pos.x+1, pos.y+1));
        for (Position p : adjacentSpots) {
            if (!b.isEmptySpotOnBoard(p)) {
                adjacentSpots.remove(p);
            }
        } return adjacentSpots;
    }

    public ArrayList<Position> getJumpingSpots(Board b, int x, int y, ArrayList<Position> jumpingSpots) {
        jumpingSpots.add(new Position(x-4, y));
        jumpingSpots.add(new Position(x+4, y));
        jumpingSpots.add(new Position(x-2, y-2));
        jumpingSpots.add(new Position(x-2, y+2));
        jumpingSpots.add(new Position(x+2, y-2));
        jumpingSpots.add(new Position(x+2, y+2));

        for (Position p : jumpingSpots) {
            if (!b.isEmptySpotOnBoard(p) || (jumpingSpots.contains(p))) {
                jumpingSpots.remove(p);
            }
            getJumpingSpots(b, p.x, p.y, jumpingSpots);
        }
        return jumpingSpots;
    }

    public void moveOver(Board b) {
        Position startingPos = pos;

        Position nextSpot = UserInput.askUserForMoveCoords();

        if (getValidSpots(b).contains(nextSpot)) {
            setPos(nextSpot); 
            Marble[][] board = b.getBoardArray();
            board[nextSpot.x][nextSpot.y] = this;
            board[startingPos.x][startingPos.y] = null;
        }
        else {
            System.out.println("Please select another spot.");
            moveOver(b);
        }
    }
}
