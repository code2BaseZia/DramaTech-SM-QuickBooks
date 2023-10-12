# DramaTech-SM-QuickBooks
Welcome to the DramaTech SM QuickBooks! By utilizing this service you agree that you will properly format inputs! 

The DramaTech SM QuickBooks allow stage managers and their assistants to quickly gather information about a production with minimal effort! Once the necessary inputs have been created, the program can be used to supplement SM activites such as: Finding all the actors for a character, highlighting possbile costume change conflicts, and many more features!

## Installation
In order to install and DramaTech SM QuickBooks, be sure to download all .java files and place them within a common directory.
## Formatting Inputs
### Character Actor File
It is paramount that inputs be formatted correctly. The assumed format for the character actor file is a spreadsheet with NO HEADERS. Note that if you include headers, you can simply delete that line from the resulting CSV to use it as input. The first cell of the spreadsheet should be the name of the character exactly as you will write their name for each scene, with their actor in the same row in the next column. With a spreadsheet formatted properly, download a CSV version of the spreadsheet. Below is an example of a correctly formatted and downloaded CSV.

```
Wayne Hopkins,Actor Name,
Narrator,Actor Name,
Megan Jones,Actor Name,
etc,etc,
```
### Scene File
The assumed format for the scene file is a spreadsheet with NO HEADERS. Note that if you include headers, you can simply delete that line from the resulting CSV to use it as input. In that same row, each subsequent column should be a character in that scene. Once downloaded as a CSV it should look as follows. Please keep in mind that if you want to specify someone as an Understudy instead of playing the same character, the Understudy version of their character must appear in all their scenes or else they will not be shown as in the scene.
```
Prologue,Wayne Hopkins,Narrator,Megan Jones,
Welcome To Puffs,Wayne Hopkins,Narrator,
etc,etc,
```
Note that if a scene contains a character which does not exist in the character actor file it will throw an error when you attempt to run the program telling you the character that it could not find in the character actor input file.

### Naming Your Input Files
The default names for the passed in inputs are characterActor.csv and scenes.csv respectively. Renaming your CSVs and moving them to the same directory/folder should allow the program to run with no issues. If you do not wish to rename your CSVs for whatever reason, simply change the input files' names in the constructor for Production in the Driver class on line 10.

## Running the Program
Running these programs will require having Java installed. They were written for Java 11, but may work on newer versions. If you are having trouble running it, download Java 11.
### Using an IDE
If you have an IDE you can simply run the driver program using your IDE. If not, you can use the terminal to compile each java file and then run the driver file directly (More detailed instructions below).

### Using Terminal Commands
Open a new terminal window. On both Windows and Mac, use `cd "directory/path/here"` to navigate to the correct folder and drive that the files are all stored in. To get the directory path you can navigate to the folder in File Explorer and right click the folder to copy its path. Once you've navigated to the correct folder in your terminal, begin by typing `javac *.java` this will compile all the java files. Next, simply type `java Driver` and the program should run!

## Using the Program
