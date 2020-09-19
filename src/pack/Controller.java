package pack;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class Controller {

    @FXML
    private FlowPane flowpane;
    private GameField field;
    private Graphics graphics;
    private int size;

    public void setImagesOnFlowPane() {
        flowpane.getChildren().clear();
        size = field.getSize();
        ImageView[][] images = graphics.getImages();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                flowpane.getChildren().add(images[x][y]);
            }
        }
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
        setImagesOnFlowPane();
    }

    public void setGameField(GameField field) {
        this.field = field;
    }
}
