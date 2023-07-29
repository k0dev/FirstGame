package firstgame;

import java.awt.*;

public abstract class GameObject {

    public final ID id;
    protected GameObject(ID id) {
        this.id = id;
    }

    public abstract void render(Graphics2D g2d);
    public abstract void tick();
}
