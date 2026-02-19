package Stewie;

import Stewie.ui.Ui;

public class InvalidCommand extends Command {

    private String message;

    public InvalidCommand() {
        this.message = "I do not understand your pathetic command.";
    }

    public InvalidCommand(String message) {
        this.message = message;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showError("I do not understand your pathetic command.");
    }
}
