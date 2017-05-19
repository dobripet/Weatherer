package cz.zcu.kiv.si.sportbot.utils;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Week;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Petr on 5/15/2017.
 */
public class Utils {
    public static long getUnixTimeFromDate(int hour, Day day, Week week) throws TimePassedException{
        Calendar calendar = Calendar.getInstance();
        int diffDay = dayToInt.get(day) - calendar.get(Calendar.DAY_OF_WEEK);
        if(week == Week.NEXT){
            diffDay+=7;

        } else{
            //this or null week
            //convert to next
            if( diffDay < 0){
                diffDay+=7;
            }
        }
        int diffHour = hour - calendar.get(Calendar.HOUR_OF_DAY);
        if(diffDay == 0 && diffHour < 0){
            throw new TimePassedException();
        }
        calendar.add(Calendar.DATE, diffDay);
        calendar.add(Calendar.HOUR_OF_DAY, diffHour);
        System.out.println(calendar.getTime() );
        return calendar.getTimeInMillis()/1000;
    }

    public static Day getWeekDay(Day day){
        Calendar calendar = Calendar.getInstance();
        switch(day){
            case TODAY: break;
            case TOMORROW: {
                calendar.add(Calendar.DATE, 1);
            } break;
            case DATOMORROW: {
                calendar.add(Calendar.DATE, 2);
            } break;
            default: {
                return day;
            }
        }
        return intToDay.get(calendar.get(Calendar.DAY_OF_WEEK));
    }

    public static Map<Day, Integer> dayToInt;
    public static Map<Integer, Day> intToDay;
    static{
        dayToInt = new HashMap<>();
        dayToInt.put(Day.SUNDAY, 1);
        dayToInt.put(Day.MONDAY, 2);
        dayToInt.put(Day.TUESDAY, 3);
        dayToInt.put(Day.WEDNESDAY, 4);
        dayToInt.put(Day.THURSDAY, 5);
        dayToInt.put(Day.FRIDAY, 6);
        dayToInt.put(Day.SATURDAY, 7);
        intToDay = new HashMap<>();
        intToDay.put(1, Day.SUNDAY);
        intToDay.put(2, Day.MONDAY);
        intToDay.put(3, Day.TUESDAY);
        intToDay.put(4, Day.WEDNESDAY);
        intToDay.put(5, Day.THURSDAY);
        intToDay.put(6, Day.FRIDAY);
        intToDay.put(7, Day.SATURDAY);
    }
    public static Day lookupDay(String id) {
        Day[] days = Day.values();
        for(int i =0; i< days.length;i++){
            if (days[i].getName().equalsIgnoreCase(id)) return days[i];
        }
        return null;
    }
    public static Week lookupWeek(String id) {
        Week[] days = Week.values();
        for(int i =0; i< days.length;i++){
            if (days[i].getName().equalsIgnoreCase(id)) return days[i];
        }
        return null;
    }
    public static SportType lookupSporType(String id) {
        SportType[] days = SportType.values();
        for(int i =0; i< days.length;i++){
            if (days[i].getName().equalsIgnoreCase(id)) return days[i];
        }
        return null;
    }
    public static int getCurrentHour(){
        Calendar rightNow = Calendar.getInstance();
        return rightNow.get(Calendar.HOUR_OF_DAY);
    }

}
