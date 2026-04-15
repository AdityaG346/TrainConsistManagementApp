import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    
    List<Bogie> filterBogies(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 50)
        );

        List<Bogie> result = filterBogies(list);

        assertEquals(1, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> list = List.of(
                new Bogie("AC", 50),
                new Bogie("First", 40)
        );

        List<Bogie> result = filterBogies(list);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_EmptyList() {
        List<Bogie> list = new ArrayList<>();

        List<Bogie> result = filterBogies(list);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));

        filterBogies(list);

        assertEquals(1, list.size()); 
    }
}