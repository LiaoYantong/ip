package Stewie;

import Stewie.ui.Ui;

/**
 * Represents the command to exit the chatbot.
 * <p>
 * When executed, this command signals the chatbot to terminate its main loop
 * and optionally displays a farewell message to the user.
 */
public class ExitCommand extends Command {

    /**
     * Executes the exit command.
     * <p>
     * Displays a farewell message using the provided UI.
     *
     * @param tasks   The current TaskList (not modified by this command)
     * @param ui      The UI instance to display messages
     * @param storage The storage instance (not modified by this command)
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Goodbye! Very well. Run along now. I have schemes to attend to.");
    }

    /**
     * Indicates that this command is an exit command.
     *
     * @return true, because this command ends the chatbot session
     */
    @Override
    public boolean isExit() {

        return true;
    }
}

