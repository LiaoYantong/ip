package stewie;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void testExtractSlots() {
        String input = "event Team meeting /slot 2026-02-20 /slot 2026-02-21 /slot 2026-02-22";
        List<String> slots = Parser.extractSlots(input);

        assertEquals(3, slots.size(), "Should extract 3 slots");
        assertEquals("2026-02-20", slots.get(0));
        assertEquals("2026-02-21", slots.get(1));
        assertEquals("2026-02-22", slots.get(2));

        String inputNoSlots = "event Team meeting";
        List<String> emptySlots = Parser.extractSlots(inputNoSlots);
        assertTrue(emptySlots.isEmpty(), "Should return empty list when no slots");
    }
}

