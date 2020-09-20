package pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    private static final int size = 4;

    @Override
    public void start(Stage stage) throws Exception {
        GameField field = new GameField(size);
        field.newGame();
        Graphics graphics = new Graphics(field);
        field.printField();

        stage.setTitle("Пятнашки");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pack/gameform.fxml"));
        Parent content = loader.load();
        Controller controller = loader.getController();

        controller.setGameField(field);
        controller.setGraphics(graphics);

        Scene scene = new Scene(content, 500, 320);
        stage.setScene(scene);
        content.requestFocus();
        stage.show();
    }


    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }
}