package cz.zcu.kiv.si.sportbot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Petr on 5/15/2017.
 */
public class ForecastDaily {
    private List<DailyWeather> list;

    public List<DailyWeather> getList() {
        return list;
    }

    public void setList(List<DailyWeather> list) {
        this.list = list;
    }
}
