package Stewie;

/**
 * Represents a Todo task.
 * <p>
 * A Todo is a simple task with only a description and completion status,
 * without any associated date or time.
 */
public class Todo extends Task {

    /**
     * Constructs a Todo task with the given description.
     *
     * @param description Description of the task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the type identifier of this task.
     *
     * @return "T" to indicate a Todo task
     */
    @Override
    public String getType() {
        return "T";
    }

    /**
     * Returns a string suitable for saving to a file.
     * Format: "T | 0/1 | description"
     *
     * @return File string representation of this Todo
     */
    @Override
    public String toFileString() {
        return "T | " + (isDone() ? "1" : "0") + " | " + getDescription();
    }


    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString();
    }
}
