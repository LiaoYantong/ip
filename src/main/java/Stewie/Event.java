package Stewie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Event extends Task {
    private LocalDate from;
    private LocalDate to;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Event(String description, String fromStr, String toStr) {
        super(description);
        try {
            this.from = LocalDate.parse(fromStr, INPUT_FORMAT);
            this.to = LocalDate.parse(toStr, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Use yyyy-MM-dd. Storing as plain string.");
            this.from = null;
            this.to = null;
        }
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String toFileString() {
        String fromStr = (from != null) ? from.format(INPUT_FORMAT) : "unknown";
        String toStr = (to != null) ? to.format(INPUT_FORMAT) : "unknown";
        return "E | " + (isDone() ? "1" : "0") + " | " + getDescription() + " | " + from + " | " + to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }


    @Override
    public String toString() {
        String fromStr = (from != null) ? from.format(OUTPUT_FORMAT) : "unknown";
        String toStr = (to != null) ? to.format(OUTPUT_FORMAT) : "unknown";
        return "[E]" + super.toString() + " (from: " + fromStr + " to: " + toStr + ")";
    }
}
