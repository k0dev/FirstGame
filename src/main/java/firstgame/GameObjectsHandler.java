package firstgame;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameObjectsHandler {

    private final List<GameObject> gameObjects;

    public GameObjectsHandler() {
        gameObjects = new LinkedList<>();
    }

    public void renderAll(Graphics2D g2d) {
        //System.out.println("[*] Rendering " + gameObjects.size() + " game objects.");
        for (int i = 0; i < gameObjects.size(); i++)
            gameObjects.get(i).render(g2d);
    }

    public void tickAll() {
        for (int i = 0; i < gameObjects.size(); i++)
            gameObjects.get(i).tick();
    }

    public synchronized void add(GameObject object) {
        gameObjects.add(object);
    }

    public void remove(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }
}
