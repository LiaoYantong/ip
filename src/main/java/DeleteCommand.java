public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

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

