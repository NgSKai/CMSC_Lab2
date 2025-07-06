import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The FXMainPane sets up the GUI layout and handles user interaction.
 * It uses a VBox as the root layout containing two HBoxes:
 * one for the text input and one for the action buttons.
 */
public class FXMainPane extends VBox {

    private Button btnHello, btnHowdy, btnChinese, btnClear, btnExit;
    private Label lblFeedback;
    private TextField txtFeedback;
    private DataManager dataManager;

    public FXMainPane() {
        dataManager = new DataManager();

        // Initialize GUI components
        btnHello = new Button("Hello");
        btnHowdy = new Button("Howdy");
        btnChinese = new Button("Chinese");
        btnClear = new Button("Clear");
        btnExit = new Button("Exit");

        lblFeedback = new Label("Feedback:");
        txtFeedback = new TextField();
        txtFeedback.setEditable(false);

        // Set up HBox for label and textfield
        HBox topBox = new HBox(10);
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(10));
        topBox.getChildren().addAll(lblFeedback, txtFeedback);

        // Set up HBox for buttons
        HBox bottomBox = new HBox(10);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(10));
        bottomBox.getChildren().addAll(btnHello, btnHowdy, btnChinese, btnClear, btnExit);

        // Assign event handlers
        ButtonHandler handler = new ButtonHandler();
        btnHello.setOnAction(handler);
        btnHowdy.setOnAction(handler);
        btnChinese.setOnAction(handler);
        btnClear.setOnAction(handler);
        btnExit.setOnAction(handler);

        // Assemble VBox layout
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(topBox, bottomBox);
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Object source = e.getSource();
            if (source == btnHello) {
                txtFeedback.setText(dataManager.getHello());
            } else if (source == btnHowdy) {
                txtFeedback.setText(dataManager.getHowdy());
            } else if (source == btnChinese) {
                txtFeedback.setText(dataManager.getChinese());
            } else if (source == btnClear) {
                txtFeedback.clear();
            } else if (source == btnExit) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}