import java.util.Scanner;

public class Stewie {

    private static final int MAX_TASKS = 100;
    private Task[] tasks = new Task[MAX_TASKS];
    private int taskCount = 0;

    public static void main(String[] args) {
        new Stewie().run();
    }

    public void run() {
        printGreeting();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            processInput(input);
            input = scanner.nextLine();
        }

        printFarewell();
    }


    private void printGreeting() {
        System.out.println("____________________________________________________________");
        System.out.println("Well well well. I am Stewie.");
        System.out.println("Do enlighten me — what insignificant problem do you bring today?");
        System.out.println("____________________________________________________________");
    }


    private void processInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        switch (command) {
            case "list":
                printTasks();
                break;
            case "mark":
                if (parts.length > 1) markTask(parts[1]);
                break;
            case "unmark":
                if (parts.length > 1) unmarkTask(parts[1]);
                break;
            default:
                addTask(input);
        }
    }


    private void addTask(String input) {
        if (taskCount < MAX_TASKS) {
            tasks[taskCount] = new Task(input);
            taskCount++;
            System.out.println("____________________________________________________________");
            System.out.println("added: " + input);
            System.out.println("____________________________________________________________");
        } else {
            System.out.println("____________________________________________________________");
            System.out.println("What the deuce? ");
            System.out.println("____________________________________________________________");
        }
    }

    private void printTasks() {
        System.out.println("____________________________________________________________");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
        if (taskCount == 0) {
            System.out.println("You got nothing to do hmmm? Hmmmm? Are you sure? 100% sure?");
        }
        System.out.println("____________________________________________________________");
    }

    public void markTask(String arg) {
        try {
            int index = Integer.parseInt(arg) - 1;
            if (index >= 0 && index < taskCount) {
                tasks[index].markDone();
                System.out.println("____________________________________________________________");
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + tasks[index]);
                System.out.println("____________________________________________________________");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index. Do try again.");
        }
    }

    public void unmarkTask(String arg) {
        try {
            int index = Integer.parseInt(arg) - 1;
            if (index >= 0 && index < taskCount) {
                tasks[index].markUndone();
                System.out.println("____________________________________________________________");
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + tasks[index]);
                System.out.println("____________________________________________________________");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index. Do try again.");
        }
    }


    private void printFarewell() {
        System.out.println("____________________________________________________________");
        System.out.println("Very well. Run along now. I have schemes to attend to.");
        System.out.println("____________________________________________________________");
    }
}
