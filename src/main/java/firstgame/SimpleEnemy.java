package firstgame;

import java.awt.*;

public class SimpleEnemy extends GameEntity {

    private int health = 5;
    protected SimpleEnemy(int x, int y, GameObjectsHandler gameObjectsHandler, Direction direction) {
        super(ID.Enemy, x, y, gameObjectsHandler);
        setVelX(direction.getVelX());
        setVelY(direction.getVelY());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 30, 30);
    }

    @Override
    public void onCollision(ID what) {
        if (what == ID.Bullet) {
            health -= 1;
        }
        if (health <= 0) {
            gameObjectsHandler.removeGameObject(this);
            Game.addPoints(1);
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(getX(), getY(), 30, 30);
    }
}
