package firstgame;

import java.awt.*;

public class Shop {

    private final GameObjectsHandler gameObjectsHandler;

    public Shop(GameObjectsHandler gameObjectsHandler) {
        this.gameObjectsHandler = gameObjectsHandler;
        BuyBulletsButton buyBulletsButton = new BuyBulletsButton();
        UpgradeFireRateButton upgradeFireRateButton = new UpgradeFireRateButton();

        gameObjectsHandler.addGameObject(buyBulletsButton);
        gameObjectsHandler.addGameObject(upgradeFireRateButton);

        gameObjectsHandler.addClickable(buyBulletsButton);
        gameObjectsHandler.addClickable(upgradeFireRateButton);
    }

    private class BuyBulletsButton extends GameObject implements Clickable {
        protected BuyBulletsButton() {
            super(ID.Shop);
        }

        @Override
        public void onClick() {
            if (Game.getPoints() >= 1) {
                Game.addPoints(-1);
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
            g2d.drawString("1", 480, 530);
        }

        @Override
        public void tick() {

        }
    }

    private class UpgradeFireRateButton extends GameObject implements Clickable {

        protected UpgradeFireRateButton() {
            super(ID.Shop);
        }

        @Override
        public void onClick() {
            if (Game.getPoints() >= 4 && Game.topWeapon.fireRate < Game.TARGET_TPS) {
                Game.addPoints(-4);
                Game.topWeapon.fireRate += 1;
                Game.bottomWeapon.fireRate += 1;
                Game.leftWeapon.fireRate += 1;
                Game.rightWeapon.fireRate += 1;
            }
        }

        @Override
        public Rectangle getBounds() {
            return new Rectangle(500, 560, 130, 50);
        }

        @Override
        public void render(Graphics2D g2d) {
            g2d.setFont(g2d.getFont().deriveFont(20.0f));
            g2d.setColor(Color.WHITE);
            g2d.drawRect(500, 560, 130, 50);
            g2d.drawString("Fire rate", 510, 590);
            g2d.drawString("4", 480, 590);
        }

        @Override
        public void tick() {

        }
    }
}
