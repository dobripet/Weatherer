package cz.zcu.kiv.si.sportbot.dataLoader.object;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public class SportPlace{
    private Contact contact;
    private double lon;
    private double lat;
    private double z;

    private Double priority;

    private Map<Day,OpeningTime> open;
    private List<Sport> sports;

    public SportPlace() {
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


    public Map<Day, OpeningTime> getOpen() {
        return open;
    }

    public void setOpen(Map<Day, OpeningTime> openingTime) {
        this.open = openingTime;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Double getPriority() {
        return priority;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "SportPlace{"+
                "priority"+ priority+
                ", lon=" + lon +
                ", lat=" + lat +
                ", z=" + z +
                ", contact=" + contact +
                ", openingTime=" + open +
                ", sports=" + sports +
                '}';
    }
}
