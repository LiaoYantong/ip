package Stewie;

import Stewie.ui.Ui;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Goodbye! Very well. Run along now. I have schemes to attend to.");
    }

    @Override
    public boolean isExit() {

        return true;
    }
}

