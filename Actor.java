import java.util.HashSet;
public class Actor {
    private final String name;
    private final HashSet<Character> characters = new HashSet<>();
    private final HashSet<Scene> scenes = new HashSet<>();

    public Actor(String name) {
        this.name = name;
    }

    public void addCharacter(Character character) {
        characters.add(character);
        character.addActor(this); // this line is causing problems when actors have more than one character
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    public void printAllScenes() {
        for (Scene scene : scenes) {
            System.out.println(scene);
        }
    }
    public void printAllCharacters() {
        System.out.println(characters);
    }

    public String toString() {
        return name;
    }
    public String getInfo() {
        return String.format("%s in %d scenes and is %d characters.\n", name, scenes.size(), characters.size());
    }

    public int hashCode() {
        return name.hashCode();
    }
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }
        Actor actor = (Actor) o;
        return actor.name.equals(this.name);
    }
}