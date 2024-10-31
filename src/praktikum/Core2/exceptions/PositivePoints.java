package praktikum.Core2.exceptions;

public class PositivePoints {
    private int positionX;
    private int positionY;

    public PositivePoints(int positionX, int positionY) throws IllegalArgumentException {
        if(positionX < 0 || positionY < 0) {
            throw new IllegalArgumentException();
        }
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }
}
