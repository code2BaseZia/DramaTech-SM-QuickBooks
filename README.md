# DramaTech-SM-QuickBooks
Welcome to the DramaTech SM QuickBooks! By utilizing this service you agree that you will properly format inputs! 

**NOTE: This README and the following is a work and progress and will be completed sometime in the near future!**

The DramaTech SM QuickBooks allow stage managers and their assistants to quickly gather information about a production with minimal effort! Once the necessary inputs have been created, the program can be used to supplement SM activites such as: Finding all the actors for a character, highlighting possbile costume change conflicts, and many more features!

## Installation
In order to install and use DramaTech SM QuickBooks, be sure to download all .java files and place them within a common directory.
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

Within the scene file, once you reach the end of an act, create a new line and put only `$#@$` on it, as this will indicate to the program that an act has ended and a new act begins from that point on.

### Naming Your Input Files
The default names for the passed in inputs are characterActor.csv and scenes.csv respectively. Renaming your CSVs and moving them to the same directory/folder should allow the program to run with no issues. If you do not wish to rename your CSVs for whatever reason, simply change the input files' names in the constructor for Production in the Driver class on line 10.

## Running the Program
Running these programs will require having Java installed. They were written for Java 11, but may work on newer versions. If you are having trouble running it, download Java 11.
### Using an IDE
If you have an IDE you can simply run the driver program using your IDE. If not, you can use the terminal to compile each java file and then run the driver file directly (More detailed instructions below).

### Using Terminal Commands
Open a new terminal window. On both Windows and Mac, use `cd "directory/path/here"` to navigate to the correct folder and drive that the files are all stored in. To get the directory path you can navigate to the folder in File Explorer and right click the folder to copy its path. Once you've navigated to the correct folder in your terminal, begin by typing `javac *.java` this will compile all the java files. Next, simply type `java Driver` and the program should run!

## Using the Program
After downloading the program, you must run it using one of the above methods. All interfacing with the program is done through the terminal, whether it be the IDE integrated one, or physical cmd window. Make sure that your scene file and actor file are named properly and are located in the same folder as the program.
### Main Menu
The main menu lists all available commands in the current version, currently there are 12 different options of commands available in the program.
| Integer to Enter | Description |
| --- | ----------- |
| 0 |Shows menu of available commands|
| 1 |Prints all entered scenes|
| 2 |Prints all scenes in the specified act|
| 3 |Prints all scenes the specified actor is in|
| 4 |Prints all scenes the specified character is in|
| 5 |Prints all characters played by the specified actor|
| 6 |Prints all actors who play the specified character|
| 7 |Prints all actors to call to the specified rehearsal|
| 8 |Prints the information of the specified scene|
| 9 |Outputs a plain-text file with all specified scenes|
| 10 |Outputs a plain-text file with all scenes and only the actors in those scenes|
| 11 |Outputs a plain-text file with the same information as printing all scenes|
| 12 |Prints possible costume conflicts|
| -1 |Exits/terminates the program|

## Thanks
Thank you for using this program. As we are still in the beta testing phase, if you have any problems please reach out. If possible, bring me suggestions and things you like and dislike about using the program so it can be improved for future builds and SMs. Thank you for using the DramaTech SM Quickbooks! Break legs!
