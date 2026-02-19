package stewie;

import stewie.ui.Ui;

/**
 * Represents a command that is invalid or unrecognized by the chatbot.
 * <p>
 * When executed, this command displays an error message to the user
 * indicating that the input was not understood.
 */
public class InvalidCommand extends Command {

    private String message;

    /**
     * Constructs an InvalidCommand with a default error message.
     */
    public InvalidCommand() {
        this.message = "I do not understand your pathetic command.";
    }

    /**
     * Constructs an InvalidCommand with a custom error message.
     *
     * @param message Custom error message to display
     */
    public InvalidCommand(String message) {
        this.message = message;
    }
    /**
     * Executes the invalid command.
     * <p>
     * Displays the error message to the user using the UI.
     *
     * @param tasks   The current TaskList (not used)
     * @param ui      UI instance to display the error
     * @param storage Storage instance (not used)
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showError("I do not understand your pathetic command.");
    }
}
