package stewie;

import stewie.ui.Ui;

/**
 * Represents a command to delete a task from the task list.
 * <p>
 * When executed, this command removes a task at a given index from the TaskList,
 * displays confirmation messages via the UI, and saves the updated list to storage.
 */
public class DeleteCommand extends Command {

    private int index;

    /**
     * Constructs a DeleteCommand for a specific task index.
     *
     * @param index 1-based index of the task to delete
     */
    public DeleteCommand(int index) {

        this.index = index;
    }

    /**
     * Executes the DeleteCommand.
     * <p>
     * Removes the task at the specified index, updates the UI with messages,
     * and attempts to save the updated task list to storage.
     * If the index is invalid, an error is displayed.
     *
     * @param tasks   TaskList from which a task will be removed
     * @param ui      UI instance used to display messages
     * @param storage Storage instance used to persist the task list
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task removed = tasks.remove(index - 1);
            ui.showMessage("Noted. I've removed this task:");
            ui.showMessage("  " + removed);
            ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
            storage.save(tasks.getAll());
        } catch (IndexOutOfBoundsException e) {
            ui.showError("Invalid task number!");
        } catch (Exception e) {
            ui.showError("Failed to save tasks to disk.");
        }
    }
}

