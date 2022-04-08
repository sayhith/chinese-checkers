## Feb 9, 2022

### Deciding how to represent the board:

- Considered using an array of arrays (matrix)
  - Pros: Easy to implement and work with, easy indexing 
  - Cons: A Chinese checkers board is offset and irregular which makes it harder to picture with a 2D array 
- Found cube coordinates as a possible alternative
  - Pros: Easier to picture visually
  - Cons: Harder to implement and access
- Found an example of an array being used that was easy to understand and visualize: https://github.com/HarryZalessky/Chinese-Checkers
- This represents the offset using empty spaces between horizontal points 
- Decided to go with this 2D array representation because it is easy to visualize but also easy to implement and access, which will be important because Marbles will be changing positions a lot therefore we need an easy way to index positions on the board 
 

### Attempting to implement a Pair in Marble class:

- Decided to change Marble class attributes - combine x and y integer attributes into a tuple
- Ran into trouble trying to implement 
- javafx package needed to do this but unable to import successfully 
- Tried "java clean" command to clear Java language server workspace (suggested on stackoverflow) - this did not work 
- Quick search did not reveal any more relevant solutions
- Found out that importing javafx may be more difficult to do on Vscode
- Decided to try using IntelliJ instead of Vscode
- Same issue persisted with trying to import javafx
- Decided not to spend more time on this issue and just stick with two separate int attributes for x and y coords

## Feb 10, 2022

### Implementing Move methods 
- Started implementing moveOver() method which moves a marble over to an adjacent spot
- Started helper method getValidSpots() which will return a list of "Positions" that are valid moves
- getValidSpots() method needs to return a coordinate (tuple) which is not possible currently or two values and Java methods can only return one value
- Created a new "Position" class with two int attributes for x and y coordinates to overcome this issue
- Started addition helper methods for this: 
  - getAdjacentSpots(): in the Marble class bc this fn only needs to know the pos of starting marble and not the rest of the board - returns an ArrayList of the spots directly adjacent to marble m
  - isUnoccupied(): in Board class - returns a boolean indicating if the Position given is occupied by a piece 
  - isOnBoard(): in Board class - returns a boolean indicating if a given Position is on the game board  
  - initBoard(): in Board class - initializes the game board to its starting state (each point of the star filled with marbles)

  ## March 1, 2022

  - Decided to change structure so that everything pertaining to the position of a marble is contained in the Board class (ie. the Board knows where the Marbles are but the Marbles do not)
  - Problem: now the Marble doesn't know its own coordinates so the getAdjacentSpots method has to search the matrix to find a specific instance of marble (since each piece on the board is its own instance)
  - Changed it back so now the Marble has an attribute for its coordinates 
  
  ## March 2, 2022

  - Completed isOnBoard() method and moved it to the Postiion class since the method does not need any information about the state of the board 
  - Created isEven() and isOdd() helper methods 
  - **** ASK ERIK ABOUT THE ISONBOARD METHOD PLACEMENT ****

  ## March 5, 2022
- Print to console functions completed 
- Learned that you cannot add things to an array and you have to predetermine size 
- Used a nested for-loop to iterate over an array of arrays and create another array of arrays of string
- Used String.join() to append strings in a list of string to print board 

## March 21, 2022
- Implemented moveOver() method in Marble class - this does the actually updating of the marble's position and the Board
- Eventually users will be able to move pieces by clicking on them and the desired spot when GUI implemented 
- For now user has to input position of piece they want to move 
- Imported Scanner class to receive user input
- User will be prompted to input two integers sequentially for X and Y of piece they want to move 
- Created the selectPiece() method in Board class to receive this input and then pass on to moveOver() method 
- selectPiece() is in the Board class and not Marble class because before it runs there is no Marble object for it to work on 
- moveOver() method prompts the user for position of the next spot (CHANGE THIS so that before user puts in the ints the console prints out the list of valid positions to move to)
- if given spot is a valid spot, it updates the position of the Marble and updates the Board
- To update Board, had to override equals() so I can compare the values of two positions (to check if the user given position is in the list of validPositions) 

