package cz.zcu.kiv.si.sportbot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Petr on 5/15/2017.
 */
public class Forecast {
    private List<CurrentWeather> list;

    public List<CurrentWeather> getList() {
        return list;
    }

    public void setList(List<CurrentWeather> list) {
        this.list = list;
    }
}
