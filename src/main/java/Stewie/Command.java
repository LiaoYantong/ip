package Stewie;

/**
 * Represents an executable user command.
 * Subclasses define specific chatbot actions.
 */

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public boolean isExit() {
        return false;
    }
}

