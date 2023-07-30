package firstgame;

import java.awt.*;

public class HUD extends GameObject {
    protected HUD() {
        super(ID.Hud);
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setFont(g2d.getFont().deriveFont(30.0f));
        g2d.setColor(Color.WHITE);
        g2d.drawString(Integer.toString(Game.getBullets()), 20, 50);
    }

    @Override
    public void tick() {

    }
}
