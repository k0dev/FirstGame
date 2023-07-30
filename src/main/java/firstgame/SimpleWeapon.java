package firstgame;

import java.awt.*;

public class SimpleWeapon extends GameEntity implements Clickable {

    private int bulletTickCounter;

    private final Direction direction;

    private boolean shooting;

    protected SimpleWeapon(int x, int y, GameObjectsHandler gameObjectsHandler, Direction direction) {
        super(ID.Weapon, x - 20, y - 20, gameObjectsHandler);
        this.direction = direction;
        bulletTickCounter = 30;
        shooting = false;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(getX(), getY(), 40, 40);
        g2d.setColor(Color.RED);
        if (shooting) g2d.setColor(Color.GREEN);
        g2d.fillOval(getX() + 15, getY() + 15, 10, 10);
    }

    @Override
    public void tick() {
        super.tick();

        if (shooting) {
            shoot();
        }
    }

    private void shoot() {
        if (bulletTickCounter > 0 || !Game.useBullets(1)) {
            bulletTickCounter--;
            return;
        }
        bulletTickCounter = 30;

        Bullet bullet = new Bullet(ID.Bullet, super.getX() + 20, super.getY() + 20, Color.WHITE, gameObjectsHandler);
        bullet.setVelX(direction.getVelX() * 8);
        bullet.setVelY(direction.getVelY() * 8);
        gameObjectsHandler.addGameObject(bullet);
    }

    @Override
    public void onClick() {
        shooting = !shooting;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 40, 40);
    }

    @Override
    public void onCollision(ID what) {
        if (what == ID.Enemy) {
            Game.gameState = GameState.GameOver;
        }
    }
}