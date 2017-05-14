package cz.zcu.kiv.si.sportbot.dataLoader.object;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public class Sport {
    private SportType sportType;
    private SportGroup sportGroup;
    private int price;

    public Sport() {
    }

    public Sport(SportType sportType, SportGroup sportGroup,int price) {
        this.price = price;
        this.sportGroup = sportGroup;
        this.sportType = sportType;
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
                "price=" + price +
                ", sportType=" + sportType +
                ", sportGroup=" + sportGroup +
                '}';
    }
}
