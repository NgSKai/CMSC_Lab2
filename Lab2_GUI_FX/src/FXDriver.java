import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The FXDriver class is the entry point for the JavaFX application.
 * It sets up the stage and launches the GUI.
 */
public class FXDriver extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX app
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMainPane root = new FXMainPane();
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Hello World GUI");
        stage.show();
    }
}