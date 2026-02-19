package stewie;

/**
 * Represents a generic task with a description and completion status.
 * <p>
 * This is the base class for specific task types like {@link Todo}, {@link Deadline}, and {@link Event}.
 * Provides common functionality such as marking tasks done/undone and getting their description.
 */

public class Task {
    private String description;
    private boolean isDone;

    /**
     * Constructs a new Task with the given description.
     * The task is initially marked as not done.
     *
     * @param description Description of the task
     */
    public Task(String description) {
            this.description = description;
            this.isDone = false;
    }


    /**
     * Marks this task as completed.
     */
    public void markDone() {

        isDone = true;

    }

    /**
     * Marks this task as not completed.
     */
    public void markUndone() {

            isDone = false;
    }

    /**
     * Checks whether this task is completed.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {

            return isDone;
    }

    /**
     * Returns the description of this task.
     *
     * @return Task description
     */
    public String getDescription() {

            return description;
    }

    /**
     * Returns a string representing the type of this task.
     * Subclasses should override to return "T" for Todo, "D" for Deadline, "E" for Event, etc.
     *
     * @return Task type as a string
     */
    public String getType() {

            return " ";
    }

    /**
     * Returns a string suitable for saving this task to a file.
     * Subclasses should override this to provide type-specific serialization.
     *
     * @return File string representation of the task
     */
    public String toFileString() {

        return "";
    }

    /**
     * Returns a human-readable string representation of the task.
     * Shows "[X]" if done, "[ ]" if not done, followed by the description.
     *
     * @return String representation of the task
     */
    @Override
        public String toString() {

        return "[" + (isDone ? "X" : " ") + "] " + description;
        }
    }


