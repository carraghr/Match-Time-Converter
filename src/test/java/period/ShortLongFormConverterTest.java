package period;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class ShortLongFormConverterTest {

    final String PER_MATCH = "PRE_MATCH",
                 FIRST_HALF = "FIRST_HALF",
                 HALF_TIME = "HALF_TIME",
                 SECOND_HALF = "SECOND_HALF",
                 FULL_TIME = "FULL_TIME";

    @Test
    public void testLegalPeriodLookUp(){
        String perMatch, firstHalf, halfTime, secondHalf, fullTime;

        perMatch = ShortLongFormConverter.getLongFormat("[PM]");
        firstHalf = ShortLongFormConverter.getLongFormat("[H1]");
        halfTime = ShortLongFormConverter.getLongFormat("[HT]");
        secondHalf = ShortLongFormConverter.getLongFormat("[H2]");
        fullTime = ShortLongFormConverter.getLongFormat("[FT]");

        assertEquals("Incorrect long format", PER_MATCH, perMatch);
        assertEquals("Incorrect long format", FIRST_HALF, firstHalf);
        assertEquals("Incorrect long format", HALF_TIME, halfTime);
        assertEquals("Incorrect long format", SECOND_HALF, secondHalf);
        assertEquals("Incorrect long format", FULL_TIME, fullTime);
    }

    @Test(expected = NullPointerException.class)
    public void testIllegalPeriodLookUp(){
        fail(ShortLongFormConverter.getLongFormat("[w]"));
    }
}
