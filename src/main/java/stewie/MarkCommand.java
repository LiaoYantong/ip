package stewie;

import stewie.ui.Ui;

/**
 * Represents a command to mark a task as done in the TaskList.
 * <p>
 * When executed, this command marks the task at the given index as completed
 * and saves the updated task list to storage.
 */
public class MarkCommand extends Command {

    private int index;

    /**
     * Constructs a MarkCommand for a given task index.
     *
     * @param index The 1-based index of the task to mark as done.
     *              Must be validated before creating the command.
     */
    public MarkCommand(int index) {
        assert index >= 0 
                : "Index should be validated before calling mark()";
        this.index = index;
    }

    /**
     * Executes the mark command.
     * <p>
     * Marks the specified task as done, shows a confirmation message to the user,
     * and saves the updated TaskList to storage.
     * Handles invalid indexes and storage errors gracefully.
     *
     * @param tasks   The TaskList containing the task to mark
     * @param ui      The UI instance to display messages
     * @param storage The storage instance to save tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task t = tasks.get(index - 1);
            t.markDone();
            ui.showMessage("Nice! I've marked this task as done:");
            ui.showMessage("  " + t);
            storage.save(tasks.getAll());
        } catch (IndexOutOfBoundsException e) {
            ui.showError("Invalid task number!");
        } catch (Exception e) {
            ui.showError("Failed to save tasks to disk.");
        }
    }
}
