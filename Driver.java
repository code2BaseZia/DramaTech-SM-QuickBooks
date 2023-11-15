import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            Production production = new Production(new File("characterActor.csv"), new File("scenes.csv"));
            System.out.println("Welcome to SM QuickBooks! Note that all inputs are Case Sensitive! For a menu of available commands, please enter 0.");
            boolean condition = true;
            while (condition) {
                int inputI = 0;
                try {
                    inputI = Integer.parseInt(input.nextLine().strip());
                } catch (Exception e) {
                    System.out.println("Please enter a valid numeric value.");
                    System.out.println();
                }
                switch (inputI) {
                    case (0):
                        System.out.println("1: Print all scenes.\n2: Print all scenes in an act.\n3: Print all scenes an actor is in.\n" +
                                "4: Print all scenes a character is in.\n5: Print all characters played by a specific actor.\n" +
                                "6: Print all actors who play a specific character.\n7: Print all actors to call to a rehearsal." +
                                "\n8: Print the information of a specific scene.\n9: Output a plain-text file with all specified scenes " +
                                "containing the scene name followed by all the actors in that(those) scene(s)." +
                                "\n10: Output a plain-text file with all scenes containing the scene name followed by all actors in each scene." +
                                "\n11: Output a plain-text file with same information as printing all scenes." +
                                "\n12: Print all possible costume conflicts." +
                                "\n-1: Exit.");
                        backToMain();
                        break;
                    case (1):
                        production.printScenes();
                        backToMain();
                        break;
                    case (2):
                        System.out.println("Please enter the number of the act you'd like to print all scenes from.");
                        int num = Integer.parseInt(input.nextLine());
                        production.printScenesInAct(num);
                        backToMain();
                        break;
                    case (3):
                        System.out.println("Please enter the name of the actor whose scenes you'd like to see.");
                        production.printScenesForActor(new Actor(input.nextLine()));
                        backToMain();
                        break;
                    case (4):
                        System.out.println("Please enter the name of the character whose scenes you'd like to see.");
                        production.printScenesForCharacter(new Character(input.nextLine()));
                        backToMain();
                        break;
                    case (5):
                        System.out.println("Please enter the actor whose characters you'd like to see.");
                        production.printCharactersForActor(new Actor(input.nextLine()));
                        backToMain();
                        break;
                    case (6):
                        System.out.println("Please enter the character whose actors you'd like to see.");
                        production.printActorsForCharacter(new Character(input.nextLine()));
                        backToMain();
                        break;
                    case (7):
                        production.printActorsForRehearsal();
                        backToMain();
                        break;
                    case (8):
                        System.out.println("Please enter the exact name of the scene you'd like the information of.");
                        production.printSpecificScene(input.nextLine());
                        backToMain();
                        break;
                    case (9):
                        production.outputSpecificScenes();
                        backToMain();
                        break;
                    case (10):
                        production.outputAllScenesActors();
                        backToMain();
                        break;
                    case (11):
                        production.outputAllScenes();
                        backToMain();
                        break;
                    case (12):
                        production.printCostumeConflicts();
                        backToMain();
                        break;
                    case (-1):
                        System.out.println("Thank you for using the SM QuickBooks, come again soon!");
                        condition = false;
                        break;
                    default:
                        System.out.println("Please enter a valid command!");
                }
            }
        } catch (CharacterNotFoundException CNFE) {
            CNFE.printStackTrace(); // Likely caused by a character with no known actor, or a typo resulting in an unknown character existing in the scenes.
        } catch (FileNotFoundException FNFE) {
            FNFE.printStackTrace();
            System.out.println("One of the files was not found, please make sure both files exist, are in the same folder as this program, and entered correctly.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void backToMain() {
        System.out.println();
        System.out.println("Welcome back to the main menu, enter 0 to see a list of commands.");
    }
}
