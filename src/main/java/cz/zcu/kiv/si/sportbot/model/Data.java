package cz.zcu.kiv.si.sportbot.model;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;

import java.util.List;

/**
 * @author Marek Rasocha
 *         date 16.05.2017.
 */
public class Data {
    private List<SportPlace> places;
    private Day day;
    private AWeather weather;
    private boolean current;

    public AWeather getWeather() {
        return weather;
    }

    public void setWeather(AWeather weather) {
        this.weather = weather;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<SportPlace> getPlaces() {
        return places;
    }

    public void setPlaces(List<SportPlace> places) {
        this.places = places;
    }
}
