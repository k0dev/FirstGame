package firstgame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class GameObjectsHandler implements MouseListener {

    private final List<GameObject> gameObjects;
    private final List<Clickable> clickables;

    public GameObjectsHandler() {
        gameObjects = new LinkedList<>();
        clickables = new LinkedList<>();
    }

    public void renderAll(Graphics2D g2d) {
        //System.out.println("[*] Rendering " + gameObjects.size() + " game objects.");
        for (int i = 0; i < gameObjects.size(); i++)
            gameObjects.get(i).render(g2d);
    }

    public void tickAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            gameObject.tick();
            if (gameObject.id == ID.Enemy) {
                GameEntity enemy = (GameEntity) gameObject;
                for (int j = 0; j < gameObjects.size(); j++) {
                    if (gameObjects.get(j).id == ID.Bullet) {
                        GameEntity bullet = (GameEntity) gameObjects.get(j);
                        if (enemy.getBounds().intersects(bullet.getBounds())) {
                            enemy.onCollision(ID.Bullet);
                            bullet.onCollision(ID.Enemy);
                        }
                    } else if (gameObjects.get(j).id == ID.Weapon) {
                        GameEntity weapon = (GameEntity) gameObjects.get(j);
                        if (enemy.getBounds().intersects(weapon.getBounds())) {
                            enemy.onCollision(ID.Weapon);
                            weapon.onCollision(ID.Enemy);
                        }
                    }
                }
            }
        }
    }

    public synchronized void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    public void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public void addClickable(Clickable clickable) {
        clickables.add(clickable);
    }

    public void removeClickable(Clickable clickable) {
        clickables.remove(clickable);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            for (int i = 0; i < clickables.size(); i++) {
                Rectangle r = clickables.get(i).getBounds();
                if (e.getX() >= r.x && e.getX() <= r.x + r.width && e.getY() >= r.y && e.getY() <= r.y + r.height)
                    clickables.get(i).onClick();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
