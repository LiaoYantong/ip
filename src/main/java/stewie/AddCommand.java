package stewie;

import stewie.ui.Ui;

/**
 * Represents a command to add a new task to the task list.
 * <p>
 * When executed, this command adds the specified Task to the provided TaskList,
 * updates the UI with confirmation messages, and saves the updated list to storage.
 */
public class AddCommand extends Command {

    private Task task;

    /**
     * Constructs an AddCommand with the task to be added.
     *
     * @param task The Task object to add to the task list
     */
    public AddCommand(Task task) {

        this.task = task;
    }

    /**
     * Executes the AddCommand.
     * <p>
     * Adds the task to the list, displays messages via the UI, and saves
     * the updated task list to the storage file.
     *
     * @param tasks   The TaskList to which the task will be added
     * @param ui      The UI instance used to display messages
     * @param storage The Storage instance used to persist tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.add(task);
        ui.showMessage("I've added this task:");
        ui.showMessage("  " + task);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");

        try {
            storage.save(tasks.getAll());
        } catch (Exception e) {
            ui.showError("Failed to save tasks to disk.");
        }
    }
}

