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
    )),
    INDIVIDUAL(Arrays.asList(
           SportType.AEROBIC,SportType.BODYFORMING, SportType.BODYSTYLING, SportType.BOSU,SportType.BOWLING, SportType.CORE, SportType.CROSSFIT,
           SportType.CYKLISTIKA,SportType.DANCE, SportType.DEEP_WORK, SportType.DETSKE_HRISTE, SportType.FITBOX, SportType.FITNESS, SportType.FLEXIBAR,
           SportType.FLOWIN,SportType.GOLF, SportType.GTS, SportType.GYM, SportType.HIIT, SportType.HOROLEZECKA_STENA, SportType.HEAT,
           SportType.CHI_TONING,SportType.INLINE, SportType.JOGA, SportType.JOGGING, SportType.K2, SportType.KARDIO, SportType.KICKBOX,
           SportType.KRUHOVY_TRENINK,SportType.LANOVE_CENTRUM, SportType.MINIGOLF, SportType.PILATES, SportType.PILOXING, SportType.PLOCHE_BRICHO,
           SportType.PORT_DE_BRAS,SportType.POSILOVNA, SportType.POWER_PLATE, SportType.POWERJOGA, SportType.PUMPING, SportType.SEBEOBRANA,
           SportType.SKATE_PARK,SportType.STEP, SportType.TABATA, SportType.TEHOTENSKE_CVICENI, SportType.THAILBOX, SportType.TRANPOLINA,
           SportType.TRX,SportType.WORKOUT, SportType.ZUMBA
    )),
    TEAM(Arrays.asList(
           SportType.BADMINTON,SportType.BASKETBALL, SportType.BEACH_VOLEJBAL, SportType.FUTSAL,SportType.HAZENA,SportType.HOKEJBAL,
           SportType.NOHEJBAL,SportType.SQUASH, SportType.STREETBALL, SportType.TENIS,SportType.VOLEJBAL
    ));

    private final List<SportType> sportTypes;

    SportGroup(List<SportType> sportTypes) {
        this.sportTypes = sportTypes;
    }

    public List<SportType> getSportTypes() {
        return sportTypes;
    }

}
