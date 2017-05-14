package cz.zcu.kiv.si.sportbot.dataLoader.object;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public class SportPlace {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String url;
    private double lon;
    private double lat;
    private double z;

    private Map<Day,OpeningTime> openingTime;
    private List<Sport> sports;

    public SportPlace() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Day, OpeningTime> getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Map<Day, OpeningTime> openingTime) {
        this.openingTime = openingTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "SportPlace{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", z=" + z +
                ", openingTime=" + openingTime +
                ", sports=" + sports +
                '}';
    }
}
