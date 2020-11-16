package pack;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import java.util.List;

public class Controller {

    @FXML
    private FlowPane flowpane;
    private GameField field;
    private Graphics graphics;
    private Automation automation;
    private List<GameField> result;
    private int size;
    private int currentIndex = 0;
    private boolean alreadyComputed = false;

    private void setImagesOnFlowPane() {
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

    @FXML
    public void startAuto() { //тут типо сделать запуск ии авторешатель
        if (!alreadyComputed) {
            automation = new Automation(field);
            alreadyComputed = true;
        }
        result = automation.getSolution();
        showMoves();
    }

    //будет показывать ходы по нажатию кнопки
    private void showMoves() {
        nextMove();
        currentIndex++;
    }

    private void nextMove() {
        if (currentIndex >= result.size()) {
            graphics.setDoneAlert(result.size());
            currentIndex = 0;
        }
        graphics.setField(result.get(currentIndex));
        graphics.updateUI();
    }

    @FXML
    public void generateNewGame() {
        alreadyComputed = false;
        currentIndex = 0;
        field.newRandomGame();
        graphics.setField(field);
        graphics.updateUI();
    }

}