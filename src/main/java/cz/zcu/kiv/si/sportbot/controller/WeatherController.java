package cz.zcu.kiv.si.sportbot.controller;

import cz.zcu.kiv.si.sportbot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Matej Lochman on 14.5.17.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping
    public String currentWeather() {
        return weatherService.getCurrentWeather();
    }

    @RequestMapping(value = "/forecast")
    public String weatherForecast() {
        return weatherService.getWeatherForecast();
    }

    @RequestMapping(value = "/forecast/daily")
    public String weatherForecastDaily() {
        return weatherService.getWeatherForecastDaily();
    }
}
