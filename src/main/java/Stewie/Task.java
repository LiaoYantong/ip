package Stewie;

/**
 * Represents a generic task with a description and completion status.
 * This class is the superclass for specific task types.
 */

public class Task {
        private String description;
        private boolean isDone;

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

        public boolean isDone() {
            return isDone;
        }

        public String getDescription() {
            return description;
        }

    public String getType() {
        return " ";
    }

    public String toFileString() {
        return "";
    }

    @Override
        public String toString() {
            return "[" + (isDone ? "X" : " ") + "] " + description;
        }
    }


