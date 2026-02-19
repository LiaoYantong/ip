package Stewie.ui;

import Stewie.Task;

import java.util.List;
import java.util.Scanner;
public class Ui {

    private StringBuilder output = new StringBuilder();
    public void showGreeting() {
        System.out.println("____________________________________________________________");
        System.out.println("Well well well. I am Stewie.");
        System.out.println("Do enlighten me, what insignificant problem do you bring today?");
        System.out.println("____________________________________________________________");
    }

    public void showFarewell() {
        System.out.println("____________________________________________________________");
        System.out.println("Very well. Run along now. I have schemes to attend to.");
        System.out.println("____________________________________________________________");
    }

    public void showDivider() {

        System.out.println("____________________________________________________________");
    }

    public String readCommand(Scanner scanner) {

        return scanner.nextLine();
    }

    public void showLoadingError() {

        System.out.println("Something went wrong loading your tasks.");
    }

    public void showError(String message) {

        output.append(message).append("\n");
    }

    /**
     * Displays tasks that match a search keyword.
     *
     * @param matches List of matching tasks
     */
    public void showFindResults(List<Task> matches) {
        output.append("Here are the matching tasks in your list:\n");
        int index = 1;
        for (Task task : matches) {
            output.append(index).append(". ").append(task).append("\n");
            index++;
        }
    }

    public String getLastMessage() {
        return output.toString();
    }

    public void clear() {
        output.setLength(0);
    }


    public void showMessage(String message) {

        output.append(message).append("\n");
    }
}

