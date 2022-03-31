import java.util.ArrayList;


/**
 * Board 
 */
public class Board {

    public Marble[][] boardArray;
    public Position[][] endZones;
    private ArrayList<Position> startingPositions;
    private ArrayList<Integer> colourNums;

    public Board() {
        this.boardArray = new Marble[17][25];
        this.endZones = new Position[6][10];
        this.startingPositions = new ArrayList<Position>();

        startingPositions.add(new Position(3, 9));
        startingPositions.add(new Position(12, 0));
        startingPositions.add(new Position(12, 18));
        startingPositions.add(new Position(4, 0));
        startingPositions.add(new Position(4, 18));
        startingPositions.add(new Position(13, 9));

        this.colourNums = new ArrayList<Integer>();

        colourNums.add(0);
        colourNums.add(4);
        colourNums.add(2);
        colourNums.add(5);
        colourNums.add(1);
        colourNums.add(3);
    }

    public Marble[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(Marble[][] boardArray) {
        this.boardArray = boardArray;
    }

    public Position[][] getEndZones() {
        return endZones;
    }

    public void setEndZones(Position[][] endZones) {
        this.endZones = endZones;
    }

    public void initBoard() {
        //create board
        //create marbles
        //place marbles on board 
        //Board gameBoard = new Board();
        createUpTriangles();
        createDownTriangles();
    }

    private void createUpTriangles() {
        
        for (int i = 0; i < 3; i++) {
            Position p = startingPositions.get(i);
            getBoardArray()[p.x][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y));
            getBoardArray()[p.x][p.y + 2] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y + 2));
            getBoardArray()[p.x][p.y + 4] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y + 4));
            getBoardArray()[p.x][p.y + 6] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y + 6));
            getBoardArray()[p.x - 1][p.y + 1] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x - 1, p.y + 1));
            getBoardArray()[p.x - 1][p.y + 3] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x - 1, p.y + 3));
            getBoardArray()[p.x - 1][p.y + 5] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x - 1, p.y + 5));
            getBoardArray()[p.x - 2][p.y + 2] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x - 2, p.y + 2));
            getBoardArray()[p.x - 2][p.y + 4] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x - 2, p.y + 4));
            getBoardArray()[p.x - 3][p.y + 3] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x - 3, p.y + 3));

            endZones[colourNums.get(i)][0] = new Position(p.x, p.y);
            endZones[colourNums.get(i)][1] = new Position(p.x, p.y + 2);
            endZones[colourNums.get(i)][2] = new Position(p.x, p.y + 4);
            endZones[colourNums.get(i)][3] = new Position(p.x, p.y + 6);
            endZones[colourNums.get(i)][4] = new Position(p.x - 1, p.y + 1);
            endZones[colourNums.get(i)][5] = new Position(p.x - 1, p.y + 3);
            endZones[colourNums.get(i)][6] = new Position(p.x - 1, p.y + 5);
            endZones[colourNums.get(i)][7] = new Position(p.x - 2, p.y + 2);
            endZones[colourNums.get(i)][8] = new Position(p.x - 2, p.y + 4);
            endZones[colourNums.get(i)][9] = new Position(p.x - 3, p.y + 3);
        }
    }

    private void createDownTriangles() {

        for (int i = 3; i < 6; i++) {
            Position p = startingPositions.get(i);
            getBoardArray()[p.x][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y));
            getBoardArray()[p.x][p.y + 2] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y + 2));
            getBoardArray()[p.x][p.y + 4] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y + 4));
            getBoardArray()[p.x][p.y + 6] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y + 6));
            getBoardArray()[p.x + 1][p.y + 1] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 1, p.y + 1));
            getBoardArray()[p.x + 1][p.y + 3] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 1, p.y + 3));
            getBoardArray()[p.x + 1][p.y + 5] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 1, p.y + 5));
            getBoardArray()[p.x + 2][p.y + 2] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 2, p.y + 2));
            getBoardArray()[p.x + 2][p.y + 4] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 2, p.y + 4));
            getBoardArray()[p.x + 3][p.y + 3] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 3, p.y + 3));

            endZones[colourNums.get(i)][0] = new Position(p.x, p.y);
            endZones[colourNums.get(i)][1] = new Position(p.x, p.y + 2);
            endZones[colourNums.get(i)][2] = new Position(p.x, p.y + 4);
            endZones[colourNums.get(i)][3] = new Position(p.x, p.y + 6);
            endZones[colourNums.get(i)][4] = new Position(p.x + 1, p.y + 1);
            endZones[colourNums.get(i)][5] = new Position(p.x + 1, p.y + 3);
            endZones[colourNums.get(i)][6] = new Position(p.x + 1, p.y + 5);
            endZones[colourNums.get(i)][7] = new Position(p.x + 2, p.y + 2);
            endZones[colourNums.get(i)][8] = new Position(p.x + 2, p.y + 4);
            endZones[colourNums.get(i)][9] = new Position(p.x + 3, p.y + 3);
        }
    }  

    public String[][] drawBoard() {
        String[][] stringArray = new String[17][25];
        for (int i = 0; i < 17; i++) {
            for (int j = 0 ; j < 25 ; j++) {
                if (boardArray[i][j] == null){
                    stringArray[i][j] = ".";
                    continue;
                }

                switch(boardArray[i][j].colour) {
                    case 0:
                        stringArray[i][j] = "x";
                        break;
                    case 1:
                        stringArray[i][j] = "o";
                        break;
                    case 2:
                        stringArray[i][j] = "@";
                        break;
                    case 3:
                        stringArray[i][j] = "#";
                        break;
                    case 4:
                        stringArray[i][j] = "%";
                        break;
                    case 5:
                        stringArray[i][j] = "?";
                        break;
                    default:
                        stringArray[i][j] = ".";
                        break;
                }
            }
        }
        return stringArray;
    }

    public void printBoard(String[][] stringArray) {
        for (String[] los : stringArray) {
            System.out.println(String.join(" ", los));
        }
    }

    public boolean isEmptySpotOnBoard(Position p) {
        return (isOnBoard(p) && isUnoccupied(p));
    }

    public boolean isOnBoard(Position p) {
        return ((p.x == 12) && (p.y == 0 || p.y == 16)) 
            || ((p.x == 11 || p.x == 13) && (p.y == 1 || p.y == 15))
            || ((p.x == 10 || p.x == 12 || p.x == 14) && (p.y == 2 || p.y == 14)) 
            || ((p.x == 9 || p.x == 11 || p.x == 13 || p.x == 15) && (p.y == 3 || p.y == 13)) 
            || ((p.x >= 0) && (p.x <= 24) && isEven(p.x) && (p.y == 4 || p.y == 12)) 
            || ((p.x >= 0) && (p.x <= 24) && isOdd(p.x) && (p.y == 5 || p.y == 11))
            || ((p.x >= 2) && (p.x <= 22) && isEven(p.x) && (p.y == 6 || p.y == 10))
            || ((p.x >= 3) && (p.x <= 21) && isOdd(p.x) && (p.y == 7 || p.y == 9)) 
            || ((p.x >= 4) && (p.x <= 20) && isEven(p.x) && (p.y == 8));
    }

    public boolean isUnoccupied(Position p) {
        return (boardArray[p.x][p.y] == null);
    }

    private boolean isEven(int i) {
        return (i % 2 == 0);
    } 

    private boolean isOdd(int i) {
        return (i % 2 == 1);
    }
}




