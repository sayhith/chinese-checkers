public class Position {
    int x;
    int y; 

    public Position(int x, int y) {
    this.x = x;
    this.y = y;
    } 

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
        return (x == p.x) && (y == p.y);
    }
}
