package firstgame;

import java.awt.*;

public class HUD extends GameObject {
    protected HUD() {
        super(ID.Hud);
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setFont(g2d.getFont().deriveFont(20.0f));
        g2d.setColor(Color.WHITE);
        g2d.drawString("Bullets: ", 10, 50);
        g2d.drawString(Integer.toString(Game.getBullets()), 100, 50);
        g2d.drawString("Score: ", 10, 80);
        g2d.drawString(Integer.toString(Game.getScore()), 100, 80);
    }

    @Override
    public void tick() {

    }
}
