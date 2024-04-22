import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestTimeUtils {
    private static TimeUtils timeUtils = new TimeUtils();
    private static final int MAX_INT = Integer.MAX_VALUE;

    @ParameterizedTest(name = "convert sec to time string")
    @CsvSource({
            "-2147483647, '-1'",
            "2147483647,'-1'",
            "0, '0:00:00'",
            "1, '0:00:01'",
            "59, '0:00:59'",
            "60, '0:01:00'",
            "599, '0:09:59'",
            "600, '0:10:00'",
            "3599, '0:59:59'",
            "3600, '1:00:00'",
            "32000, '8:53:20'",
            "32001, '-1'",
    })
    void testSecToTime(int seconds, String expected) {
        assertEquals(expected, timeUtils.secToTime(seconds));
    }
}