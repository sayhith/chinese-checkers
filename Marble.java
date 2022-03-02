import java.util.ArrayList;

/**
 * Marble 
 */
 public class Marble {
    int colour;
    Position pos;

    public Marble(int colour, Position pos) {
        this.colour = colour;
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

}

