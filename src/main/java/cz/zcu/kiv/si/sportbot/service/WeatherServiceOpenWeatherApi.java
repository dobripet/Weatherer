package cz.zcu.kiv.si.sportbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Week;
import cz.zcu.kiv.si.sportbot.model.CurrentWeather;
import cz.zcu.kiv.si.sportbot.model.Forecast;
import cz.zcu.kiv.si.sportbot.model.ForecastDaily;
import cz.zcu.kiv.si.sportbot.model.SportGroupForecast;
import cz.zcu.kiv.si.sportbot.utils.TimePassedException;
import cz.zcu.kiv.si.sportbot.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    public CurrentWeather getCurrentWeather() {
        // 30 min cache
        long now = System.currentTimeMillis();
        if(currentWeather == null || now - currentTime > 30000){
            currentTime = now;
            currentWeather = new RestTemplate().getForObject(makeUri(CURRENT, null), CurrentWeather.class);
        }
        return currentWeather;
    }

    @Override
    public Forecast getWeatherForecast() {
        // 2hours cache
        long now = System.currentTimeMillis();
        if(forecast == null || now - forecastTime > 120000){
            forecastTime = now;
            forecast = new RestTemplate().getForObject(makeUri(FORECAST, null), Forecast.class);
        }
        return forecast;
    }

    @Override
    public ForecastDaily getWeatherForecastDaily() {
        // 12hours cache
        long now = System.currentTimeMillis();
        if(daily == null || now - dailyTime > 720000){
            dailyTime = now;
            daily = new RestTemplate().getForObject(makeUri(FORECAST_DAILY, null), ForecastDaily.class);
        }
        return daily;
    }

    @Override
    public SportGroupForecast getSportGroupAndForecastForDate(int hour, Day day, Week week) throws TimePassedException{
        long time = Utils.getUnixTimeFromDate(hour, day, week);
        List<CurrentWeather> cwList = getWeatherForecast().getList();
        //no forecast, just stay inside
        if(cwList == null || cwList.size() == 0){
            //return SportGroup.INSIDE;
        }
        //browse accurate forecast
        if(cwList.get(cwList.size()-1).getDt()<(time + 10800)) {
            for (CurrentWeather cw : getWeatherForecast().getList()) {
                if (cw.getDt() < time) {
                    //https://openweathermap.org/weather-conditions
                    if(cw.getWeather().getId() >= 800 && cw.getWeather().getId() < 900){
                        return null;
                    }
                }
                break;
            }
        }
        //TODO
        return null;
    }

    private String makeUri(String uri, String parameters) {
        String param = StringUtils.isEmpty(parameters) ? "" : parameters + "&";
        return BASE_URI + uri + "?" + param + CITY_ID + "&" + UNITS + "&" + APP_ID;
    }


}
