package cz.zcu.kiv.si.sportbot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Petr on 5/15/2017.
 */
public class DailyWeather {
    private Weather weather;
    private Temp temp;
    private float humidity;
    private float pressure;
    private float speed;
    private long dt;

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

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }
}
