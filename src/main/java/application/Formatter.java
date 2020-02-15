package application;

import period.ShortLongFormConverter;
import period.TimeBounds;
import time.MinuteSecondTime;

public class Formatter {

    private static final String INVALID = "INVALID";

    public static String process(String s){
        String[] periodAndTime = s.split(" ");
        try {
            if (periodAndTime.length == 2) {
                String longForm = ShortLongFormConverter.getLongFormat(periodAndTime[0]);
                MinuteSecondTime boundTime = TimeBounds.getTimeBoundInMinutes(longForm);
                MinuteSecondTime periodTime = new MinuteSecondTime(periodAndTime[1]);
                String overtime = periodTime.removeOverTIme(boundTime);
                if(overtime.equals("")){
                    return periodTime.toString()+" - "+longForm;
                }
                return periodTime.toString()+" "+overtime+" - "+longForm;
            }
        }catch (Exception e) {
        }
        return INVALID;
    }
}
