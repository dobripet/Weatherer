package cz.zcu.kiv.si.sportbot.dataLoader.enums;

/**
 * Created by Petr on 5/15/2017.
 */
public enum Week {
    THIS("this"),
    NEXT("next");


    private String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
