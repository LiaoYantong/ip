package stewie;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void testFindTasks() {
        TaskList tasks = new TaskList();
        tasks.add(new Todo("Buy groceries"));
        tasks.add(new Todo("Read book"));
        tasks.add(new Todo("Buy milk"));

        List<Task> results = tasks.find("buy");
        assertEquals(2, results.size(), "Should find 2 tasks containing 'buy'");

        results = tasks.find("read");
        assertEquals(1, results.size(), "Should find 1 task containing 'read'");

        results = tasks.find("nothing");
        assertTrue(results.isEmpty(), "Should find no matching tasks");
    }
}

