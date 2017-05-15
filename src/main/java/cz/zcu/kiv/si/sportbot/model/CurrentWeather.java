package cz.zcu.kiv.si.sportbot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Petr on 5/15/2017.
 */
public class CurrentWeather extends AWeather{
    private Weather weather;
    private Main main;
    private Wind wind;
    private long dt;
    private Sys sys;

    public Weather getWeather() {
        return weather;
    }

    //@JsonProperty("weather")
    public void setWeather(Weather[] weather) {
        if(weather.length > 0) {
            this.weather = weather[0];
        }else{
            this.weather = null;
        }
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }
}