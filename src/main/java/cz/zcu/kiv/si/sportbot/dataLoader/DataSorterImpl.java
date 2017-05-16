package cz.zcu.kiv.si.sportbot.dataLoader;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.object.OpeningTime;
import cz.zcu.kiv.si.sportbot.dataLoader.object.Sport;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;
import org.springframework.stereotype.Service;


import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
@Service
public class DataSorterImpl implements DataSorter {


    public DataSorterImpl() {
    }

    public List<SportPlace> sortByPriority(@NotNull List<SportPlace> places, @NotNull List<SportType> sportTypes, @NotNull List<Day> days, OpeningTime openingTime){
        for (SportPlace pl : places){
            pl.setPriority(getPriority(pl,sportTypes, days,openingTime));
        }
        return sorter(places);
    }

    private List<SportPlace> sorter(List<SportPlace> places){
        Comparator<SportPlace> comparator = new IBMComparator();
        Collections.sort(places,comparator);
        return places;
    }
    private double getPriority(SportPlace sportPlace,List<SportType> sportTypes, List<Day> days, OpeningTime openingTime){
        double priority = 0;
        if (sportPlace.getSports()!=null){
            for(Sport sport : sportPlace.getSports()){
                if(sportTypes.isEmpty() || sportTypes.contains(sport.getSportType())) {
                    double priorityPom = getPriorityOfSport(sport, days, openingTime);
                    if (priorityPom > priority) priority = priorityPom;
                }
            }
        }
        return priority;
    }

    private double getPriorityOfSport(Sport sport, List<Day> days, OpeningTime openingTime){
        double priority = 10000 - sport.getPrice();         // za to, ze odpovida typu + cena
        for (Day day : days) {
            List<OpeningTime> openingTimes = sport.getFreeTime().get(day);
            if(openingTimes!=null && !openingTimes.isEmpty()) {
                priority +=100;                            // za to, ze dany den ma program
                if(openingTime!=null) {
                    for (int i = openingTime.getFrom(); i < openingTime.getTo(); i++) {
                        OpeningTime searched = new OpeningTime(i, i + 1);
                        if (openingTimes.contains(searched)) {
                            priority += 1000;                // za kazdou hodinoovou trefu
                        }
                    }
                }
            }
        }
        return priority;
    }
}
