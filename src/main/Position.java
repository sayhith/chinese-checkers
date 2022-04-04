package main;

public class Position {
    int y;
    int x; 

    public Position(int y, int x) {
    this.y = y;
    this.x = x;
    } 

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Position or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Position)) {
            return false;
        }
         
        // typecast o to Position so that we can compare data members
        Position p = (Position) o;
         
        // Compare the data members and return accordingly
        return (y == p.y) && (x == p.x);
    }
}
