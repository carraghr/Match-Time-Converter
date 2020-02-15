package period;

import org.junit.Test;
import time.MinuteSecondTime;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TimeBoundsTest {

    MinuteSecondTime preMatchMinutes =  new MinuteSecondTime("0:00.000"),
            halfTimeMinutes = new MinuteSecondTime("45:00.000"),
            fullTImeMinutes = new MinuteSecondTime("90:00.000");

    @Test
    public void testBoundOfPeriodInMinutes(){

        MinuteSecondTime preMatchTime, halfTime, fullTIme;

        preMatchTime = TimeBounds.getTimeBoundInMinutes(PeriodsOfMatch.PRE_MATCH.toString());
        halfTime = TimeBounds.getTimeBoundInMinutes(PeriodsOfMatch.HALF_TIME.toString());
        fullTIme = TimeBounds.getTimeBoundInMinutes(PeriodsOfMatch.FULL_TIME.toString());

        assertEquals("Incorrect Period Time",preMatchTime,preMatchMinutes);
        assertEquals("Incorrect Period Time",halfTimeMinutes,halfTime);
        assertEquals("Incorrect Period Time",fullTImeMinutes,fullTIme);
    }

    @Test(expected = NullPointerException.class)
    public void testNonBoundPeriodInMinutes(){
        fail((TimeBounds.getTimeBoundInMinutes("s")).toString());
    }
}
