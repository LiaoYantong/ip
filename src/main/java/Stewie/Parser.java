package Stewie;

/**
 * Parses user input strings and converts them into executable commands.
 */

public class Parser {

    /**
     * Parses a full user command and returns the corresponding Command object.
     * @return Command representing the user instruction
     */
    public static Command parse(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        switch (command) {
            case "list":
                return new ListCommand();
            case "todo":
                return new AddCommand(new Todo(parts[1]));
            case "deadline":
                return new AddCommand(new Deadline(parts[1], extractBy(parts[1])));
            case "event":
                return new AddCommand(new Event(parts[1], extractFrom(parts[1]), extractTo(parts[1])));
            case "delete":
                return new DeleteCommand(Integer.parseInt(parts[1]));
            case "mark":
                return new MarkCommand(Integer.parseInt(parts[1]));
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(parts[1]));
            case "bye":
                return new ExitCommand();
            default:
                return new InvalidCommand();
        }
    }

    public static Task parseTaskFromFile(String line) {
        if (line == null || line.isBlank()) return null;

        String[] parts = line.split(" \\| ");
        if (parts.length < 3) return null;

        String type = parts[0].trim();
        boolean isDone = parts[1].trim().equals("1");
        String description = parts[2].trim();

        Task task = null;

        switch (type) {
            case "T":
                task = new Todo(description);
                break;

            case "D":
                if (parts.length < 4) return null;
                task = new Deadline(description, parts[3].trim());
                break;

            case "E":
                if (parts.length < 5) return null;
                task = new Event(description, parts[3].trim(), parts[4].trim());
                break;

            default:
                return null;
        }

        if (task != null && isDone) {
            task.markDone();
        }

        return task;
    }


    public static String extractBy(String input) {
        String[] parts = input.split("/by", 2);
        if (parts.length < 2 || parts[1].isBlank()) {
            return null;
        }
        return parts[1].trim();
    }


    public static String extractFrom(String input) {
        String[] parts = input.split("/from", 2);
        if (parts.length < 2 || parts[1].isBlank()) {
            return null;
        }
        String fromPart = parts[1].split("/to", 2)[0].trim();
        return fromPart;
    }


    public static String extractTo(String input) {
        String[] parts = input.split("/to", 2);
        if (parts.length < 2 || parts[1].isBlank()) {
            return null;
        }
        return parts[1].trim();
    }




}

