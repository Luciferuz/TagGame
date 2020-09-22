package pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int[][] arrayField = new int[][]{
                                        {1,2,3,4},
                                        {5,7,6,8},
                                        {9,11,10,12},
                                        {13,14,0,15}
        };
        GameField field = new GameField(arrayField);

        //field.newRandomGame();

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


    public static void main(String[] args) {
        launch(args);
    }
}