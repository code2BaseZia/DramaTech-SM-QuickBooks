import java.util.*;

public class Scene {
    private final String name;
    private final HashSet<Character> characters = new HashSet<>();
    private final HashSet<Actor> actors = new HashSet<>();
    public Scene(String[] inputs, Production prod) {
        this.name = inputs[0]; // redo below code
        for (int i = 1; i < inputs.length; ++i) {
            Character toAddC = prod.characters.get(new Character(inputs[i]).hashCode());
            if (toAddC == null) {
                throw new CharacterNotFoundException(inputs[i]);
            }
            toAddC.addScene(this);
            characters.add(toAddC);
            actors.addAll(toAddC.getActors());
            for (Actor actor : actors) {
                actor.addScene(this);
            }
        }
    }
    public void analyzeConflicts(HashMap<Actor, Character> running, Scene priorScene, ArrayList<Production.CostumeConflictHolder> conflicts) {
        for (Character character : this.getCharacters()) {
            for (Actor actor : character.getActors()) {
                if (running.get(actor) == null) {
                    running.put(actor, character);
                } else if (!running.get(actor).equals(character)) {
                    if (this.getCharacters().contains(running.get(actor))) {
                        conflicts.add(new Production.CostumeConflictHolder(this, this, actor, character, running.get(actor)));
                    } else {
                        conflicts.add(new Production.CostumeConflictHolder(this, priorScene, actor, character, running.get(actor)));
                    }
                }
            }
        }
        running.clear();
        for (Character character : this.getCharacters()) {
            for (Actor actor : character.getActors()) {
                running.putIfAbsent(actor, character);
            }
        }
    }
    public String getName() {
        return name;
    }
    public Set<Actor> getActors() {
        return Collections.unmodifiableSet(actors);
    }
    public Set<Character> getCharacters() {
        return Collections.unmodifiableSet(characters);
    }

    public String toString() {
        return String.format("%s has:\nCharacters: %s \nActors: %s\n",name, characters, actors);
    }
    public String toStringActorsOnly() {
        return String.format("%s has:\nActors: %s\n",name, actors);
    }
}
