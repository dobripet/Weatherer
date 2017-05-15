package cz.zcu.kiv.si.sportbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.zcu.kiv.si.sportbot.model.CurrentWeather;
import cz.zcu.kiv.si.sportbot.model.Forecast;
import cz.zcu.kiv.si.sportbot.model.ForecastDaily;
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

    private CurrentWeather currentWeather;
    private long currentTime;
    private Forecast forecast;
    private long forecastTime;
    private ForecastDaily daily;
    private long dailyTime;
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public String getCurrentWeather() {
        // 30 min cache
        long now = System.currentTimeMillis();
        if(currentWeather == null || now - currentTime > 30000){
            currentTime = now;
            currentWeather = new RestTemplate().getForObject(makeUri(CURRENT, null), CurrentWeather.class);
        }
        try {
            return mapper.writeValueAsString(currentWeather);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String getWeatherForecast() {
        // 2hours cache
        long now = System.currentTimeMillis();
        if(forecast == null || now - forecastTime > 120000){
            forecastTime = now;
            forecast = new RestTemplate().getForObject(makeUri(FORECAST, null), Forecast.class);
        }
        try {
            return mapper.writeValueAsString(forecast);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String getWeatherForecastDaily() {
        // 12hours cache
        long now = System.currentTimeMillis();
        if(daily == null || now - dailyTime > 720000){
            dailyTime = now;
            daily = new RestTemplate().getForObject(makeUri(FORECAST_DAILY, null), ForecastDaily.class);
        }
        try {
            return mapper.writeValueAsString(daily);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String makeUri(String uri, String parameters) {
        String param = StringUtils.isEmpty(parameters) ? "" : parameters + "&";
        return BASE_URI + uri + "?" + param + CITY_ID + "&" + UNITS + "&" + APP_ID;
    }
}
