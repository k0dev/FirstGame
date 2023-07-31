package firstgame;

import java.awt.*;

public class SimpleEnemySpawner extends GameObject {
    private final GameObjectsHandler gameObjectsHandler;
    private int numberOfWaves;
    private final int ticksBetweenWaves;
    private int waveTimer;

    protected SimpleEnemySpawner(GameObjectsHandler gameObjectsHandler, int numberOfWaves, int ticksBetweenWaves) {
        super(ID.Spawner);
        this.gameObjectsHandler = gameObjectsHandler;
        this.numberOfWaves = numberOfWaves;
        this.ticksBetweenWaves = ticksBetweenWaves;
        waveTimer = ticksBetweenWaves;
    }

    @Override
    public void render(Graphics2D g2d) {
    }

    @Override
    public void tick() {
        if (numberOfWaves <= 0) {
            gameObjectsHandler.removeGameObject(this);
            return;
        }
        if (waveTimer > 0) {
            waveTimer--;
            return;
        }
        numberOfWaves -= 1;
        waveTimer = ticksBetweenWaves;
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
