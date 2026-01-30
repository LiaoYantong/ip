package Stewie;


import java.io.*;
import java.util.ArrayList;

/**
 * Handles loading tasks from disk and saving tasks to disk.
 * Data is stored in a local file using a simple text-based format.
 */

public class Storage {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the data file.
     *
     * @return A list of tasks loaded from disk
     */

    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        File dir = file.getParentFile();

        if (!dir.exists()) dir.mkdir();
        if (!file.exists()) file.createNewFile();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            Task task = Parser.parseTaskFromFile(line);
            if (task != null) tasks.add(task);
        }
        reader.close();
        return tasks;
    }

    public void save(ArrayList<Task> tasks) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (Task task : tasks) {
            writer.write(task.toFileString());
            writer.newLine();
        }
        writer.close();
    }
}


