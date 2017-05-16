package cz.zcu.kiv.si.sportbot.dataLoader;

import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;

import java.util.Comparator;

/**
 * @author Marek Rasocha
 *         date 16.05.2017.
 */
public class IBMComparator implements Comparator<SportPlace> {

    @Override
    public int compare(SportPlace o1, SportPlace o2) {
        return o2.getPriority().compareTo(o1.getPriority());
    }
}
