package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class RetroGamesApplication extends Application implements Serializable {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RetroGamesApplication.class.getResource("homepage.fxml"));
        window = primaryStage;

        //--------------
        // Layout
        //--------------
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);

        // Set the stage title and display it
        window.setTitle("Retro Games Application");
        window.setScene(scene);
        window.show();
    }
}
