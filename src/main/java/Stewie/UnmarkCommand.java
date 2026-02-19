package Stewie;

import Stewie.ui.Ui;

/**
 * Represents a command to mark a task as not done (unmark it).
 * <p>
 * When executed, this command updates the specified task's status
 * to "not done" and saves the updated task list to storage.
 */
public class UnmarkCommand extends Command {

    private int index;

    /**
     * Constructs an UnmarkCommand for the task at the given index.
     *
     * @param index 1-based index of the task to unmark
     */
    public UnmarkCommand(int index) {

        this.index = index;
    }

    /**
     * Executes the unmark command on the provided task list.
     * <p>
     * Marks the task at {@code index} as not done, updates the UI
     * with a message, and attempts to save the updated task list
     * to storage. Handles invalid index and save errors gracefully.
     *
     * @param tasks   TaskList containing all tasks
     * @param ui      Ui for showing messages
     * @param storage Storage to persist task list
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task t = tasks.get(index - 1);
            t.markUndone();
            ui.showMessage("OK! I've marked this task as not done yet:");
            ui.showMessage("  " + t);
            storage.save(tasks.getAll());
        } catch (IndexOutOfBoundsException e) {
            ui.showError("Invalid task number!");
        } catch (Exception e) {
            ui.showError("Failed to save tasks to disk.");
        }
    }
}
