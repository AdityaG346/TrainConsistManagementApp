import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmtTest {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    boolean isSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );

        assertTrue(isSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(isSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(isSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(isSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(isSafe(list));
    }
}