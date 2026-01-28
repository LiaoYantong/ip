package Stewie;

import java.io.IOException;
import java.util.Scanner;

public class Stewie {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Stewie(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showGreeting();

        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);

        while (!isExit) {
            String fullCommand = ui.readCommand(scanner);
            ui.showDivider();
            Command command = Parser.parse(fullCommand);
            command.execute(tasks, ui, storage);
            isExit = command.isExit();
            ui.showDivider();
        }

        ui.showFarewell();
    }

    public static void main(String[] args) {
        new Stewie("data/stewie.txt").run();
    }
}

