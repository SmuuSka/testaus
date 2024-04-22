public class TimeUtils {
    private static int hh;
    private static int mm;
    private static int ss;

    public TimeUtils() {
    }

    public static int timeToSec(String time) {
        String[] part = time.split(":");
        hh = Integer.parseInt(part[0]);
        mm = Integer.parseInt(part[1]);
        ss = Integer.parseInt(part[2]);

        return 3600 * hh + 60 * mm + ss;
    }

    public static String secToTime(int seconds) {
        if (seconds < 0 || seconds > 32000) {
            return "-1";
        }

        hh = seconds / 3600;
        seconds = seconds - (3600 * hh);
        mm = seconds / 60;
        ss = seconds - (60 * mm);

        String res = hh + ":";
        if (mm < 10) {
            res = res + "0" + mm + ":";
        } else {
            res = res + mm + ":";
        }
        if (ss <= 10) {
            res = res + "0" + ss;
        } else {
            res = res + ss;
        }

        return res;
    }
}
