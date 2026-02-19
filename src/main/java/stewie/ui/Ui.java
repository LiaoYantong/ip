package stewie.ui;

import stewie.Task;

import java.util.List;
import java.util.Scanner;

/**
 * Handles user interaction for the Stewie chatbot.
 * <p>
 * Provides methods for displaying messages, errors, dividers, greetings,
 * farewells, and search results. Supports capturing output for GUI or testing
 * by storing messages in a buffer.
 */
public class Ui {

    private StringBuilder output = new StringBuilder();
    /**
     * Displays the greeting message when the chatbot starts.
     */
    public void showGreeting() {
        System.out.println("____________________________________________________________");
        System.out.println("Well well well. I am Stewie.");
        System.out.println("Do enlighten me, what insignificant problem do you bring today?");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays the farewell message when the chatbot exits.
     */
    public void showFarewell() {
        System.out.println("____________________________________________________________");
        System.out.println("Very well. Run along now. I have schemes to attend to.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints a visual divider line to separate messages in the console.
     */
    public void showDivider() {

        System.out.println("____________________________________________________________");
    }

    /**
     * Reads the next line of user input from the provided scanner.
     *
     * @param scanner Scanner connected to user input
     * @return The line of input entered by the user
     */
    public String readCommand(Scanner scanner) {

        return scanner.nextLine();
    }

    /**
     * Displays an error message when loading tasks fails.
     */
    public void showLoadingError() {

        System.out.println("Something went wrong loading your tasks.");
    }

    /**
     * Records an error message in the internal output buffer.
     *
     * @param message Error message to display or log
     */
    public void showError(String message) {

        output.append(message).append("\n");
    }

    /**
     * Displays tasks that match a search keyword.
     *
     * @param matches List of matching tasks
     */
    public void showFindResults(List<Task> matches) {
        output.append("Here are the matching tasks in your list:\n");
        int index = 1;
        for (Task task : matches) {
            output.append(index).append(". ").append(task).append("\n");
            index++;
        }
    }

    /**
     * Returns the last message(s) captured in the output buffer.
     *
     * @return Concatenated string of all messages in the buffer
     */
    public String getLastMessage() {
        return output.toString();
    }

    public void clear() {
        output.setLength(0);
    }


    /**
     * Adds a normal message to the output buffer.
     *
     * @param message Message to record
     */
    public void showMessage(String message) {

        output.append(message).append("\n");
    }
}

