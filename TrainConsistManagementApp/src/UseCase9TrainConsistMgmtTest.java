import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // 🔹 Helper method (same as UC9 logic)
    Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    // ✅ 1. Basic grouping check
    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        assertEquals(2, result.get("Sleeper").size());
    }

    // ✅ 2. Multiple bogies same group
    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> list = List.of(
                new Bogie("AC Chair", 56),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        assertEquals(2, result.get("AC Chair").size());
    }

    // ✅ 3. Different types → different groups
    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        assertEquals(3, result.size());
    }

    // ✅ 4. Empty list
    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<Bogie>> result = groupBogies(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    // ✅ 5. Single category
    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    // ✅ 6. Check keys exist
    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    // ✅ 7. Validate group size
    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    // ✅ 8. Original list unchanged
    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));

        groupBogies(list);

        assertEquals(2, list.size()); // unchanged
    }
}