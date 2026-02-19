package Stewie.ui;

import Stewie.Stewie;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX GUI for the Stewie chatbot.
 * <p>
 * Displays a chat interface where the user can interact with Stewie.
 * Messages are shown as dialog boxes with avatars for the user and Stewie.
 */
public class Main extends Application {
    private Stewie stewie = new Stewie("data/stewie.txt");
    private Image userImage = new Image(this.getClass().getResourceAsStream("/peter.png"));
    private Image stewieImage = new Image(this.getClass().getResourceAsStream("/stewie.png"));

    /**
     * Starts the JavaFX application.
     * <p>
     * Sets up the GUI with a scrollable dialog container, input field, send button,
     * and displays messages from both the user and Stewie.
     *
     * @param stage Primary stage provided by JavaFX
     */
    @Override
    public void start(Stage stage) {
        VBox dialogContainer = new VBox(10);
        ScrollPane scrollPane = new ScrollPane(dialogContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setVvalue(1.0);

        TextField userInput = new TextField();
        Button sendButton = new Button("Send");

        HBox inputBox = new HBox(10, userInput, sendButton);

        BorderPane root = new BorderPane();
        root.setCenter(scrollPane);
        root.setBottom(inputBox);
        Scene scene = new Scene(root, 400, 500);

        dialogContainer.getChildren().add(new DialogBox(stewie.getGreeting(), stewieImage, false));


        // When button clicked
        sendButton.setOnAction(event -> {
            String input = userInput.getText();
            // User message
            dialogContainer.getChildren().add(new DialogBox(input, userImage, true));


            // Stewie response
            String response = stewie.getResponse(input);
            dialogContainer.getChildren().add(new DialogBox(response, stewieImage, false));

            userInput.clear();
        });

        stage.setScene(scene);
        stage.setTitle("Stewie Chatbot");
        stage.show();
    }
}


