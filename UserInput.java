import java.util.Scanner;

public class UserInput {
    public static Position askUserForMarbleCoords() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the x coordinate of the piece you would like to move");
        int xCoord = myScanner.nextInt();
        System.out.println("Enter the y coordinate of the piece you would like to move");
        int yCoord = myScanner.nextInt();
        myScanner.close();

        return new Position(xCoord, yCoord);
    }
}