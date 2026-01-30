package Stewie;

import java.util.List;
import java.util.Scanner;
public class Ui {

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
        System.out.println(message);
    }

    /**
     * Displays tasks that match a search keyword.
     *
     * @param matches List of matching tasks
     */
    public void showFindResults(List<Task> matches) {
        System.out.println("Here are the matching tasks in your list:");
        int index = 1;
        for (Task task : matches) {
            System.out.println(index + "." + task);
            index++;
        }
    }


    public void showMessage(String message) {
        System.out.println(message);
    }
}

