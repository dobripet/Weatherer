package cz.zcu.kiv.si.sportbot.dataLoader;

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.object.OpeningTime;
import cz.zcu.kiv.si.sportbot.dataLoader.object.Sport;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
@Service
public class DataLoaderImpl implements DataLoader {
    private static final String PATH = "data";
    private List<SportPlace> sportPlaces;

    @Autowired
    private Generator generator;
    public DataLoaderImpl() {
    }



    @PostConstruct
    public void loadData(){
        sportPlaces =  new ArrayList<>();
        ClassLoader classLoader = ResourceLoader.class.getClassLoader();
        File file = new File(classLoader.getResource(PATH).getFile());
        listFilesForFolder(file);
    }

    private void listFilesForFolder(final File folder) {
        if(folder!=null && folder.listFiles()!=null) {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    listFilesForFolder(fileEntry);
                } else {
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(fileEntry.getAbsolutePath()));
                        String json = "", line;
                        while ((line = br.readLine()) != null) json += line;
                        sportPlaces.add(parseJson(json));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }


    private SportPlace parseJson(String json){
        JsonParser factory = JsonParserFactory.getJsonParser();
        Map<String,Object> map = (Map<String, Object>) factory.parseMap(json).get("sportplace");
        SportPlace sportPlace = new SportPlace();
        for(Map.Entry<String,Object> entry : map.entrySet()){
            if (entry.getKey().equalsIgnoreCase("contact")){
                for(Map.Entry<String,Object> basicEntry : ((Map<String, Object>) entry.getValue()).entrySet()){
                    if (basicEntry.getKey().equalsIgnoreCase("name")) sportPlace.setName(basicEntry.getValue().toString());
                    if (basicEntry.getKey().equalsIgnoreCase("address")) sportPlace.setAddress(basicEntry.getValue().toString());
                    if (basicEntry.getKey().equalsIgnoreCase("phone")) sportPlace.setPhone(basicEntry.getValue().toString());
                    if (basicEntry.getKey().equalsIgnoreCase("email")) sportPlace.setEmail(basicEntry.getValue().toString());
                    if (basicEntry.getKey().equalsIgnoreCase("url")) sportPlace.setUrl(basicEntry.getValue().toString());
                    if (basicEntry.getKey().equalsIgnoreCase("lon")) sportPlace.setLon(((Number)basicEntry.getValue()).doubleValue());
                    if (basicEntry.getKey().equalsIgnoreCase("lat")) sportPlace.setLat(((Number) basicEntry.getValue()).doubleValue());
                    if (basicEntry.getKey().equalsIgnoreCase("z")) sportPlace.setZ(((Number) basicEntry.getValue()).doubleValue());
                }
            }
            if (entry.getKey().equalsIgnoreCase("open")){
                Map<Day,OpeningTime> openingTime = new HashMap<>();
                for(Map.Entry<String,Object> entryDay : ( (Map<String, Object>) entry.getValue()).entrySet()){
                    openingTime.put(getDay(entryDay.getKey()),getOpeningDay((List) entryDay.getValue()));
                }
                sportPlace.setOpeningTime(openingTime);
            }
            if (entry.getKey().equalsIgnoreCase("sport")){
                List<Sport> sportList = new ArrayList<>();
                for(Object sports : ( (List) entry.getValue())){
                    sportList.add(parseSport((Map<String, Object>)sports,sportPlace.getOpeningTime()));
                }
                sportPlace.setSports(sportList);
            }
        }
        return sportPlace;
    }

    private Sport parseSport(Map<String, Object> sportMap, Map<Day,OpeningTime> openingTime) {
        Sport sport = new Sport();
        for(Map.Entry<String,Object> entry : sportMap.entrySet()){
            sport.setSportType(getSportType(entry.getKey()));
            for(Map.Entry<String,Object> sportProps : ( (Map<String, Object>) entry.getValue()).entrySet()){
                if (sportProps.getKey().equalsIgnoreCase("price"))sport.setPrice(((Number)sportProps.getValue()).intValue());
                if (sportProps.getKey().equalsIgnoreCase("outside")){
                    SportGroup group = (boolean) sportProps.getValue() ? SportGroup.OUTSIDE : SportGroup.INSIDE;
                    sport.setSportGroup(group);
                }
                if(sportProps.getKey().equalsIgnoreCase("reservation")){
                    boolean reservation = (boolean) sportProps.getValue();
                    Map<Day,List<OpeningTime>> freeTime = new HashMap<>();
                    for(Map.Entry<Day,OpeningTime> open : openingTime.entrySet()) {
                        List<OpeningTime> openingTimes = new ArrayList<>();
                        if(open.getValue()!=null) {

                            for (int i = open.getValue().getFrom(); i < open.getValue().getTo(); i++) {
                                if(reservation) {
                                    if (generator.generate()) openingTimes.add(new OpeningTime(i, i + 1));
                                }else {
                                    openingTimes.add(new OpeningTime(i, i + 1));
                                }
                            }
                        }
                        freeTime.put(open.getKey(), openingTimes);
                    }
                    sport.setFreeTime(freeTime);
                }
            }
        }
        return sport;
    }

    private SportType getSportType(String text) {
        SportType[] sportTypes = SportType.values();
        for(int i=0;i<sportTypes.length;i++){
            if(sportTypes[i].getName().equalsIgnoreCase(text)) return sportTypes[i];
        }
        return null;
    }

    private OpeningTime getOpeningDay(List<Object> value) {
        return value.size()==2 ? new OpeningTime(((Number)value.get(0)).intValue(),(((Number)value.get(1)).intValue())) : null;
    }

    private Day getDay(String text) {
        Day[] days = Day.values();
        for(int i=0;i<days.length;i++){
            if(days[i].getName().equalsIgnoreCase(text)) return days[i];
        }
        return null;
    }

    @Override
    public List<SportPlace> getSportPlaces() {
        return sportPlaces;
    }
}
