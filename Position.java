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

    public boolean isOnBoard() {
        return ((this.x == 12) && (this.y == 0 || this.y == 16)) 
            || ((this.x == 11 || this.x == 13) && (this.y == 1 || this.y == 15))
            || ((this.x == 10 || this.x == 12 || this.x == 14) && (this.y == 2 || this.y == 14)) 
            || ((this.x == 9 || this.x == 11 || this.x == 13 || this.x == 15) && (this.y == 3 || this.y == 13)) 
            || ((this.x >= 0) && (this.x <= 24) && isEven(this.x) && (this.y == 4 || this.y == 12)) 
            || ((this.x >= 0) && (this.x <= 24) && isOdd(this.x) && (this.y == 5 || this.y == 11))
            || ((this.x >= 2) && (this.x <= 22) && isEven(this.x) && (this.y == 6 || this.y == 10))
            || ((this.x >= 3) && (this.x <= 21) && isOdd(this.x) && (this.y == 7 || this.y == 9)) 
            || ((this.x >= 4) && (this.x <= 20) && isEven(this.x) && (this.y == 8));
    }

    public boolean isEven(int i) {
        return (i % 2 == 0);
    } 

    public boolean isOdd(int i) {
        return (i % 2 == 1);
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
