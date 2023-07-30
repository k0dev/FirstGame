package firstgame;

public abstract class GameEntity extends GameObject {
    private int x;
    private int y;
    protected final GameObjectsHandler gameObjectsHandler;
    private int velX;
    private int velY;
    protected GameEntity(ID id, int x, int y, GameObjectsHandler gameObjectsHandler) {
        super(id);
        this.x = x;
        this.y = y;
        this.gameObjectsHandler = gameObjectsHandler;
        velX = 0;
        velY = 0;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (x > Game.GAME_SIZE || y > Game.GAME_SIZE || x < 0 || y < 0) {
            gameObjectsHandler.remove(this);
        }
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
