package cz.zcu.kiv.si.sportbot.dataLoader;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.object.OpeningTime;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
public interface DataSorter {
    /**
     * seradi podle prioroty
     * @param places co se radi -> not null
     * @param sportTypes typ sportu -> muze byt null, pak se hleda vse
     * @param days dny -> not null. Pokud chces hledat vse, pouzil Arrays.ofList(Day.values)
     * @param openingTime cas muze byt null
     * @return serazeny list
     */
    List<SportPlace> sortByPriority(@NotNull List<SportPlace> places, List<SportType> sportTypes, @NotNull List<Day> days, OpeningTime openingTime);
}
