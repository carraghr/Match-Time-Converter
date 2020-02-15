package time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MinuteSecondTimeTest {

    @Test
    public void testMinuteSecondTimeConstructor(){
        String argument = "3:07.513";
        String expectedResult = "03:08";

        MinuteSecondTime test = new MinuteSecondTime(argument);

        assertEquals("Incorrect String argument",test.toString(), expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalMinuteSecondTimeConstructor(){
        String minusMinutes = "-10:00.000";
        String noMilliseconds = "90:00";
        String wrongNumberofSecondZeros = "00:000:000";
        String wrongNumberofMillisecondZeros = "00:00:00";

        fail(new MinuteSecondTime(minusMinutes).toString());
        fail(new MinuteSecondTime(noMilliseconds).toString());
        fail(new MinuteSecondTime(wrongNumberofSecondZeros).toString());
        fail(new MinuteSecondTime(wrongNumberofMillisecondZeros).toString());
    }

    @Test
    public void testOverTimeString(){
        String argument1 = "45:15.752";
        String expectedResult1 = "+00:16";
        String argument2 = "45:00.001";
        String expectedResult2 = "+00:00";

        MinuteSecondTime test = new MinuteSecondTime(argument1);
        String n = test.removeOverTIme(new MinuteSecondTime("45:00.000"));
        MinuteSecondTime test2 = new MinuteSecondTime(argument2);
        String n2 = test2.removeOverTIme(new MinuteSecondTime("45:00.000"));

        assertEquals("Incorrect String argument",n, expectedResult1);
        assertEquals("Incorrect String argument",n2, expectedResult2);
    }
}
