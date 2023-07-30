package firstgame;

import java.awt.*;

public class SimpleWeapon extends GameEntity {

    private int bulletTickCounter;

    private final Direction direction;

    protected SimpleWeapon(int x, int y, GameObjectsHandler gameObjectsHandler, Direction direction) {
        super(ID.Weapon, x - 20, y - 20, gameObjectsHandler);
        this.direction = direction;
        bulletTickCounter = 60;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(super.getX(), super.getY(), 40, 40);
    }

    @Override
    public void tick() {
        super.tick();
        if (bulletTickCounter > 0) {
            bulletTickCounter--;
            return;
        }
        bulletTickCounter = 60;
        Bullet bullet = new Bullet(ID.Bullet, super.getX() + 20, super.getY() + 20, Color.WHITE, gameObjectsHandler);
        bullet.setVelX(direction.getVelX());
        bullet.setVelY(direction.getVelY());
        gameObjectsHandler.add(bullet);
    }
}
