package pack;

public class Element {

    private Element previous; //ссылка на предыдущий
    private GameField field; //текущий

    public Element(Element previous, GameField field) {
        this.previous = previous;
        this.field = field;
    }

    public Element getPrevious() {
        return previous;
    }

    public GameField getField() {
        return field;
    }
}
