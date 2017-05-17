package cz.zcu.kiv.si.sportbot.service;

import cz.zcu.kiv.si.sportbot.dataLoader.DataLoader;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.object.Contact;
import cz.zcu.kiv.si.sportbot.dataLoader.object.OpeningTime;
import cz.zcu.kiv.si.sportbot.dataLoader.object.Sport;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
@Service
public class DataFinderImpl implements DataFinder {
    @Autowired
    DataLoader dataLoader;


    public DataFinderImpl() {
    }

    @Override
    public List<SportPlace> findSport(SportType sportType) {
       return findSport(Arrays.asList(sportType));
    }
    @Override
    public List<SportPlace> findSport(List<SportType> sportTypes) {
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            SportPlace newPlace = getNewSportPlace(sportPlace);
            List<Sport> sports = new ArrayList<>();
            boolean search = false;
            for (Sport sport : sportPlace.getSports()){
                if(sportTypes.contains(sport.getSportType())){
                    sports.add(sport);
                    search = true;
                }
            }
            if(search) {
                newPlace.setSports(sports);
                sportPlaces.add(newPlace);
            }
        }
        return sportPlaces;
    }
    @Override
    public List<SportPlace> findOutsideSport(SportType sportType) {
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            SportPlace newPlace = getNewSportPlace(sportPlace);
            List<Sport> sports = new ArrayList<>();
            boolean search = false;
            for (Sport sport : sportPlace.getSports()){
                if(sport.getSportType()==sportType && sport.getSportGroup()== SportGroup.OUTSIDE){
                    sports.add(sport);
                    search = true;
                }
            }
            if(search) {
                newPlace.setSports(sports);
                sportPlaces.add(newPlace);
            }
        }
        return sportPlaces;
    }
    @Override
    public List<SportPlace> findOutsideSport() {
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            SportPlace newPlace = getNewSportPlace(sportPlace);
            List<Sport> sports = new ArrayList<>();
            boolean search = false;
            for (Sport sport : sportPlace.getSports()){
                if(sport.getSportGroup()== SportGroup.OUTSIDE){
                    sports.add(sport);
                    search = true;
                }
            }
            if(search) {
                newPlace.setSports(sports);
                sportPlaces.add(newPlace);
            }
        }
        return sportPlaces;
    }


    @Override
    public List<SportPlace> findInsideSport() {
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            SportPlace newPlace = getNewSportPlace(sportPlace);
            List<Sport> sports = new ArrayList<>();
            boolean search = false;
            for (Sport sport : sportPlace.getSports()){
                if(sport.getSportGroup()== SportGroup.INSIDE){
                    sports.add(sport);
                    search = true;
                }
            }
            if(search) {
                newPlace.setSports(sports);
                sportPlaces.add(newPlace);
            }
        }
        return sportPlaces;
    }
    @Override
    public List<SportPlace> findInsideSport(SportType sportType) {
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            SportPlace newPlace = getNewSportPlace(sportPlace);
            List<Sport> sports = new ArrayList<>();
            boolean search = false;
            for (Sport sport : sportPlace.getSports()){
                if(sport.getSportType()==sportType && sport.getSportGroup()== SportGroup.INSIDE){
                    sports.add(sport);
                    search = true;
                }
            }
            if(search) {
                newPlace.setSports(sports);
                sportPlaces.add(newPlace);
            }
        }
        return sportPlaces;
    }
    @Override
    public List<SportPlace> findSportInGroup(List<SportGroup> sportGroups){
        List<SportPlace> sportPlaces = new ArrayList<>();
        Set<SportType> sportTypesInGroup = getSportTypes(sportGroups);
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            SportPlace newPlace = getNewSportPlace(sportPlace);
            List<Sport> sports = new ArrayList<>();
            boolean search = false;
            for (Sport sport : sportPlace.getSports()){
                if(sportTypesInGroup.contains(sport.getSportType())){
                    sports.add(sport);
                    search = true;
                }
            }
            if(search) {
                newPlace.setSports(sports);
                sportPlaces.add(newPlace);
            }
        }
        return sportPlaces;
    }

    private Set<SportType> getSportTypes(List<SportGroup> sportGroups) {
        Set<SportType> sportTypes = new HashSet<>();
        for(SportGroup group : sportGroups){
            sportTypes.addAll(group.getSportTypes());
        }
        return sportTypes;
    }

    public List<SportPlace> findSportFree(){
        List<SportPlace> sportPlaces = new ArrayList<>();
        for (SportPlace sportPlace : dataLoader.getSportPlaces()){
            SportPlace newPlace = getNewSportPlace(sportPlace);
            List<Sport> sports = new ArrayList<>();
            boolean search = false;
            for (Sport sport : sportPlace.getSports()){
                if(sport.getPrice()==0){
                    sports.add(sport);
                    search = true;
                }
            }
            if(search) {
                newPlace.setSports(sports);
                sportPlaces.add(newPlace);
            }
        }
        return sportPlaces;
    }

    private SportPlace getNewSportPlace(SportPlace sportPlace) {
        SportPlace newPlace = new SportPlace();
        Contact contact = new Contact();
        Contact oldContact = sportPlace.getContact();
        contact.setName(oldContact.getName());
        contact.setAddress(oldContact.getAddress());
        contact.setPhone(oldContact.getPhone());
        contact.setEmail(oldContact.getEmail());
        contact.setUrl(oldContact.getUrl());
        newPlace.setLat(sportPlace.getLat());
        newPlace.setLon(sportPlace.getLon());
        newPlace.setZ(sportPlace.getZ());
        newPlace.setOpeningTime(sportPlace.getOpeningTime());
        return sportPlace;
    }
}
