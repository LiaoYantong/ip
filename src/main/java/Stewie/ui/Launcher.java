package Stewie.ui;



import javafx.application.Application;

/**
 * Launcher class for the Stewie chatbot GUI.
 * <p>
 * This class contains the main entry point to start the JavaFX application.
 * It delegates to the Main class by calling Application.launch().
 */

public class Launcher {
    /**
     * Main method to launch the JavaFX GUI.
     *
     * @param args Command-line arguments (ignored)
     */
    public static void main(String[] args) {

        Application.launch(Main.class, args);
    }
}
