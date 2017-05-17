package cz.zcu.kiv.si.sportbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import cz.zcu.kiv.si.sportbot.bot.Context;
import cz.zcu.kiv.si.sportbot.dataLoader.DataSorter;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Week;
import cz.zcu.kiv.si.sportbot.model.ClientResponse;
import cz.zcu.kiv.si.sportbot.dataLoader.object.OpeningTime;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;
import cz.zcu.kiv.si.sportbot.model.Data;
import cz.zcu.kiv.si.sportbot.model.SportGroupForecast;
import cz.zcu.kiv.si.sportbot.utils.TimePassedException;
import cz.zcu.kiv.si.sportbot.utils.Utils;
import groovy.util.logging.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Marek Rasocha
 *         date 02.05.2017.
 */
@Service
public class ChatBotServiceImpl implements ChatBotService{
    private static Logger logger = Logger.getLogger(ChatBotServiceImpl.class);
    private String url = "https://gateway.watsonplatform.net/conversation/api";
    private ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03,
            "40fc984f-8da4-4bbc-9edb-18df99a346aa", "ny686uBZUy7d");

    @Autowired
    private WeatherService weatherService;
    @Autowired
    DataFinder dataFinder;
    @Autowired
    DataSorter dataSorter;
    public ChatBotServiceImpl() {
    }

    public ClientResponse sendMessage(Map<String,Object> previousContext,String text) {
        ConversationService service = new ConversationService("2017-04-21");
        service.setUsernameAndPassword("40fc984f-8da4-4bbc-9edb-18df99a346aa", "ny686uBZUy7d");
        service.setEndPoint(url);
        MessageRequest newMessage;
        if (previousContext==null) {
            newMessage = new MessageRequest.Builder()
                    .inputText(text)
                    .build();
        }else{
            newMessage = new MessageRequest.Builder()
                    .inputText(text)
                    .context(previousContext)
                    .build();
        }
        String workspaceId = "91e6b689-f119-47b1-be6e-48906213eda1";
        MessageResponse response = service
                .message(workspaceId, newMessage)
                .execute();
        //action

        ObjectMapper mapper = new ObjectMapper();
        Context context = mapper.convertValue(response.getContext(), Context.class);
        System.out.println(response.getContext());
        ClientResponse clientResponse = new ClientResponse();
        Map<String,Object> responseContext = response.getContext();
        System.out.println("kontext v param: "+ previousContext );
        System.out.println("Context co jsem dostal -> "+ responseContext);
        try {
            List<String> sports = context.getSports();
            List<String> sportsGroup = context.getSportgroups();
            String day = context.getDay();
            String daySpec = context.getDaySpec();
            daySpec = daySpec == null ? "" : daySpec;
            Integer time = context.getTime();
            List<Day> days = getListDay(Utils.lookupDay(day));
            Week week = Utils.lookupWeek(daySpec);
            System.out.println("hledej: day="+ day+", daySpec=" + daySpec);
            System.out.println("days:"+days);
            System.out.println("week:"+week);
            if (context.getFindWeather() != null && context.getFindWeather().booleanValue()) {
                int timeInt = time == null ? 12 : time;
                Day d = days.get(0);
                SportGroupForecast sportGroup = weatherService.getSportGroupAndForecastForDate(timeInt, d, week);
                Data data = new Data();
                data.setaWeather(sportGroup.getWeather());
                data.setCurrent(sportGroup.isCurrent());
                clientResponse.setData(Arrays.asList(data));
                responseContext.put("outside", sportGroup.getSportGroup() == SportGroup.OUTSIDE);
                System.out.println("pocasi vyhledano: "+ d + ";"+ week);
            }
            if (context.isAction()) {
                clientResponse.setData(find(sports, sportsGroup, days, week, time));
                System.out.println("vyhledano");
            }
        }catch (TimePassedException e) {
            clientResponse.setError(true);
        }
        clientResponse.setContext(responseContext);
        clientResponse.setText((List<String>) response.getOutput().get("text"));
//        clientResponse.setText(response.getOutput().get("text").toString());
        System.out.println("vysledek vracen");
        return clientResponse;
    }
    private List<Data> find(List<String> sportsList, List<String> sportsGroupList, List<Day> days, Week week, Integer timeInteger) throws TimePassedException {
        List<Data> datas = new ArrayList<>();
        List<SportType> sports = getSportType(sportsList);
        List<SportGroup> sportGroup = getSportGroup(sportsGroupList);
        OpeningTime openingTime = new OpeningTime();
        int timeInt;
        if (timeInteger==null){
            timeInt = 12;
            openingTime.setFrom(0);
            openingTime.setFrom(24);
        }else{
            timeInt = timeInteger.intValue();
            openingTime.setFrom(timeInteger.intValue());
            openingTime.setFrom(timeInteger.intValue()+1);
        }
        for (Day d : days) {
            SportGroupForecast sgp;
            Data data = new Data();
            sgp = weatherService.getSportGroupAndForecastForDate(timeInt, d, week);
            data.setaWeather(sgp.getWeather());
            data.setCurrent(sgp.isCurrent());
            data.setDay(d);
            List<SportGroup> search = !sportGroup.isEmpty() ? sportGroup : Arrays.asList(sgp.getSportGroup());
            data.setPlaces(getSportPlacesByGroup(sports,search,d,openingTime));
            datas.add(data);
        }
        return datas;

    }

    private List<SportPlace> getSportPlacesByGroup(List<SportType> sports,List<SportGroup> searchGroup, Day day, OpeningTime time){
        List<SportPlace> sportPlaces = new ArrayList<>();
        List<SportType> sportTypes = new ArrayList<>();
        if(sports.isEmpty()){
            for ( SportGroup group : searchGroup){
                if(group==SportGroup.OUTSIDE){
                    sportPlaces.addAll(dataFinder.findOutsideSport());
                }
                if(group==SportGroup.INSIDE){
                    sportPlaces.addAll(dataFinder.findInsideSport());
                }
            }
            sportPlaces = dataFinder.findSportInGroup(searchGroup);
        }else{
            sportTypes = sports;
            sportPlaces = dataFinder.findSport(sports);
        }
        sportPlaces = dataSorter.sortByPriority(sportPlaces,sportTypes,Arrays.asList(day),time);
        return sportPlaces;
    }
    private List<SportType> getSportType(List<String> sportsList){
        List<SportType> sports = new ArrayList<>();
        if (sportsList!=null) {
            for (String str : sportsList) {
                sports.add(Utils.lookupSporType(str));
            }
        }
        return sports;
    }

    private List<SportGroup> getSportGroup(List<String> sportsGroupList){
        List<SportGroup> sportGroup = new ArrayList<>();
        if (sportsGroupList!=null) {
            for (String str : sportsGroupList) {
                sportGroup.add(getSportGroup(str));
            }
        }
        return sportGroup;
    }
    private Set<SportType> getSportTypes(List<SportGroup> sportGroups) {
        Set<SportType> sportTypes = new HashSet<>();
        for(SportGroup group : sportGroups){
            sportTypes.addAll(group.getSportTypes());
        }
        return sportTypes;
    }
    private List<Day> getListDay(Day day){
        List<Day> list = new ArrayList<>();
        if(day!=null ) {
            if (day == Day.WEEKEND) {
                list.add(Day.SATURDAY);
                list.add(Day.SUNDAY);
            } else {
                list.add(Utils.getWeekDay(day));
            }
        }else{
            list = Arrays.asList(Day.values());
        }
        return list;
    }

    public SportGroup getSportGroup(String str) {
        SportGroup[] sportGroups = SportGroup.values();
        for(int i=0;i<sportGroups.length;i++){
            if (sportGroups[i].getStringName().equalsIgnoreCase(str)) return sportGroups[i];
        }
        return null;
    }
}
