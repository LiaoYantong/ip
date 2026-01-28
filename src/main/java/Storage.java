import java.io.*;
import java.util.ArrayList;

public class Storage {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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


