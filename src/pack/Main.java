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

        int[][] done = new int[][]{
                {1,2,3,4},
                {5,6,7,8,},
                {9,10,11,12},
                {13,14,15,0},
        };

        int[][] array1 = new int[][]{
                {1,2,0,8},
                {5,6,3,7},
                {9,10,11,12},
                {13,14,15,4}
        };

        int[][] array2 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,15,11},
                {13,14,0,12}
        };

        int[][] array3 = new int[][]{
                {1, 2, 3, 0},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 4}
        };

        int[][] array4 = new int[][]{ //12 ходов
                {1,6,2,3},
                {9,5,8,4},
                {10,0,7,11},
                {13,14,15,12},
        };

        int[][] array5 = new int[][]{ //29 ходов
                {9,14,6,3},
                {1,0,2,4},
                {5,7,8,11},
                {10,13,15,12},
        };


        GameField field = new GameField(array5);
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