import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Act {
    private final ArrayList<Scene> scenes = new ArrayList<>();
    public Act(ArrayList<String> sceneList, Production prod) {
        populateScenes(sceneList, prod);
    }

    private void populateScenes(ArrayList<String> sceneList, Production prod) {
        for (int i = 0; i < sceneList.size();) {
            String[] inputs = sceneList.remove(i).split(", ");

            if (inputs[0].equals("$#@$")) {
                return;
            }
            scenes.add(new Scene(inputs, prod));
        }
    }

    public void printScenes() {
        System.out.println("----------------- Start of Act -----------------\n");
        for (Scene scene : scenes) {
            System.out.println(scene);
        }
    }
    public List<Scene> getScenes() {
        return Collections.unmodifiableList(scenes);
    }
    public void printSceneNames() {
        for (int i = 0; i < scenes.size(); ++i) {
            System.out.printf("%d:%s\n", i, scenes.get(i).getName());
        }
    }
}
