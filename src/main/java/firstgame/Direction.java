package firstgame;

public enum Direction {
    Top(0, -1),
    Bottom(0, 1),
    Left(-1, 0),
    Right(1, 0);

    private final int velX;
    private final int velY;

    private Direction(int velX, int velY) {
        this.velX = velX;
        this.velY = velY;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }
}
