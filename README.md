# Scrabble

A simple version of Scrabble written in Java. 

### Rules

In short, Scrabble is about placing neighbouring letters to make words. For each turn, the player must choose one of three options. They can pass the turn, exchange letters with the bag, or play tiles to make a word.

#### Passing

Passing allows the player to forfeit their turn and score no points. Passing is usually done when the bag has no more letters, and the player cannot make a valid word on the board with their current letters.

#### Exchanging

Exchanging allows the player to exchange one or more tiles with the bag, for an equal number of tiles. The player will not be able to score any points and forfeits their opportunity to play a word for that turn. The player may not exchange if there are less than seven tiles remaining in the bag. Exchanging is usually done when the player cannot make any valid words on the board with their current letters, or if the player is close to a high value word but is missing one or more letters.

#### Playing

Playing is how a player scores points and win. To score points, the player must make a word on the  board. To make a word, the player must place one to seven letters to make a word. The player may not place any letters if they do not contribute to making a word in the same turn. For the first turn of the game, the player must play at least two letters to form a valid word. After, the player may place a single letter as long as it forms a valid word.

Once the player has played a valid word, they may retrieve the number of letters used from the bag, such that they have seven letters. If the bag does not have enough letters such that the player cannot obtain seven letters on their rack, they may empty the bag and take the remaining letters. Create words out of the letters given to you in your hand. Words have different values depending on the number and type of letters in them.

### How To Play

Start the application by executing the Jar file, or by using an IDE to build and execute the source code directly. When the window
is created, you are free to play. There are several buttons on the right. The pass button allows the user to pass a turn. The quit
button allows the user to quit the application. The finish button allows the user to finish there turn and to check if the word
placed was valid. Finally, the reset button allows the user 

### Implementation

##### [Board](src/Board.java)

Represents all of the cells on the board. By storing an old one and a new one, we can reset to the old one whenever the player wishes
to undo, or makes an invalid set of moves. The board is integral to representing the current state of the game.

##### [BoardCell](src/BoardCell.java)

Represents a cell within the board. A cell consists of a letter, along with a few getter and setter methods for setting the letter.

##### [Config](src/Config.java)

Represents the configuration for the game. Provides several global variables for manipulating the style of the game, the values of
the letters, the number of letters, the website to fetch the words from, and more.

##### [Controller](src/Controller.java)

Represents the controller component of the MVC. Attaches itself to a view and model and sets callbacks for the view which notify
the model of any changes.

##### [Game](src/Game.java)

Ties together multiple components of the application. Uses the board, the letter chain, the word bank, the players, and more to
provide an interface for placing, removing, passing, quitting, resetting, and more for the application.

##### [LetterBag](src/LetterBag.java)

Represents the bag or the leftover letters for the game. Can be used to populate the player hands after placing a word.

##### [LetterCell](src/LetterCell.java)

Similar to a board cell, however it now contains a position. Can be used to store the states of the placed letters.

##### [LetterChain](src/LetterChain.java)

Represents the word that the player is attempting to create. Holds several letter cells, and on demand, will attempt to compute
the score acheived placing the word.

##### [Main](src/Main.java)

Initializes several components of the application, attaches them, and starts them.

##### [Model](src/Model.java)

Represents the model component of the MVC. Attaches itself to a view, and upon being notified by the controller, updates the view
and the game.

##### [PanelAction](src/PanelAction.java)

Represents the action panel of the view. Provides several buttons for passing, quitting, resetting, and finishing along with
the associated callbacks.

##### [PanelBoard](src/PanelBoard.java)

Represents the board panel of the view. Contains many buttons/cells which can be used to specify which cell was clicked, and
provides a callback for when a specific cell is clicked.

##### [PanelBoardCell](src/PanelBoardCell.java)

Represents a button/cell within the board panel. Provides a method for setting the letter in the cell and notifies the board panel
when it is pressed.

##### [PanelBoardListener](src/PanelBoardListener.java)

Similar to a common action listener, however it specializes the callback method with position parameters.

##### [PanelHand](src/PanelHand.java)

Represents the hand panel of the view. Contains several buttons/cells which can be used to specify which cell was clicked, and
provides a callback for when a specific cell is clicked.

##### [PanelHandCell](src/PanelHandCell.java)

Represents a button/cell within the hand panel. Provides a method for setting the letter in the cell and notifies the hand panel
when it is pressed.

##### [PanelHandListener](src/PanelHandListener.java)

Similar to a common action listener, however it specializes the callback method with an index parameter.

##### [PanelOther](src/PanelOther.java)

Represents the other/misc panel of the view. Provides various information about the game such as the current turn.

##### [PanelScore](src/PanelScore.java)

Represents the score panel of the view. Acts as a scoreboard that contains the players and the associated scores.

##### [Player](src/Player.java)

Represents a player within the game. Both the user player and the bot player inherit from it to provide a polymorphic 
player type that can make moves.

##### [PlayerBot](src/PlayerBot.java)

To be implemented in Milestone 3.

##### [PlayerHand](src/PlayerHand.java)

Represents the tiles that the player holds. Provides methods for setting the letter at a specific index, removing it, and 
checking if it exists.

##### [PlayerUser](src/PlayerUser.java)

Represents a user player in the game. Provides a method for placing a letter on the board and back to the hand.

##### [State](src/State.java)

Represents the internal state of the game. Consists of various components such as the word bank, the letter bag, the players,
the new board, the old board, the current turn, the current player, and more. To allow for saving and loading, this is all that
needs to be saved and loaded.

##### [View](src/View.java)

Represents the view component of the MVC. Contains all the previously listed panels and provides a wrapper to forward calls
into the panels. Also creates and manages the frame.

##### [WordBank](src/WordBank.java)

Represents the word database. Has methods for checking if a word is valid, getting the value of a letter, and computing the value
of a word. Uses the word reader to acquire the valid words.

##### [WordReader](src/WordReader.java)

Reads from either or website or as a fallback, a local file to acquire a buffer of all the words.

#### UML Diagram 

![](UML.png)

### Known issues
- The word bank allows words which are not valid
- The word solving algorithm is imperfect, and can allow for the user to make illegal moves

### Roadmap Ahead
- Ensuring all tests pass
- Added serialization/derialization
- Adding player AI
- Visual improvements