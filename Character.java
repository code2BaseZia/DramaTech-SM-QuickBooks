import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Character {
    private final String name;
    private final HashSet<Actor> actors = new HashSet<>();
    private final HashSet<Scene> scenes = new HashSet<>();

    public Character(String name) {
        this.name = name;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    public void printAllScenes() {
        for (Scene scene : scenes) {
            System.out.println(scene);
        }
    }
    public void printAllActors() {
        System.out.println(actors);
    }
    public Set<Actor> getActors() {
        return Collections.unmodifiableSet(actors);
    }
    @Override
    public String toString() {
        return name;
    }
    public String getInfo() {
        return String.format("%s character is played by %d actors and is in %d scenes.", name, actors.size(), scenes.size());
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }
        Character character = (Character) o;
        return character.name.equals(this.name);
    }

}
