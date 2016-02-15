package androidpath.ll.zhihukun.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Le on 2016/2/14.
 */
public class DateUtils {
    private static SimpleDateFormat dateFormat;

    public DateUtils() {
        dateFormat = new SimpleDateFormat("yyyyMMdd");
    }

    /**
     * @param specifiedDay date with format "yyyymmdd"
     * @return String prev day with format "yyyymmdd"
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay){
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = dateFormat.parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day-1);

        String dayBefore = dateFormat.format(c.getTime());
        return dayBefore;
    }
    /**
     * @param specifiedDay date with format "yyyymmdd"
     * @return String the day after given date with format "yyyymmdd"
     */
    public static String getSpecifiedDayAfter(String specifiedDay){
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = dateFormat.parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day+1);

        String dayAfter = dateFormat.format(c.getTime());
        return dayAfter;
    }
}