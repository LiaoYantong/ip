package Stewie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task that must be completed before a specific date and time.
 */
public class Deadline extends Task {
    private LocalDate by;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String byStr) {
        super(description);
        try {
            this.by = LocalDate.parse(byStr, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Use yyyy-MM-dd. Storing as plain string.");
            this.by = null;
        }
    }

    @Override
    public String getType() {
        return "D";
    }

    @Override
    public String toFileString() {
        String dateStr = (by != null) ? by.format(INPUT_FORMAT) : "unknown";
        return "D | " + (isDone() ? "1" : "0") + " | " + getDescription() + " | " + by;
    }


    @Override
    public String toString() {
        String dateStr = (by != null) ? by.format(OUTPUT_FORMAT) : "unknown date";
        return "[D]" + super.toString() + " (by: " + dateStr + ")";
    }

    public LocalDate getBy() {
        return by;
    }
}