## March 23, 2022
- Deleted selectPiece() and created a askUserForMarbleCoords() in new UserInput class which will contain everything related to user interaction 
- askUserForMarbleCoords() returns a Position 
- Can choose the desired marble by indexing at that position 
- main() now calls askUserForMarbleCoords() and moveOver() instead of selectPiece()

- Created checkIfWon() to determine if a game is over 
- checkIfWon() runs after every turn instead of after a certain number of turns because it's easier to code and understand 
  - Future improvement: Start running checkIfWon() only after the minimum number of moves to win have been played 
- This method determines if the recently played marble and all marbles of its colour are in their "endzone" to see if that player has won the game 
- First need to filter out all the marbles of the same colour
- Then check if all the positions of the marbles match with a position in their endzone 
- I didn't have a list of the endzone positions so I modified the createUp/DownTriangle methods to also create a matrix of endzone Positions
- Chose to put them in a matrix instead of having six different lists for each colour 
- Matrix contains endzone Positions and the first index tells you the colour 
- Used a for loop to generate the marbles and fill in the endzone matrix 
- Added "oppColour" attribute to Marble to keep track of its opponent's colour so we know which endzone it needs to be in 
## March 24, 2022
- Pulled all Scanner function out of moveOver() and put it into a new method called askUserForMoveCoords() in UserInput
- Made Scanner a static property of the UserInput class so there is only one for the duration of the program 
- Did not include a Scanner.close() statement because the lifetime of the program is one game and we need the Scanner for the entire game 
- Program will end when game is over and Scanner will close too

- Put a do-while loop in main() that checks if the game has been won at the end of each cycle so that you can make more than one move 

- Added switch statement to drawBoard() to give marbles of each colour a different symbol 

- Board did not print - kept getting a null pointer exception
  - Found out that all arrays had rows and columns mixed up so instead of boardArray[25][17] should have been boardArray[17][25]

- Learned about "continue" statement which ends the current iteration and continues to the next iteration (all code after continue is not executed)

## March 30, 2022
- Modified moveOver() method to allow for jumping over pieces 
- Added getJumpingSpots() to provide a list of positions that a piece can move to if they jump over other pieces
- getJumpingSpots() is recursive 
- getAdjacentSpots() and getJumpingSpots() only return valid positions now because they check and remove all invalid positions before returning
- created isEmptySpotOnBoard() to check if a spot is both unoccupied and on the board in one method by combining the two other helper methods 

## April 1, 2022
- JUnit 4 testing implemented
- Tests written for Board and Marble (incomplete)

- Restructured project directory into packages - fixed import issue and will make scaling up easier 

- Concurrent modification error (remove() in `get______Spots()` to remove invalid Positions)
- Instead of removing the invalid spots, made a new list and added the valid spots outside the for loop 

- Recursion error - kept iterating over invalid spots and never ending 
- Moved the recursive call into for loop 

- Realized that there is nothing to stop a marble from moving back into the spot it just vacated resulting in a never ending loop

## April 2, 2022
- Fixed recursive function `getJumpingSpots()` by preventing it from recursing over Positions it has already considered
- This allows the method to terminate once all spots have been considered once

- The method still included the initial Position (where the marble is currently) as a valid spot
- Decided not to stop `getJumpingSpots()` from including the first position because it is easy to remove after the method has ended and trying to deal with it in the method would make it more complicated 

- Fixed bug in `isSpotUnoccupied()` in Board 
- Was indexing incorrectly and throwing OutOfBounds exception because boardArray is indexed y, x instead of x, y 

## April 4, 2022
- Switched all the x and y to account for the fact that our arrays index (y,x) instead of (x,y)
- User is still asked for the x coordinate first but all the internal coordinates are (y,x)

## April 6, 2022
- Implemented Liskov Substitution Principle and changed all ArrayList<> declarations to List<>
- Wrote `listOfPosToString` which takes a list of Positions and returns a list of their coordinates as Strings
- Used above method to print out a list of possible move coordinates before each turn 

## April 7, 2022
- Added `moveManually()` to manually move a marble to make testing easier 
- Fixed bug in `getAdjacentSpots()` (switch x's and y's)
- Added more tests to MarbleTest