package cz.zcu.kiv.si.sportbot.dataLoader.enums;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public enum Day {
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday");


    private String name;

    Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
