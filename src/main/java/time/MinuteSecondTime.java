package time;

public class MinuteSecondTime {
    private int minutes;
    private int seconds;

    private boolean isNextSecondMarked;

    public MinuteSecondTime(String s){
        String[] splitMinuteSeconds = s.split(":");
        if (splitMinuteSeconds.length == 2){

            minutes = Integer.parseInt(splitMinuteSeconds[0]);
            if(minutes < 0){
                throw new IllegalArgumentException();
            }

            String[] splitSeconds = splitMinuteSeconds[1].split("\\.");
            if(splitSeconds.length == 2 && splitSeconds[0].length()==2 && splitSeconds[1].length()==3){
                seconds = Integer.parseInt(splitSeconds[0]);
                int milliseconds = Integer.parseInt(splitSeconds[1]);
                if(seconds < 0 || seconds > 59 || milliseconds < 0 || milliseconds > 999){
                    throw new IllegalArgumentException();
                }
                if(milliseconds >= 500){
                    seconds++;
                    if(seconds == 60){
                        seconds = 0;
                        minutes++;
                    }
                }
                if(milliseconds>0){
                    isNextSecondMarked = true;
                }
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    public int getMinutes() { return minutes; }

    public int getSeconds(){
        return seconds;
    }

    public boolean getIsNextSecondMarked() {
        return isNextSecondMarked;
    }

    public String removeOverTIme(MinuteSecondTime time){

        String overTime = "";

        if(!isNextSecondMarked && minutes < time.getMinutes() ||(time.getMinutes() == minutes && seconds < time.getSeconds()) ){
            return overTime;
        }

        int overTimeMinutes = minutes - time.getMinutes();
        int overTimeSeconds = seconds - time.getSeconds();
        if(minutes > time.getMinutes() ||
                (minutes == time.getMinutes() &&
                        (seconds > time.getSeconds() || (seconds == time.getSeconds() && isNextSecondMarked)) )){
            String argument = String.format("%02d:%02d.000",Math.abs(overTimeMinutes),Math.abs(overTimeSeconds));
            overTime = "+" + new MinuteSecondTime(argument).toString();
        }

        if(minutes >= time.getMinutes()){
            minutes = time.getMinutes();
            if(seconds > time.getSeconds()){
                seconds = time.getSeconds();
            }
        }

        return overTime;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d",minutes,seconds);
    }

    @Override
    public boolean equals(Object obj) {
        return ((MinuteSecondTime) obj).seconds == seconds && ((MinuteSecondTime) obj).minutes==minutes;
    }
}
