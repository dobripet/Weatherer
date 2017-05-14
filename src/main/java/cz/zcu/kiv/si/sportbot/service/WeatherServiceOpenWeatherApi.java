package cz.zcu.kiv.si.sportbot.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Matej Lochman on 14.5.17.
 */
@Service
public class WeatherServiceOpenWeatherApi implements WeatherService {

    private static final String BASE_URI = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "30402178290e64e4e48215ce4004371d";
    private static final String APP_ID = "APPID=" + API_KEY;
    private static final String UNITS = "units=metric";
    private static final String CITY_ID = "id=3068160";

    private static final String CURRENT = "weather";
    private static final String FORECAST = "forecast";
    private static final String FORECAST_DAILY = "forecast/daily";


    @Override
    public String getCurrentWeather() {
        return new RestTemplate().getForObject(makeUri(CURRENT, null), String.class);
    }

    @Override
    public String getWeatherForecast() {
        return new RestTemplate().getForObject(makeUri(FORECAST, null), String.class);
    }

    @Override
    public String getWeatherForecastDaily() {
        return new RestTemplate().getForObject(makeUri(FORECAST_DAILY, null), String.class);
    }

    private String makeUri(String uri, String parameters) {
        String param = StringUtils.isEmpty(parameters) ? "" : parameters + "&";
        return BASE_URI + uri + "?" + param + CITY_ID + "&" + UNITS + "&" + APP_ID;
    }
}
