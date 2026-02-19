package stewie;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an event task with one or more tentative slots.
 * <p>
 * An Event task has a description and a list of possible time slots.
 * One of the slots can be confirmed as the final event time.
 */
public class Event extends Task {
    private List<String> slots;
    private String confirmedSlot;

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    /**
     * Constructs an Event task with a description and list of tentative slots.
     *
     * @param description Description of the event
     * @param slots       List of tentative time slots; must not be null or empty
     * @throws AssertionError if slots is null or empty
     */
    public Event(String description, List<String> slots) {
        super(description);

        assert slots != null : "Slots list should not be null";
        assert !slots.isEmpty() : "Event must have at least one slot";

        this.slots = new ArrayList<>(slots);  // defensive copy
        this.confirmedSlot = null;
    }

    /**
     * Returns the type identifier of this task.
     *
     * @return "E" for Event
     */
    @Override
    public String getType() {
        return "E";
    }

    /**
     * Confirms one of the tentative slots as the final event time.
     *
     * @param index Index of the slot to confirm (0-based)
     * @throws AssertionError if index is out of bounds
     */
    public void confirmSlot(int index) {
        assert index >= 0 && index < slots.size()
                : "Slot index must be within valid range";

        confirmedSlot = slots.get(index);
    }

    /**
     * Returns true if a slot has been confirmed.
     */
    public boolean isConfirmed() {
        return confirmedSlot != null;
    }

    public List<String> getSlots() {
        return new ArrayList<>(slots);
    }

    public String getConfirmedSlot() {
        return confirmedSlot;
    }

    /**
     * Returns a string representation of the task suitable for saving to a file.
     *
     * @return Formatted string for file storage
     */
    @Override
    public String toFileString() {
        if (isConfirmed()) {
            return "E | " + (isDone() ? "1" : "0")
                    + " | " + getDescription()
                    + " | CONFIRMED | " + confirmedSlot;
        } else {
            return "E | " + (isDone() ? "1" : "0")
                    + " | " + getDescription()
                    + " | TENTATIVE | " + String.join(",", slots);
        }
    }



    /**
     * Returns a human-readable string representation of this task.
     *
     * @return Formatted string for display
     */
    @Override
    public String toString() {
        if (isConfirmed()) {
            return "[E]" + super.toString()
                    + " (at: " + confirmedSlot + ")";
        } else {
            return "[E]" + super.toString()
                    + " (tentative: " + slots + ")";
        }
    }
}
