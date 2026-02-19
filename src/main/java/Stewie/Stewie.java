package Stewie;

import Stewie.ui.Ui;

import java.io.IOException;
import java.util.Scanner;

/**
 * Stewie is a task management chatbot that helps users track todos,
 * deadlines, and events via a command-line interface.
 *
 * It supports interaction, command parsing, task storage.
 */

public class Stewie {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public String getGreeting() {
        return "Well well well. I am Stewie.\nDo enlighten me, what insignificant problem do you bring today?";
    }

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

    /**
     * Runs the main chatbot loop.
     * Continues reading and executing user commands until an exit command is issued.
     */

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

    public String getResponse(String input) {
        Ui ui = new Ui();   // create fresh UI buffer
        Command command = Parser.parse(input);

        command.execute(tasks, ui, storage);

        String response = ui.getLastMessage();
        ui.clear();

        return response;
    }





    public static void main(String[] args) {
        new Stewie("data/stewie.txt").run();
    }
}

