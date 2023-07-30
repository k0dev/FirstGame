package firstgame;

import java.awt.*;

public class Bullet extends GameEntity {

    private Color color;
    protected Bullet(ID id, int x, int y, Color color, GameObjectsHandler gameObjectsHandler) {
        super(id, x, y, gameObjectsHandler);
        this.color = color;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(super.getX() - 3, super.getY() - 3, 6, 6);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 6, 6);
    }

    @Override
    public void onCollision(ID what) {
        if (what == ID.Enemy)
            gameObjectsHandler.removeGameObject(this);
    }
}
