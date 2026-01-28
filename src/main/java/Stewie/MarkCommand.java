package Stewie;

public class MarkCommand extends Command {

    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

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
