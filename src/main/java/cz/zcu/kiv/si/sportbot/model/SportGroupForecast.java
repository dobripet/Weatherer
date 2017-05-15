package cz.zcu.kiv.si.sportbot.model;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;

/**
 * Created by Petr on 5/16/2017.
 */
    public class SportGroupForecast {
        private SportGroup sportGroup;
        private AWeather weather;
        private boolean current;

    public SportGroupForecast(SportGroup sportGroup, AWeather weather, boolean current) {
        this.sportGroup = sportGroup;
        this.weather = weather;
        this.current = current;
    }

    public SportGroup getSportGroup() {
        return sportGroup;
    }

    public void setSportGroup(SportGroup sportGroup) {
        this.sportGroup = sportGroup;
    }

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
}
