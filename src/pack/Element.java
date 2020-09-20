package pack;

public class Element {
    private Element previous; //до
    private GameField field; //после

    public Element(Element previous, GameField field) {
        this.previous = previous;
        this.field = field;
    }
    public GameField getField() {
        return field;
    }
}
