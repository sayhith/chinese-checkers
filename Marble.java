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

    public ArrayList<Position> getAdjacentSpots() {
        ArrayList<Position> adjacentSpots = new ArrayList<Position> ();
        adjacentSpots.add(new Position(this.pos.x-2, this.pos.y));
        adjacentSpots.add(new Position(this.pos.x+2, this.pos.y));
        adjacentSpots.add(new Position(this.pos.x-1, this.pos.y-1));
        adjacentSpots.add(new Position(this.pos.x-1, this.pos.y+1));
        adjacentSpots.add(new Position(this.pos.x+1, this.pos.y-1));
        adjacentSpots.add(new Position(this.pos.x+1, this.pos.y+1));
        return adjacentSpots;
    }

    public ArrayList<Position> getValidSpots(Board b) {
        ArrayList<Position> validSpots = new ArrayList<Position> ();
        for (Position p : this.getAdjacentSpots()) {
            if (b.isUnoccupied(p) && p.isOnBoard()) {
                validSpots.add(p);
            }
        } return validSpots;
    }

    public void moveOver(Board b) {
        Position startingPos = this.pos;
        Position nextSpot = UserInput.askUserForMoveCoords();

        ArrayList<Position> possibleSpots = this.getValidSpots(b);
        if (possibleSpots.contains(nextSpot)) {
            this.setPos(nextSpot); 
            Marble[][] board = b.getBoardArray();
            board[nextSpot.x][nextSpot.y] = this;
            board[startingPos.x][startingPos.y] = null;
        }
    }
}

