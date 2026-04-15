import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    boolean isValidTrainID(String id) {
        return Pattern.matches("TRN-\\d{4}", id);
    }

    boolean isValidCargoCode(String code) {
        return Pattern.matches("PET-[A-Z]{2}", code);
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainID("TRAIN12"));
        assertFalse(isValidTrainID("TRN12A"));
        assertFalse(isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET-ab"));
        assertFalse(isValidCargoCode("PET123"));
        assertFalse(isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainID("TRN-123"));
        assertFalse(isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("PET-aB"));
        assertFalse(isValidCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainID(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainID("TRN-1234X"));
        assertFalse(isValidCargoCode("PET-ABC"));
    }
}