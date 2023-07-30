package firstgame;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Thread gameThread;
    public static final int GAME_SIZE = 800;
    private boolean running = false;
    private GameObjectsHandler gameObjectsHandler;

    private static final int topWeaponX = GAME_SIZE/2;
    private static final int topWeaponY = GAME_SIZE/2 - 40;
    private static final int bottomWeaponX = GAME_SIZE/2;
    private static final int bottomWeaponY = GAME_SIZE/2 + 40;
    private static final int leftWeaponX = GAME_SIZE/2 - 40;
    private static final int leftWeaponY = GAME_SIZE/2;
    private static final int rightWeaponX = GAME_SIZE/2 + 40;
    private static final int rightWeaponY = GAME_SIZE/2;

    public Game() {
        gameObjectsHandler = new GameObjectsHandler();

        Map map = new Map(GAME_SIZE);
        SimpleWeapon topWeapon = new SimpleWeapon(topWeaponX, topWeaponY, gameObjectsHandler, Direction.Top);
        SimpleWeapon bottomWeapon = new SimpleWeapon(bottomWeaponX, bottomWeaponY, gameObjectsHandler, Direction.Bottom);
        SimpleWeapon leftWeapon = new SimpleWeapon(leftWeaponX, leftWeaponY, gameObjectsHandler, Direction.Left);
        SimpleWeapon rightWeapon = new SimpleWeapon(rightWeaponX, rightWeaponY, gameObjectsHandler, Direction.Right);

        gameObjectsHandler.add(map);
        gameObjectsHandler.add(topWeapon);
        gameObjectsHandler.add(bottomWeapon);
        gameObjectsHandler.add(leftWeapon);
        gameObjectsHandler.add(rightWeapon);
        setPreferredSize(new Dimension(GAME_SIZE, GAME_SIZE));
        new Window(GAME_SIZE, GAME_SIZE, this);
    }

    public void start() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long tickTimer = 0;
        long fpsTimer = 0;
        final int TARGET_TPS = 60;
        final long TIME_PER_TICK = 1000000000L / TARGET_TPS;
        final int MAX_RENDER_SKIP = 5;
        int ticks = 0;
        int frames = 0;
        while (running) {
            long currentTime = System.nanoTime();
            long passedTime = currentTime - lastTime;
            lastTime = currentTime;

            if (passedTime < 0) {
                passedTime = 0;
            }
            if (passedTime > TIME_PER_TICK * MAX_RENDER_SKIP) {
                passedTime = TIME_PER_TICK * MAX_RENDER_SKIP;
            }

            tickTimer += passedTime;
            fpsTimer += passedTime;

            boolean ticked = false;
            while (tickTimer >= TIME_PER_TICK) {
                tick();
                ticks++;
                tickTimer -= TIME_PER_TICK;
                ticked = true;
            }

            render();
            frames++;

            if (!ticked){
                // If no ticks happened, sleep a bit to save CPU cycles
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Calculate and display FPS and TPS every second
            if (fpsTimer >= 1000000000L) {
                System.out.println("FPS: " + frames + ", TPS: " + ticks);
                frames = 0;
                ticks = 0;
                fpsTimer = 0;
            }
        }

        stop();
    }

    private void tick() {
        gameObjectsHandler.tickAll();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, GAME_SIZE, GAME_SIZE);

        gameObjectsHandler.renderAll((Graphics2D) g);

        g.dispose();
        bs.show();
    }

    private void stop() {
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        running = false;
    }
}
