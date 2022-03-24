import java.util.ArrayList;


/**
 * Board 
 */
public class Board {

    public Marble[][] boardArray;
    public Position[][] endZones;

    private ArrayList<Integer> colourNums = new ArrayList<Integer>();

    public Board() {
        this.boardArray = new Marble[25][25];
        this.endZones = new Position[6][10];

        for (int i = 0; i < 6; i++) {
            colourNums.add(i);
        }
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
        ArrayList<Position> startingPositions = new ArrayList<Position>();
        startingPositions.add(new Position(9, 3));
        startingPositions.add(new Position(0, 12));
        startingPositions.add(new Position(18, 12));

        ArrayList<Integer> colourNums = new ArrayList<Integer>();
        colourNums.add(0);
        colourNums.add(4);
        colourNums.add(2);

        for (int i = 0; i < 3; i++) {
            for (Position p : startingPositions) {
            this.getBoardArray()[p.x][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y));
            this.getBoardArray()[p.x + 2][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 2, p.y));
            this.getBoardArray()[p.x + 4][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 4, p.y));
            this.getBoardArray()[p.x + 6][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 6, p.y));
            this.getBoardArray()[p.x + 1][p.y - 1] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 1, p.y - 1));
            this.getBoardArray()[p.x + 3][p.y - 1] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 3, p.y - 1));
            this.getBoardArray()[p.x + 5][p.y - 1] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 5, p.y - 1));
            this.getBoardArray()[p.x + 2][p.y - 2] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 2, p.y - 2));
            this.getBoardArray()[p.x + 4][p.y - 2] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 4, p.y - 2));
            this.getBoardArray()[p.x + 3][p.y - 3] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 3, p.y - 3));

            endZones[colourNums.get(i)][0] = new Position(p.x, p.y);
            endZones[colourNums.get(i)][1] = new Position(p.x + 2, p.y);
            endZones[colourNums.get(i)][2] = new Position(p.x + 4, p.y);
            endZones[colourNums.get(i)][3] = new Position(p.x + 6, p.y);
            endZones[colourNums.get(i)][4] = new Position(p.x + 1, p.y - 1);
            endZones[colourNums.get(i)][5] = new Position(p.x + 3, p.y - 1);
            endZones[colourNums.get(i)][6] = new Position(p.x + 5, p.y - 1);
            endZones[colourNums.get(i)][7] = new Position(p.x + 2, p.y - 2);
            endZones[colourNums.get(i)][8] = new Position(p.x + 4, p.y - 2);
            endZones[colourNums.get(i)][9] = new Position(p.x + 3, p.y - 3);
            }
        }
    }

    private void createDownTriangles() {
        ArrayList<Position> startingPositions = new ArrayList<Position>();
        startingPositions.add(new Position(0, 4));
        startingPositions.add(new Position(18, 4));
        startingPositions.add(new Position(9, 13));

        ArrayList<Integer> colourNums = new ArrayList<Integer>();
        colourNums.add(5);
        colourNums.add(1);
        colourNums.add(3);

        for (int i = 3; i < 6; i++) {
            for (Position p : startingPositions) {
                this.getBoardArray()[p.x][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x, p.y));
                this.getBoardArray()[p.x + 2][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 2, p.y));
                this.getBoardArray()[p.x + 4][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 4, p.y));
                this.getBoardArray()[p.x + 6][p.y] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 6, p.y));
                this.getBoardArray()[p.x + 1][p.y + 1] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 1, p.y + 1));
                this.getBoardArray()[p.x + 3][p.y + 1] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 3, p.y + 1));
                this.getBoardArray()[p.x + 5][p.y + 1] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 5, p.y + 1));
                this.getBoardArray()[p.x + 2][p.y + 2] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 2, p.y + 2));
                this.getBoardArray()[p.x + 4][p.y + 2] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 4, p.y + 2));
                this.getBoardArray()[p.x + 3][p.y + 3] = new Marble(colourNums.get(i), colourNums.get((i + 3) % 6), new Position(p.x + 3, p.y + 3));

                endZones[colourNums.get(i)][0] = new Position(p.x, p.y);
                endZones[colourNums.get(i)][1] = new Position(p.x + 2, p.y);
                endZones[colourNums.get(i)][2] = new Position(p.x + 4, p.y);
                endZones[colourNums.get(i)][3] = new Position(p.x + 6, p.y);
                endZones[colourNums.get(i)][4] = new Position(p.x + 1, p.y + 1);
                endZones[colourNums.get(i)][5] = new Position(p.x + 3, p.y + 1);
                endZones[colourNums.get(i)][6] = new Position(p.x + 5, p.y + 1);
                endZones[colourNums.get(i)][7] = new Position(p.x + 2, p.y + 2);
                endZones[colourNums.get(i)][8] = new Position(p.x + 4, p.y + 2);
                endZones[colourNums.get(i)][9] = new Position(p.x + 3, p.y + 3);
            }
        }   
    }

    public boolean isUnoccupied(Position p) {
        return (boardArray[p.x][p.y] == null);
    }

    public void jump() {
        //TODO
    }

    public String[][] drawBoard() {
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
    }

    public void printBoard(String[][] stringArray) {
        for (String[] los : stringArray) {
            System.out.println(String.join(" ", los));
        }
    }
}





