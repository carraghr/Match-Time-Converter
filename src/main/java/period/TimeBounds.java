package period;

import time.MinuteSecondTime;

import java.util.HashMap;

public class TimeBounds {

    final static public HashMap<String, MinuteSecondTime> halfBound = new HashMap<>();

    static{
        halfBound.put(PeriodsOfMatch.PRE_MATCH.toString(), new MinuteSecondTime("0:00.000"));
        halfBound.put(PeriodsOfMatch.FIRST_HALF.toString(),new MinuteSecondTime("45:00.000") );
        halfBound.put(PeriodsOfMatch.HALF_TIME.toString(),new MinuteSecondTime("45:00.000") );
        halfBound.put(PeriodsOfMatch.SECOND_HALF.toString(), new MinuteSecondTime("90:00.000"));
        halfBound.put(PeriodsOfMatch.FULL_TIME.toString(), new MinuteSecondTime("90:00.000"));
     }

    public static MinuteSecondTime getTimeBoundInMinutes(String period) throws NullPointerException{
         return halfBound.get(period);
    }

}
