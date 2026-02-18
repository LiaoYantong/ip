package Stewie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Event extends Task {
    private List<String> slots;
    private String confirmedSlot;

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Event(String description, List<String> slots) {
        super(description);

        assert slots != null : "Slots list should not be null";
        assert !slots.isEmpty() : "Event must have at least one slot";

        this.slots = new ArrayList<>(slots);  // defensive copy
        this.confirmedSlot = null;
    }
    @Override
    public String getType() {
        return "E";
    }

    /**
     * Confirm one of the tentative slots.
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
