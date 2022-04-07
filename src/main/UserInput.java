package main;

import java.util.Scanner;

public class UserInput {
    private static Scanner myScanner = new Scanner(System.in);

    public static Position askUserForMarbleCoords() {
        System.out.println("Enter the x coordinate of the piece you would like to move");
        int xCoord = myScanner.nextInt();
        System.out.println("Enter the y coordinate of the piece you would like to move");
        int yCoord = myScanner.nextInt();

        return new Position(yCoord, xCoord);
    }

    public static Position askUserForMoveCoords() {
        System.out.println("Enter the x coordinate for your move.");
        int newXCoord = myScanner.nextInt();
        System.out.println("Enter the y coordinate for your move");
        int newYCoord = myScanner.nextInt();

        return new Position(newYCoord, newXCoord);
    }
}