import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
