package period;

import java.util.HashMap;
import java.util.Map;

public enum PeriodsOfMatch {

    PRE_MATCH("[PM]"),
    FIRST_HALF("[H1]"),
    HALF_TIME("[HT]"),
    SECOND_HALF("[H2]"),
    FULL_TIME("[FT]");

    private String period;

    PeriodsOfMatch(String periodShortHand){
        this.period = periodShortHand;
    }

    public String getPeriod(){
        return period;
    }

    private static final Map<String, PeriodsOfMatch> lookUp = new HashMap<>();

     static{
         for (PeriodsOfMatch period: PeriodsOfMatch.values()){
             lookUp.put(period.getPeriod(), period);
         }
     }

     public static PeriodsOfMatch get(String period){
         return lookUp.get(period);
     }
}
