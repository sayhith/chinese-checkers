package main;

import java.util.Scanner;

public class UserInput {
    private static Scanner myScanner = new Scanner(System.in);

    public static Position askUserForMarbleCoords() {
        String input;
        int xCoord;
        int yCoord;

        while (true) {
            try {
                System.out.println("Enter the x and y coordinates of the piece you would like to move, separated by a space.");
                input = myScanner.nextLine();

                if (input.split(" ").length == 1) {
                    throw new InvalidInputException("Only one value given");
                }

                xCoord = Integer.parseInt(input.split(" ")[0]);
                yCoord = Integer.parseInt(input.split(" ")[1]);

                break;
            }

            catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter numerical input only.");
            }

            catch(InvalidInputException e) {
                System.out.println("Please provide a valid coordinate.");
            }
        }   
        
        while (!(xCoord >= 0 && xCoord <= 24)) {
            System.out.println("Invalid x-coordinate. Please enter a number between 0 and 24.");
            input = myScanner.nextLine();
            xCoord = Integer.parseInt(input.split(" ")[0]);
        }

        while (!(yCoord >= 0 && yCoord <= 16)) {
            System.out.println("Invalid y-coordinate. Please enter a number between 0 and 16.");
            input = myScanner.nextLine();
            String[] inputArray = input.split(" ");
            if (inputArray.length == 1) {
                yCoord = Integer.parseInt(inputArray[0]);
            }
            else {
                yCoord = Integer.parseInt(inputArray[1]);
            }
        }
        return new Position(yCoord, xCoord);
    }

    public static Position askUserForMoveCoords() {
        System.out.println("Enter the x and y coordinates for your move, separated by a space.");
        String input = myScanner.nextLine();
        int newXCoord = Integer.parseInt(input.split(" ")[0]);
        int newYCoord = Integer.parseInt(input.split(" ")[1]);
        return new Position(newYCoord, newXCoord);
    }
}