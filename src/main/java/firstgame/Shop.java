package firstgame;

import java.awt.*;

public class Shop {

    private final GameObjectsHandler gameObjectsHandler;

    public Shop(GameObjectsHandler gameObjectsHandler) {
        this.gameObjectsHandler = gameObjectsHandler;
        gameObjectsHandler.addClickable(new BuyBulletsButton());
    }

    private class BuyBulletsButton implements Clickable {
        @Override
        public void onClick() {
            if (Game.getPoints() >= 4) {
                Game.addPoints(-4);
            }
        }

        @Override
        public Rectangle getBounds() {
            return null;
        }
    }
}
