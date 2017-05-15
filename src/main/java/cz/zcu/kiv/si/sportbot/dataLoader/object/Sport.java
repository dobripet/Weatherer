package cz.zcu.kiv.si.sportbot.dataLoader.object;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;

import java.util.List;
import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public class Sport {
    private SportType sportType;
    private SportGroup sportGroup;
    private int price;
    private Map<Day,List<OpeningTime>> freeTime;

    public Sport() {
    }

    public Sport(SportType sportType, SportGroup sportGroup,int price) {
        this.price = price;
        this.sportGroup = sportGroup;
        this.sportType = sportType;
    }

    public Map<Day,List<OpeningTime>> getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(  Map<Day,List<OpeningTime>> freeTime) {
        this.freeTime = freeTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SportGroup getSportGroup() {
        return sportGroup;
    }

    public void setSportGroup(SportGroup sportGroup) {
        this.sportGroup = sportGroup;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "freeTime=" + freeTime +
                ", sportType=" + sportType +
                ", sportGroup=" + sportGroup +
                ", price=" + price +
                '}';
    }
}
