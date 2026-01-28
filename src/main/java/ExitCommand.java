public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Goodbye! Stewie will be back to conquer your world.");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}

