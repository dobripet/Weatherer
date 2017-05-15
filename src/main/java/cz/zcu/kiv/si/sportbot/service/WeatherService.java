package cz.zcu.kiv.si.sportbot.service;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Week;
import cz.zcu.kiv.si.sportbot.model.CurrentWeather;
import cz.zcu.kiv.si.sportbot.model.Forecast;
import cz.zcu.kiv.si.sportbot.model.ForecastDaily;
import cz.zcu.kiv.si.sportbot.model.SportGroupForecast;
import cz.zcu.kiv.si.sportbot.utils.TimePassedException;

/**
 * Created by Matej Lochman on 14.5.17.
 */
public interface WeatherService {

    CurrentWeather getCurrentWeather();
    Forecast getWeatherForecast();
    ForecastDaily getWeatherForecastDaily();
    SportGroupForecast getSportGroupAndForecastForDate(int hour, Day day, Week week) throws TimePassedException;
}
