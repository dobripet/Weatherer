package cz.zcu.kiv.si.sportbot.model;

/**
 * Created by Petr on 5/15/2017.
 */
public class Sys {
    private long sunset;
    private long sunrise;

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }
}
