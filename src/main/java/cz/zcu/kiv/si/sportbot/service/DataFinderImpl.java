package cz.zcu.kiv.si.sportbot.service;

import cz.zcu.kiv.si.sportbot.dataLoader.DataLoader;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.object.Sport;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
@Service
public class DataFinderImpl implements DataFinder {
    @Autowired
    DataLoader dataLoader;


    @Override
    public List<SportPlace> findSport(SportType sportType) {
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            for (Sport sport : sportPlace.getSports()){
                if(sport.getSportType()==sportType){
                    sportPlaces.add(sportPlace);
                    break;
                }
            }
        }
        return sportPlaces;
    }

    @Override
    public List<SportPlace> findOutsideSport(SportType sportType) {
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            for (Sport sport : sportPlace.getSports()){
                if(sport.getSportType()==sportType && sport.getSportGroup()== SportGroup.OUTSIDE){
                    sportPlaces.add(sportPlace);
                    break;
                }
            }
        }
        return sportPlaces;
    }
    @Override
    public List<SportPlace> findInsideSport(SportType sportType) {
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            for (Sport sport : sportPlace.getSports()){
                if(sport.getSportType()==sportType && sport.getSportGroup()== SportGroup.INSIDE){
                    sportPlaces.add(sportPlace);
                    break;
                }
            }
        }
        return sportPlaces;
    }
    @Override
    public List<SportPlace> findSportInGroup(SportGroup sportGroup){
        List<SportPlace> sportPlaces = new ArrayList<>();
        List<SportType> sportTypesInGroup = sportGroup.getSportTypes();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            for (Sport sport : sportPlace.getSports()){
                if(sportTypesInGroup.contains(sport.getSportType())){
                    sportPlaces.add(sportPlace);
                    break;
                }
            }
        }
        return sportPlaces;
    }
}
