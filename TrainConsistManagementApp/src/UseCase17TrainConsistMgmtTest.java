import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase17TrainConsistMgmtTest {

    String[] sortNames(String[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] result = sortNames(arr);
        assertArrayEquals(new String[]{"AC Chair","First Class","General","Luxury","Sleeper"}, result);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury","General","Sleeper","AC Chair"};
        String[] result = sortNames(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Luxury","Sleeper"}, result);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair","First Class","General"};
        String[] result = sortNames(arr);
        assertArrayEquals(new String[]{"AC Chair","First Class","General"}, result);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};
        String[] result = sortNames(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Sleeper","Sleeper"}, result);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        String[] result = sortNames(arr);
        assertArrayEquals(new String[]{"Sleeper"}, result);
    }
}
