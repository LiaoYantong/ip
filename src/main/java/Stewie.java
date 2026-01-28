import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.List;


public class Stewie {

    private static final String DATA_DIR = "data";
    private static final String DATA_FILE = "data/stewie.txt";
    private static final int MAX_TASKS = 100;
    private ArrayList<Task> tasks = new ArrayList<>();
    private int taskCount = 0;

    public static void main(String[] args) {
        new Stewie().run();
    }

    public void run() {
        loadTasks();
        printGreeting();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            processInput(input);
            input = scanner.nextLine();
        }

        printFarewell();
    }

    private void loadTasks() {
        File file = new File(DATA_FILE);

        try {
            File dir = new File(DATA_DIR);
            if (!dir.exists()) {
                dir.mkdir();
            }

            if (!file.exists()) {
                file.createNewFile();
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("What the duece? Something went wrong loading your tasks hahaha.");
        }
    }

    private Task parseTask(String line) {
        try {
            String[] parts = line.split("\\s*\\|\\s*");
            String type = parts[0];
            boolean isDone = parts[1].equals("1");

            Task task;
            switch (type) {
                case "T":
                    task = new Todo(parts[2]);
                    break;
                case "D":
                    task = new Deadline(parts[2], parts[3]);
                    break;
                case "E":
                    task = new Event(parts[2], parts[3], parts[4]);
                    break;
                default:
                    return null;
            }

            if (isDone) {
                task.markDone();
            }
            return task;

        } catch (Exception e) {
            return null;
        }
    }

    private void saveTasks() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE));
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Blast! Couldn't save your brilliant plans.");
        }
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
            case "todo":
                if (parts.length > 1) addTask(new Todo(parts[1]));
                break;
            case "deadline":
                if (parts.length > 1) addDeadline(parts[1]);
                break;
            case "event":
                if (parts.length > 1) addEvent(parts[1]);
                break;
            case "delete":
                if (parts.length > 1) deleteTask(parts[1]);
                break;
            default:
                System.out.println("What the deuce?");
        }
    }


    private void addTask(Task task) {
        if (taskCount < MAX_TASKS) {
            tasks.add(task);
            saveTasks();
            System.out.println("____________________________________________________________");
            System.out.println("I've added this task. Remember to say Thank you next time:");
            System.out.println("  " + task);
            System.out.println("  Now you have " + taskCount + " tasks in the list.");
            System.out.println("____________________________________________________________");
        } else {
            System.out.println("____________________________________________________________");
            System.out.println("What the deuce? ");
            System.out.println("____________________________________________________________");
        }
    }

    private void deleteTask(String arg) {
        try {
            int index = Integer.parseInt(arg) - 1;
            if (index >= 0 && index < tasks.size()) {
                Task removed = tasks.remove(index);
                saveTasks();

                System.out.println("____________________________________________________________");
                System.out.println("Noted. I've removed this task:");
                System.out.println(" " + removed);
                System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                System.out.println("____________________________________________________________");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index. Do try again.");
        }
    }


    private void addDeadline(String arg) {
        String[] split = arg.split("/by", 2);
        if (split.length < 2) {
            System.out.println("Gimme a deadline.");
            return;
        }
        String description = split[0].trim();
        String by = split[1].trim();
        addTask(new Deadline(description, by));
    }

    private void addEvent(String arg) {
        String[] splitFrom = arg.split("/from", 2);
        if (splitFrom.length < 2) {
            System.out.println("Please provide a /from for event.");
            return;
        }
        String description = splitFrom[0].trim();
        String[] splitTo = splitFrom[1].split("/to", 2);
        if (splitTo.length < 2) {
            System.out.println("Please provide a /to for event.");
            return;
        }
        String from = splitTo[0].trim();
        String to = splitTo[1].trim();
        addTask(new Event(description, from, to));
    }

    private void printTasks() {
        System.out.println("____________________________________________________________");
        if (taskCount == 0) {
            System.out.println("You got nothing to do? Hmmm? Hmmmm? Are you sure?");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + "." + tasks.get(i));
            }
        }
        System.out.println("____________________________________________________________");
    }


    public void markTask(String arg) {
        try {
            int index = Integer.parseInt(arg) - 1;
            if (index >= 0 && index < taskCount) {
                tasks.get(index).markDone();
                saveTasks();
                System.out.println("____________________________________________________________");
                System.out.println("Took you long enough to get this done:");
                System.out.println("  " + tasks.get(index));
                System.out.println("____________________________________________________________");
            }
        } catch (NumberFormatException e) {
            System.out.println("What the deuce? ");
        }
    }

    public void unmarkTask(String arg) {
        try {
            int index = Integer.parseInt(arg) - 1;
            if (index >= 0 && index < taskCount) {
                tasks.get(index).markUndone();
                saveTasks();
                System.out.println("____________________________________________________________");
                System.out.println("Go get this done:");
                System.out.println("  " + tasks.get(index));
                System.out.println("____________________________________________________________");
            }
        } catch (NumberFormatException e) {
                System.out.println("What the deuce? ");
        }
    }


    private void printFarewell() {
        System.out.println("____________________________________________________________");
        System.out.println("Very well. Run along now. I have schemes to attend to.");
        System.out.println("____________________________________________________________");
    }
}
