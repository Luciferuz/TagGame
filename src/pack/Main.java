package pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        int[][] array = new int[][]{ //31 ход
                {1, 2, 4, 3},
                {5, 8, 7, 6},
                {9, 10, 14, 12},
                {11, 13, 15, 0},
        };

        int[][] array6 = new int[][]{
                {9,14,6,3},
                {1,7,2,4},
                {5,13,8,11},
                {10,15,12,0},
        };

        GameField field = new GameField(array6);
        Graphics graphics = new Graphics(field);

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

    public static void main(String[] args) {
        launch(args);
    }
}