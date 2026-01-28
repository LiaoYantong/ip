package Stewie;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String getType() {
        return "T";
    }

    @Override
    public String toFileString() {
        return "T | " + (isDone() ? "1" : "0") + " | " + getDescription();
    }


    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString();
    }
}
