package stewie.ui;

import stewie.Stewie;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;


/**
 * JavaFX GUI for the Stewie chatbot.
 * <p>
 * Displays a chat interface where the user can interact with Stewie.
 * Messages are shown as dialog boxes with avatars for the user and Stewie.
 */
public class Main extends Application {

    private Stewie stewie;
    private Image userImage = new Image(this.getClass().getResourceAsStream("/peter.png"));
    private Image stewieImage = new Image(this.getClass().getResourceAsStream("/stewie.png"));

    public Main() {
        String home = System.getProperty("user.home");
        String folderPath = home + "/stewie";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String filePath = folderPath + "/tasks.txt";
        stewie = new Stewie(filePath);
    }
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
        VBox dialogContainer = createDialogContainer();
        ScrollPane scrollPane = createScrollPane(dialogContainer);
        HBox inputBox = createInputBox();

        BorderPane root = new BorderPane();
        root.setCenter(scrollPane);
        root.setBottom(inputBox);

        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Stewie Chatbot");
        stage.show();

        // Show greeting
        dialogContainer.getChildren().add(createDialogBox(stewie.getGreeting(), stewieImage, false));

        
        setupInputActions(inputBox, dialogContainer, scrollPane, stage);
    }

    /** Creates the main container for dialog messages. */
    private VBox createDialogContainer() {
        VBox dialogContainer = new VBox(10);
        return dialogContainer;
    }

    /** Creates a scroll pane wrapping the dialog container. */
    private ScrollPane createScrollPane(VBox dialogContainer) {
        ScrollPane scrollPane = new ScrollPane(dialogContainer);
        scrollPane.setFitToWidth(true);
        return scrollPane;
    }

    /** Creates the input box with text field and send button. */
    private HBox createInputBox() {
        TextField userInput = new TextField();
        Button sendButton = new Button("Send");

        HBox inputBox = new HBox(10, userInput, sendButton);
        HBox.setHgrow(userInput, Priority.ALWAYS);

        inputBox.setUserData(new Object[]{userInput, sendButton}); // Store components for later use
        return inputBox;
    }

    /** Creates a dialog box with the given text and image. */
    private DialogBox createDialogBox(String text, Image img, boolean isUser) {
        return new DialogBox(text, img, isUser);
    }

    /** Sets up user input handling (button and Enter key). */
    private void setupInputActions(HBox inputBox, VBox dialogContainer, ScrollPane scrollPane, Stage stage) {
        Object[] components = (Object[]) inputBox.getUserData();
        TextField userInput = (TextField) components[0];
        Button sendButton = (Button) components[1];

        // Button click
        sendButton.setOnAction(e -> handleUserInput(userInput, dialogContainer, scrollPane, stage));

        // Enter key
        userInput.setOnAction(e -> handleUserInput(userInput, dialogContainer, scrollPane, stage));
    }

    /** Handles a single user input, updates dialog, and closes stage if "bye". */
    private void handleUserInput(TextField userInput, VBox dialogContainer, ScrollPane scrollPane, Stage stage) {
        String input = userInput.getText();
        if (input.isBlank()) return;

        // Show user message
        dialogContainer.getChildren().add(new DialogBox(input, userImage, true));

        // Bot response
        String response = stewie.getResponse(input);
        dialogContainer.getChildren().add(new DialogBox(response, stewieImage, false));

        // Scroll to bottom
        scrollPane.layout();
        scrollPane.setVvalue(1.0);

        userInput.clear();

        // Close bot if bye
        if (input.trim().equalsIgnoreCase("bye")) {
            farewellAndClose(stage);
        }
    }

    /** Shows farewell message delay before closing the stage. */
    private void farewellAndClose(Stage stage) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000); // 2 second delay
                } catch (InterruptedException ignored) {}
                javafx.application.Platform.runLater(stage::close);
            }
        }).start();
    }


    }



