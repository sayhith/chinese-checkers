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
- Decided to go with this 2D array representation because it is easy to visualize but also easy to implement and access which will be important because Marbles will be changing positions a lot therefore we need an easy way to index positions on the board 
 

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

- 