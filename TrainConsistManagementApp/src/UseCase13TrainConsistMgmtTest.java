import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    List<Bogie> loopFilter(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    List<Bogie> streamFilter(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        loopFilter(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        streamFilter(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = List.of(
                new Bogie("A", 70),
                new Bogie("B", 50)
        );

        List<Bogie> result = loopFilter(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = List.of(
                new Bogie("A", 70),
                new Bogie("B", 50)
        );

        List<Bogie> result = streamFilter(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = List.of(
                new Bogie("A", 70),
                new Bogie("B", 80),
                new Bogie("C", 50)
        );

        assertEquals(loopFilter(list).size(), streamFilter(list).size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = List.of(
                new Bogie("A", 70),
                new Bogie("B", 80)
        );

        long loopTime = measureLoopTime(list);
        long streamTime = measureStreamTime(list);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("Type", i));
        }

        List<Bogie> loopResult = loopFilter(list);
        List<Bogie> streamResult = streamFilter(list);

        assertEquals(loopResult.size(), streamResult.size());
    }
}