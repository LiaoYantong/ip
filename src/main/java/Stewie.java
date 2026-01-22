import java.util.Scanner;

public class Stewie {

    private static final int MAX_TASKS = 100;
    private String[] tasks = new String[MAX_TASKS];
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
        if (input.equals("list")) {
            printTasks();
        } else {
            addTask(input);
        }
    }


    private void addTask(String input) {
        if (taskCount < MAX_TASKS) {
            tasks[taskCount] = input;
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


    private void printFarewell() {
        System.out.println("____________________________________________________________");
        System.out.println("Very well. Run along now. I have schemes to attend to.");
        System.out.println("____________________________________________________________");
    }
}
