package Stewie;

import Stewie.ui.Ui;


/**
 * Represents the command to list all tasks in the TaskList.
 * <p>
 * When executed, this command displays all tasks to the user via the provided UI.
 * If the task list is empty, a message indicating no tasks is shown.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command.
     * <p>
     * Iterates through the given TaskList and displays each task.
     *
     * @param tasks   The current TaskList to display
     * @param ui      The UI instance to display messages
     * @param storage Storage instance (not used in this command)
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.size() == 0) {
            ui.showMessage("You have no tasks in your list.");
        } else {
            ui.showMessage("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                ui.showMessage((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

