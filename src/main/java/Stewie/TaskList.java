package Stewie;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks.
 * <p>
 * Provides operations to add, remove, retrieve, and search tasks.
 * Internally backed by an {@link ArrayList}.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {

        tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with an existing list of tasks.
     *
     * @param tasks Pre-existing list of tasks; must not be null
     */
    public TaskList(ArrayList<Task> tasks) {
        assert tasks != null : "Task list must be initialized";
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task Task to add
     */
    public void add(Task task) {

        tasks.add(task);
    }

    /**
     * Retrieves the task at the specified index.
     *
     * @param index Index of the task (0-based)
     * @return Task at the given index
     */
    public Task get(int index) {

        return tasks.get(index);
    }

    /**
     * Removes the task at the specified index.
     *
     * @param index Index of the task to remove (0-based)
     * @return The removed task
     */
    public Task remove(int index) {

        return tasks.remove(index);
    }

    public int size() {

        return tasks.size();
    }

    /**
     * Finds tasks whose descriptions contain the given keyword.
     *
     * @param keyword Keyword to search for
     * @return List of matching tasks
     */
    public List<Task> find(String keyword) {
        List<Task> matches = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matches.add(task);
            }
        }
        return matches;
    }


    /**
     * Returns all tasks in the list.
     * <p>
     * Modifications to the returned list will affect this TaskList.
     *
     * @return Internal ArrayList of tasks
     */
    public ArrayList<Task> getAll() {

        return tasks;
    }
}

