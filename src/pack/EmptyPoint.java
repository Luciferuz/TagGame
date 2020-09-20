package pack;

public class EmptyPoint {
    private int x;
    private int y;

    public EmptyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setNewPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
