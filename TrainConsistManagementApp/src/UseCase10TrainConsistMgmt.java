import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    int calculateTotal(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        int result = calculateTotal(list);

        assertEquals(152, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        int result = calculateTotal(list);

        assertEquals(202, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72)
        );

        int result = calculateTotal(list);

        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int result = calculateTotal(new ArrayList<>());

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = List.of(
                new Bogie("A", 10),
                new Bogie("B", 20)
        );

        int result = calculateTotal(list);

        assertEquals(30, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = List.of(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );

        int result = calculateTotal(list);

        assertEquals(60, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));

        calculateTotal(list);

        assertEquals(2, list.size());
    }
}