public class Todo extends Task{
    public Todo(String description) {
        super(description);
    }

    @Override
    public String getType() {
        return "T";
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString();
    }
}
