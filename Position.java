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
}
