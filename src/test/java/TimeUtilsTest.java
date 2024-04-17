import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {
    @ParameterizedTest(name = "convert sec to time string")
    @CsvSource({
            "-1, '-1'",
            "0, '0:00:00'",
            "1, '0:00:01'",
            "59, '0:00:59'",
            "60, '0:01:00'",
            "600, '0:10:00'",
            "3599, '0:59:59'",
            "3600, '1:00:00'",
            "4271, '1:11:11'",
            "32000, '8:53:20'",
            "32001, '-1'",
    })
    void testSecToTime(int seconds, String expected) {
        assertEquals(expected, TimeUtils.secToTime(seconds));
    }
}