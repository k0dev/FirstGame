package firstgame;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameObjectsHandler {

    private List<GameObject> gameObjects;

    public GameObjectsHandler() {
        gameObjects = new LinkedList<>();
    }

    public void renderAll(Graphics2D g2d) {
        for (GameObject object :
                gameObjects) {
            object.render(g2d);
        }
    }

    public void tickAll() {
        for (GameObject object :
                gameObjects) {
            object.tick();
        }
    }
}
