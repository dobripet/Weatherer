package cz.zcu.kiv.si.sportbot.dataLoader.enums;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public enum SportGroup {
    OUTSIDE(new ArrayList<SportType>()),
    INSIDE(new ArrayList<SportType>()),
    BALL(Arrays.asList(
            SportType.BADMINTON, SportType.BASKETBALL, SportType.BEACH_VOLEJBAL, SportType.BOWLING, SportType.FUTSAL, SportType.GOLF,
            SportType.HAZENA, SportType.HOKEJBAL, SportType.MINIGOLF, SportType.NOHEJBAL, SportType.SQUASH, SportType.STREETBALL,
            SportType.VOLEJBAL, SportType.TENIS
    )),
    HALL(Arrays.asList(
            SportType.BADMINTON,SportType.BASKETBALL,SportType.FUTSAL, SportType.HAZENA, SportType.HOKEJBAL, SportType.NOHEJBAL,
            SportType.SQUASH, SportType.VOLEJBAL, SportType.TENIS
    ));

    private final List<SportType> sportTypes;

    SportGroup(List<SportType> sportTypes) {
        this.sportTypes = sportTypes;
    }

    public List<SportType> getSportTypes() {
        return sportTypes;
    }

}
