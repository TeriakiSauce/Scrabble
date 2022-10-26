# Scrabble

A simple version of Scrabble written in Java. See the [glossary](#Glossary) for the list of terms used.

### Rules

In short, Scrabble is about placing neighbouring letters to make words. For each [turn](#Glossary), the player must choose one of three options. They can [pass](#Passing) the [turn](#Glossary), [exchange](#Exchanging) letters with the [bag](#Glossary), or [play](#Playing) [tiles](#Glossary) to make a word.

#### Passing

Passing allows the player to forfeit their [turn](#Glossary) and score no points. Passing is usually done when the [bag](#Glossary) has no more letters, and the player cannot make a valid word on the board with their current letters.

#### Exchanging

Exchanging allows the player to exchange one or more [tiles](#Glossary) with the [bag](#Glossary), for an equal number of [tiles](#Glossary). The player will not be able to score any points and forfeits their opportunity to play a word for that [turn](#Glossary). The player may not exchange if there are less than seven [tiles](#Glossary) remaining in the [bag](#Glossary). Exchanging is usually done when the player cannot make any valid words on the [board](#Glossary) with their current letters, or if the player is close to a high value word but is missing one or more letters.

#### Playing

Playing is how a player scores points and win. To score points, the player must make a word on the [board](#Glossary). To make a word, the player must place one to seven letters to make a word. The player may not place any letters if they do not contribute to making a word in the same [turn](#Glossary). For the first [turn](#Glossary) of the game, the player must play at least two letters to form a valid word. After, the player may place a single letter as long as it forms a valid word.

Once the player has played a valid word, they may retrieve the number of letters used from the [bag](#Glossary), such that they have seven letters. If the [bag](#Glossary) does not have enough letters such that the player cannot obtain seven letters on their [rack](#Glossary), they may empty the [bag](#Glossary) and take the remaining letters.
Create words out of the letters given to you in your hand. Words have different values depending on the number and type of letters in them.

### How To Play

Use the Text User Interface to type and respond to prompts generated and displayed on the window.

### Implementation

To view the source code, click [here](src).

#### Board (Andrew)

##### Board Representation

To view the implementation, click [here](src/Board.java).

To represent the [board](#Glossary), we decided to use a 2D array of, where every element in the array could be a cell. By using a simple data structure, we can access each cell using xy coordinates, allowing us to easily map the selected cell by the user to the underlying cell. 

##### Cell Representation

Since each cell is stored in the [board](#Glossary) using xy coordinates, all the cell needs to keep is the current letter at that position. 

#### Gameplay (Andrew, Tarik)

##### Parsing

To view the implementation, click [here](src/GameState.java).

The game is currently command line driven, meaning, we need a way to interpret what the user is trying to input.

##### Board Class:
gameBoard: Created the actual game board using a 2-d array of Cells. A 2-d array was chosen so that each cell could have a 2-d coordinate to be easily accessed and printed. 


##### Constructor:


Initialized the board by looping through the array and creating a new blank cell in each location in the array.


##### Cell class:
Represents a cell on the board with a char (‘ ‘ represents blank). Each cell also contains its x and y location in the grid represented by ints.

##### Hand class:
Represents a player’s hand


This class uses an ArrayList to store the 7 letters that will be in the player’s hand. An arraylist was used so that you can use the add, remove and contains methods provided by List on constant time.


##### TileList class:


Represents all the tiles available in a game of Scrabble


This class again uses a linked list to store the tiles. A linked list was chosen for its overall faster implementation of the add method which is used many times.

#### Gameplay (Tarik + Andrew)

##### GameState class:

GameState represents the current state of the game with various int and boolean values representing different aspects of the game. This way the game’s state can be accessed through many classes and info stays organized in one place.

#### Parser class:

This class deals with all user input involving choosing commands. It uses an enum of ValidCommands that allow the class to ahve support for multiple new commands if needed by simply adding an element to the enum

#### Game class:

The main class that stores the gameplay loop. The loop takes user input and executes methods depending on the prompt. It has methods place, pass and quit to represent the actions a user can take. The class has all relevent classes created previously as object fields, such as the Board, WordBank, GameState and Parser classes, as well as primitive fields like points and turns.

#### Database (Jaan)

##### Word Retrieval

To view the implementation, click [here](src/WordReader.java).

The lists of valid words that can be used are retrieved from a website using the Java URL library. We download the data from a specified URL, and extract the words from the data. If the user has no internet connection or the download failed, we also have a backup list of words stored in a local text file which can be extracted in the same manner. Currently, there are ten thousand valid words in the database, however, this can be increased by downloading the words from different website or creating a larger local database of words.

##### Word Storage

To view the implementation, click [here](src/WordBank.java).

Since we have to store many words and each word can consume a large amount of memory, it is not ideal to store the words as plain strings. Instead, we can hash all the words so that we can store the words as integers, and if we want to check if a word is valid, we can hash that word and check if the hash value exists. This greatly reduces the amount of memory used, allowing us to add many more words in the future. We store the hashes (integers) as a set, as there is already a hashing function for integers and a set offers fast lookup times.

#### Word Values

To view the implementation, click [here](src/WordBank.java).

The value of a word depends on the values of the letters it contains. Therefore, to determine the value of the word, we can iterate over the word and take the sum of the values of the letters it contains. We can store the values of the letters using a basic hash map, where the letters map to integers representing the values of the letters.

### Glossary

- Turn: Where a player gets the opportunity to pick between [passing](#Passing), [exchanging](#Exchanging), and [playing](#Playing).
- Bag: The remaining letters. Can be used to [exchange](#Exchange) letters with, or refill the [rack](#Glossary) after making a word.
- Rack: The one to seven letters that each player has the opportunity to make a word with.
- Tile: The physical representation of a letter. Consists of the letter, and the value of the letter.
- Board: The device for which players can place [tiles](#Glossary) on to make words.

#### UML Diagram (Haravind)

### Known issues

### Roadmap ahead

