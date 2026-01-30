package Stewie;

import java.util.List;


/**
 * Finds tasks containing a keyword.
 */
public class FindCommand extends Command {

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> matches = tasks.find(keyword);
        ui.showFindResults(matches);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
