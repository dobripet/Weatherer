package cz.zcu.kiv.si.sportbot.dataLoader;

import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;

import java.util.List;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public interface DataLoader {
    List<SportPlace> getSportPlaces();
}
