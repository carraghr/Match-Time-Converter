package application;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    @Test
    public void test(){
        assertEquals("Incorrect Message returned","00:00 - PRE_MATCH",Formatter.process("[PM] 0:00.000"));
        assertEquals("Incorrect Message returned","00:15 - FIRST_HALF",Formatter.process("[H1] 0:15.025"));
        assertEquals("Incorrect Message returned","03:08 - FIRST_HALF",Formatter.process("[H1] 3:07.513"));
        assertEquals("Incorrect Message returned","45:00 +00:00 - FIRST_HALF",Formatter.process("[H1] 45:00.001"));
        assertEquals("Incorrect Message returned","45:00 +01:16 - FIRST_HALF",Formatter.process("[H1] 46:15.752"));
        assertEquals("Incorrect Message returned","45:00 - HALF_TIME",Formatter.process("[HT] 45:00.000"));
        assertEquals("Incorrect Message returned","45:01 - SECOND_HALF",Formatter.process("[H2] 45:00.500"));
        assertEquals("Incorrect Message returned","90:00 +00:01 - SECOND_HALF",Formatter.process("[H2] 90:00.908"));
        assertEquals("Incorrect Message returned","90:00 - FULL_TIME",Formatter.process("[FT] 90:00.000"));
        assertEquals("Incorrect Message returned","INVALID",Formatter.process("90:00"));
        assertEquals("Incorrect Message returned","INVALID",Formatter.process("[H3] 90:00.000"));
        assertEquals("Incorrect Message returned","INVALID",Formatter.process("[PM] -10:00.000"));
        assertEquals("Incorrect Message returned","INVALID",Formatter.process("FOO"));
    }
}
