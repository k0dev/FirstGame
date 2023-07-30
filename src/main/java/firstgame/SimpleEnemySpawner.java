package firstgame;

import java.awt.*;

public class SimpleEnemySpawner extends GameObject {
    private final GameObjectsHandler gameObjectsHandler;
    private int waveTimer = 180;

    protected SimpleEnemySpawner(GameObjectsHandler gameObjectsHandler) {
        super(ID.Spawner);
        this.gameObjectsHandler = gameObjectsHandler;
    }

    @Override
    public void render(Graphics2D g2d) {
    }

    @Override
    public void tick() {
        if (waveTimer > 0) {
            waveTimer--;
            return;
        }
        waveTimer = 360;
        SimpleEnemy top = new SimpleEnemy(Game.GAME_SIZE/2 - 15, 0, gameObjectsHandler, Direction.Bottom);
        SimpleEnemy bottom = new SimpleEnemy(Game.GAME_SIZE/2 - 15, Game.GAME_SIZE, gameObjectsHandler, Direction.Top);
        SimpleEnemy left = new SimpleEnemy(0, Game.GAME_SIZE/2 - 15, gameObjectsHandler, Direction.Right);
        SimpleEnemy right = new SimpleEnemy(Game.GAME_SIZE, Game.GAME_SIZE/2 - 15, gameObjectsHandler, Direction.Left);

        gameObjectsHandler.addGameObject(top);
        gameObjectsHandler.addGameObject(bottom);
        gameObjectsHandler.addGameObject(left);
        gameObjectsHandler.addGameObject(right);
    }
}
