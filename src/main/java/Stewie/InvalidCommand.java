package Stewie;

public class InvalidCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showError("I do not understand your pathetic command.");
    }
}
