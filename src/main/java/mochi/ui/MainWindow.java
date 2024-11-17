package mochi.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import mochi.Mochi;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Mochi mochi;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/kenzo.jpg"));
    private Image mochiImage = new Image(this.getClass().getResourceAsStream("/images/coffee.jpg"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        Ui.initialize(this);
    }

    /**
     * Injects the Duke instance
     */
    public void setMochi() {
        mochi = new Mochi();
        Ui.response("Hello! I'm Mochi. How can I help you today?");
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    public void displayResponse(String input) {
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(input, mochiImage));
    }

    @FXML
    private void handleUserInput() throws InterruptedException {
        String input = userInput.getText();
        dialogContainer.getChildren().add(DialogBox.getUserDialog(input, userImage));
        String response = mochi.getResponse(input);
        if (response.contains("Bye")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Shutdown");
            alert.setHeaderText("Shutdown");
            alert.setContentText("Goodbye!");
            alert.showAndWait();
            Platform.exit();
        }
        //displayResponse(response);
        userInput.clear();
    }

}
