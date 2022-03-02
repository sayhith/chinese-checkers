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

  ###
  - Decided to change structure so that everything pertaining to the position of a marble is contained in the Board class (ie. the Board knows where the Marbles are but the Marbles do not)
  - Problem: now the Marble doesn't know its own coordinates so the getAdjacentSpots method has to search the matrix to find a specific instance of marble (since each piece on the board is its own instance)
  - Changed it back so now the Marble has an attribute for its coordinates 
  
  ## March 2, 2022

  - Completed isOnBoard() method and moved it to the Postiion class since the method does not need any information about the state of the board 
  - Created isEven() and isOdd() helper methods 
  - **** ASK ERIK ABOUT THE ISONBOARD METHOD PLACEMENT ****



