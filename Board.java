import java.util.ArrayList;
import java.util.Arrays;


/**
 * Board 
 */
public class Board {
    public Marble[][] boardArray;

    public Board() {
        this.boardArray = new Marble[25][25];
    }

    public Marble[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(Marble[][] boardArray) {
        this.boardArray = boardArray;
    }

    public void initBoard() {
        //create board
        //create marbles
        //place marbles on board 
        //Board gameBoard = new Board();
        fillUpTriangles();
        fillDownTriangles();
    }

    private void fillUpTriangles() {
        ArrayList<Position> startingPositions = new ArrayList<Position>();
        startingPositions.add(new Position(9, 3));
        startingPositions.add(new Position(0, 12));
        startingPositions.add(new Position(18, 12));

        for (Position p : startingPositions) {
            this.getBoardArray()[p.x][p.y] = new Marble(1, new Position(p.x, p.y));
            this.getBoardArray()[p.x + 2][p.y] = new Marble(1, new Position(p.x + 2, p.y));
            this.getBoardArray()[p.x + 4][p.y] = new Marble(1, new Position(p.x + 4, p.y));
            this.getBoardArray()[p.x + 6][p.y] = new Marble(1, new Position(p.x + 6, p.y));
            this.getBoardArray()[p.x + 1][p.y - 1] = new Marble(1, new Position(p.x + 1, p.y - 1));
            this.getBoardArray()[p.x + 3][p.y - 1] = new Marble(1, new Position(p.x + 3, p.y - 1));
            this.getBoardArray()[p.x + 5][p.y - 1] = new Marble(1, new Position(p.x + 5, p.y - 1));
            this.getBoardArray()[p.x + 2][p.y - 2] = new Marble(1, new Position(p.x + 2, p.y - 2));
            this.getBoardArray()[p.x + 4][p.y - 2] = new Marble(1, new Position(p.x + 4, p.y - 2));
            this.getBoardArray()[p.x + 3][p.y - 3] = new Marble(1, new Position(p.x + 3, p.y - 3));
        }
    }

    private void fillDownTriangles() {
        ArrayList<Position> startingPositions = new ArrayList<Position>();
        startingPositions.add(new Position(0, 4));
        startingPositions.add(new Position(18, 4));
        startingPositions.add(new Position(9, 13));

        for (Position p : startingPositions) {
            this.getBoardArray()[p.x][p.y] = new Marble(1, new Position(p.x, p.y));
            this.getBoardArray()[p.x + 2][p.y] = new Marble(1, new Position(p.x + 2, p.y));
            this.getBoardArray()[p.x + 4][p.y] = new Marble(1, new Position(p.x + 4, p.y));
            this.getBoardArray()[p.x + 6][p.y] = new Marble(1, new Position(p.x + 6, p.y));
            this.getBoardArray()[p.x + 1][p.y + 1] = new Marble(1, new Position(p.x + 1, p.y + 1));
            this.getBoardArray()[p.x + 3][p.y + 1] = new Marble(1, new Position(p.x + 3, p.y + 1));
            this.getBoardArray()[p.x + 5][p.y + 1] = new Marble(1, new Position(p.x + 5, p.y + 1));
            this.getBoardArray()[p.x + 2][p.y + 2] = new Marble(1, new Position(p.x + 2, p.y + 2));
            this.getBoardArray()[p.x + 4][p.y + 2] = new Marble(1, new Position(p.x + 4, p.y + 2));
            this.getBoardArray()[p.x + 3][p.y + 3] = new Marble(1, new Position(p.x + 3, p.y + 3));
        }
    }

    private boolean isUnoccupied(Position p) {
        return (boardArray[p.x][p.y] == null);
    }

    public ArrayList<Position> getValidSpots(Marble m) {
        ArrayList<Position> validSpots = new ArrayList<Position> ();
        for (Position p : m.getAdjacentSpots()) {
            if (isUnoccupied(p) && p.isOnBoard()) {
                validSpots.add(p);
            }
        } return validSpots;
    }

    public void moveOver(Marble m) {
        ArrayList<Position> openSpots = getValidSpots(m);


    }

    public void jump() {
        //TODO
    }

    // public String stringify(Marble[] lom) {
    //     String s = "";
    //     for (Marble m : lom) {
    //         if (m == null) {
    //             s.concat("." + '\n');
    //             //return ".";
    //             //System.out.print("." + '\n');
    //         } else {
    //             s.concat("x" + '\n');
    //             //return "x";
    //             //System.out.print("x" + '\n');
    //         }
    //     }
    //     return s;
    // } 

    public String[][] stringify2() {
        String[][] stringArray = new String[17][25];
        for (int i = 0; i < 17; i++) {
            for (int j = 0 ; j < 25 ; j++) {
                if (this.boardArray[j][i] == null){
                    stringArray[i][j] = ".";
                } else {
                    stringArray[i][j] = "x";
                }
            }
        }
        return stringArray;
        // //for (int i = 0 ; i < 25; i++) {
        //     for (Marble m : lom) {
        //         if (m == null) {
        //             los.add("." + '\n');
        //         }
        //         else {
        //             los.add("x" + '\n');
        //         }
        //      } return los;
    }

    // public void printList(String[] los) {
    //     for (String s : los) {
    //         System.out.println(s);
    //     }
    // }

    public void printBoard(String[][] stringArray) {
        for (String[] los : stringArray) {
            System.out.println(String.join(" ", los));
        }
    }
}



