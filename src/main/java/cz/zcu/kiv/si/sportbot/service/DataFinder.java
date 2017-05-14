package cz.zcu.kiv.si.sportbot.service;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;

import java.util.List;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public interface DataFinder {
    /**
     * najde sportplace podle typu sportu
     * @param sportType sportType
     * @return list nalazenych sportplace
     */
    List<SportPlace> findSport(SportType sportType);

    /**
     * najde sportplace podle typu sportu, kde sport jde delat venku
     * @param sportType sportType
     * @return list nalazenych sportplace
     */
    List<SportPlace> findOutsideSport(SportType sportType);
    /**
     * najde sportplace podle typu sportu, kde sport jde delat vevnitr
     * @param sportType sportType
     * @return list nalazenych sportplace
     */
    List<SportPlace> findInsideSport(SportType sportType);

    /**
     * nejde sporty ze skupiny
     * @param sportGroup sport type
     * @return list nalazenych sportplace
     */
    List<SportPlace> findSportInGroup(SportGroup sportGroup);
}
