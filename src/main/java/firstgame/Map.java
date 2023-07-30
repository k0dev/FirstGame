package firstgame;

import java.awt.*;

public class Map extends GameObject {

    private int gameSize;
    private int size;
    protected Map(int gameSize) {
        super(ID.Map);
        this.gameSize = gameSize;
        size = gameSize / 8;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(new Color(64, 34, 5));
        g2d.fillRect(0, 0, gameSize, gameSize);
        g2d.setColor(new Color(54, 88, 30));
        g2d.fillRect(gameSize/2 - size/2, 0, size, gameSize);
        g2d.fillRect(0, gameSize/2 - size/2, gameSize, size);
    }

    @Override
    public void tick() {

    }
}
