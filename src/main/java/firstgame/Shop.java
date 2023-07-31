package firstgame;

import java.awt.*;

public class Shop {

    private final GameObjectsHandler gameObjectsHandler;

    public Shop(GameObjectsHandler gameObjectsHandler) {
        this.gameObjectsHandler = gameObjectsHandler;
        BuyBulletsButton buyBulletsButton = new BuyBulletsButton();

        gameObjectsHandler.addGameObject(buyBulletsButton);
        gameObjectsHandler.addClickable(buyBulletsButton);
    }

    private class BuyBulletsButton extends GameObject implements Clickable {
        protected BuyBulletsButton() {
            super(ID.Shop);
        }

        @Override
        public void onClick() {
            if (Game.getPoints() >= 4) {
                Game.addPoints(-4);
                Game.addBullets(10);
            }
        }

        @Override
        public Rectangle getBounds() {
            return new Rectangle(500, 500, 130, 50);
        }

        @Override
        public void render(Graphics2D g2d) {
            g2d.setFont(g2d.getFont().deriveFont(20.0f));
            g2d.setColor(Color.WHITE);
            g2d.drawRect(500, 500, 130, 50);
            g2d.drawString("Buy bullets", 510, 530);
        }

        @Override
        public void tick() {

        }
    }
}
