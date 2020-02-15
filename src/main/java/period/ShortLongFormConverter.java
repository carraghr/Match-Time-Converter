package period;

public class ShortLongFormConverter {
    public static String getLongFormat(String shortPeriodFormat) throws NullPointerException{
        return PeriodsOfMatch.get(shortPeriodFormat).toString();
    }
}
