import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.HashMap;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Production {
    private final ArrayList<Act> acts = new ArrayList<>();
    final HashMap<Character, Actor> characterActorHashMap = new HashMap<>();
    final Hashtable<Integer, Character> characters = new Hashtable<>();
    final Hashtable<Integer, Actor> actors = new Hashtable<>();

    public Production(File characterActorFile, File sceneFile) throws FileNotFoundException {
        createCharacterActors(characterActorFile);
        populateCharacterActorHashMap(characterActorFile);
        Scanner input = new Scanner(sceneFile);
        ArrayList<String> sceneList = new ArrayList<>();
        int numActs = 1;
        while (input.hasNextLine()) {
            String toAdd = input.nextLine();
            if (toAdd.equals("$#@$")) {
                ++numActs;
            }
            sceneList.add(toAdd);
        }
        for (int i = 0; i < numActs; ++i) {
            acts.add(new Act(sceneList, this));
        }
    }

    private void createCharacterActors(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            String[] inputs = inputStr.split(",");
            Actor toAddA = new Actor(inputs[1]);
            Character toAddC = new Character(inputs[0]);
            if (actors.get(toAddA.hashCode()) != null) {
                toAddA = actors.get(toAddA.hashCode());
            }
            else {
                actors.put(toAddA.hashCode(), toAddA);
            }
            if (characters.get(toAddC.hashCode()) != null) {
                toAddC = characters.get(toAddC.hashCode());
            } else {
                characters.put(toAddC.hashCode(), toAddC);
            }
            toAddC.addActor(toAddA);
            toAddA.addCharacter(toAddC);
        }
    }

    private void populateCharacterActorHashMap(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            String[] inputs = inputStr.split(",");
            Actor compareA = new Actor(inputs[1]);
            Character compareC = new Character(inputs[0]);
            characterActorHashMap.put(characters.get(compareC.hashCode()),actors.get(compareA.hashCode()));
        }
        input.close();
    }

    public void printScenes() {
        for (Act a : acts) {
            a.printScenes();
        }
    }
    public void printScenesInAct(int actNum) {
        if (actNum - 1 >= acts.size() || actNum - 1 < 0) {
            System.out.println("You entered an invalid act number, valid act numbers are: ");
            for (int i = 0; i < acts.size(); ++i) {
                System.out.println(i + 1);
            }
            System.out.println("You have been returned to the main menu");
            return;
        }
        acts.get(actNum - 1).printScenes();
    }
    public void printScenesForActor(Actor actor) {
        if (actors.get(actor.hashCode()) == null) {
            System.out.println("You entered an invalid actor. You have been returned to the main menu.");
            return;
        }
        actors.get(actor.hashCode()).printAllScenes();
    }
    public void printScenesForCharacter(Character character) {
        if (characters.get(character.hashCode()) == null) {
            System.out.println("You entered an invalid character. You have been returned to the main menu.");
            return;
        }
        characters.get(character.hashCode()).printAllScenes();
    }
    public void printCharactersForActor(Actor actor) {
        if (actors.get(actor.hashCode()) == null) {
            System.out.println("You entered an invalid actor. You have been returned to the main menu.");
            return;
        }
        actors.get(actor.hashCode()).printAllCharacters();
    }
    public void printActorsForCharacter(Character character) {
        if (characters.get(character.hashCode()) == null) {
            System.out.println("You entered an invalid character. You have been returned to the main menu.");
            return;
        }
        characters.get(character.hashCode()).printAllActors();
    }
    public void printActorsForRehearsal() {
        HashSet<Actor> actorsToCall = new HashSet<>();
        Scanner input = new Scanner(System.in);
        ArrayList<Scene> scenes = new ArrayList<>();
        for (Act a : acts) {
            scenes.addAll(a.getScenes());
        }
        while (true) {
            for (int i = 0; i < scenes.size(); ++i) {
                System.out.printf("%d:%s\n", i, scenes.get(i).getName());
            }
            System.out.println();
            System.out.println("Please select as many scenes to add to rehearsal as you'd like. Once finished, enter -1.");
            int numInput = 0;
            try {
                numInput = Integer.parseInt(input.nextLine().strip());
            } catch (Exception e) {
                System.out.println("Please enter a valid numeric value.");
                System.out.println();
                continue;
            }
            if (numInput == -1) {
                break;
            }
            actorsToCall.addAll(scenes.get(numInput).getActors());
        }
        System.out.println(actorsToCall);
    }
    public void printSpecificScene(String sceneName) {
        for (Act act : acts) {
            for (Scene scene : act.getScenes()) {
                if (scene.getName().equals(sceneName)) {
                    System.out.println(scene);
                    return;
                }
            }
        }
        System.out.println("No scene by that name was found.");
    }

    public void outputAllScenesActors() {
        try {
            new File("All Scenes Actors Only Output.txt").createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter("All Scenes Actors Only Output.txt"));
            for (Act act : acts) {
                for (Scene scene : act.getScenes()) {
                    writer.write(scene.toStringActorsOnly());
                    writer.newLine();
                }
            }
            writer.close();
            System.out.println("Output created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void outputAllScenes() {
        try {
            new File("All Scenes Output.txt").createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter("All Scenes Output.txt"));
            for (Act act : acts) {
                for (Scene scene : act.getScenes()) {
                    writer.write(scene.toString());
                    writer.newLine();
                }
            }
            writer.close();
            System.out.println("Output created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void outputSpecificScenes() {
        boolean condition = true;
        HashSet<Scene> scenesToWrite = new HashSet<>();
        Scanner input = new Scanner(System.in);
        ArrayList<Scene> scenes = new ArrayList<>();
        for (Act a : acts) {
            scenes.addAll(a.getScenes());
        }
        while (true) {
            for (int i = 0; i < scenes.size(); ++i) {
                System.out.printf("%d:%s\n", i, scenes.get(i).getName());
            }
            System.out.println();
            System.out.println("Please select as many scenes to add to the file as you'd like. Once finished, enter -1.");
            int numInput = 0;
            try {
                numInput = Integer.parseInt(input.nextLine().strip());
            } catch (Exception e) {
                System.out.println("Please enter a valid numeric value.");
                continue;
            }
            if (numInput == -1) {
                break;
            }
            scenesToWrite.add(scenes.get(numInput));
        }
        try {
            new File("Specific Scene Output.txt").createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Specific Scene Output.txt"));
            for (Scene scene : scenesToWrite) {
                writer.write(scene.toString());
                writer.newLine();
            }
            writer.close();
            System.out.println("Output created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printCostumeConflicts() {
        ArrayList<CostumeConflictHolder> conflicts = new ArrayList<>();
        HashMap<Actor, Character> running = new HashMap<>();
        Scene priorScene = null;
        for (Act act : acts) {
            for (Scene scene : act.getScenes()) {
                scene.analyzeConflicts(running, priorScene, conflicts);
                priorScene = scene;
            }
        }
        for (CostumeConflictHolder conflict : conflicts) {
            if (conflict.priorScene != conflict.scene) {
                System.out.printf("Conflict going from \"%s\" to \"%s\" for %s from character %s to %s.\n",
                        conflict.priorScene.getName(), conflict.scene.getName(), conflict.actor, conflict.priorCharacter, conflict.newCharacter);
            } else {
                System.out.printf("Conflict in \"%s\" for %s from character %s to %s.\n",
                        conflict.priorScene.getName(), conflict.actor, conflict.priorCharacter, conflict.newCharacter);
            }
        }
        if (conflicts.size() == 0) {
            System.out.println("No costume conflicts found!");
        }
    }
    static class CostumeConflictHolder {
        private final Scene scene;
        private final Actor actor;
        private final Character newCharacter;
        private final Character priorCharacter;
        private final Scene priorScene;

         CostumeConflictHolder(Scene scene, Scene priorScene, Actor actor, Character newCharacter, Character priorCharacter) {
            this.scene = scene;
            this.priorScene = priorScene;
            this.actor = actor;
            this.newCharacter = newCharacter;
            this.priorCharacter = priorCharacter;
        }

    }
}


