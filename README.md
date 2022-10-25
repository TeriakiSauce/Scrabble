# Scrabble

### Rules

Create words out of the letters given to you in your hand. Words have different values depending on the number and type of letters in them.

### How To Play

Use the Text User Interface to type and respond to prompts generated and displayed on the window.

### Implementation

#### Board Representation (Andrew)

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

#### UML Diagram (Haravind)

#### Database (Jaan)

##### Word Retrieval

The lists of valid words that can be used are retrieved from a website using the Java URL library. We download the data from a specified URL, and extract the words from the data. If the user has no internet connection or the download failed, we also have a backup list of words stored in a local text file which can be extracted in the same manner. Currently, there are ten thousand valid words in the database, however, this can be increased by downloading the words from different website or creating a larger local database of words.

##### Word Storage

Since we have to store many words and each word can consume a large amount of memory, it is not ideal to store the words as plain strings. Instead, we can hash all the words so that we can store the words as integers, and if we want to check if a word is valid, we can hash that word and check if the hash value exists. This greatly reduces the amount of memory used, allowing us to add many more words in the future. We store the hashes (integers) as a set, as there is already a hashing function for integers and a set offers fast lookup times.

#### Word Values

The value of a word depends on the values of the letters it contains. Therefore, to determine the value of the word, we can iterate over the word and take the sum of the values of the letters it contains. We can store the values of the letters using a basic hash map, where the letters map to integers representing the values of the letters.
