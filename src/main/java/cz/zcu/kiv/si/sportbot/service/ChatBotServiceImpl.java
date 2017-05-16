package cz.zcu.kiv.si.sportbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import cz.zcu.kiv.si.sportbot.bot.BotResponse;
import cz.zcu.kiv.si.sportbot.bot.Context;
import cz.zcu.kiv.si.sportbot.dataLoader.DataSorter;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportGroup;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.SportType;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Week;
import cz.zcu.kiv.si.sportbot.dataLoader.object.ClientResponse;
import cz.zcu.kiv.si.sportbot.dataLoader.object.OpeningTime;
import cz.zcu.kiv.si.sportbot.dataLoader.object.Sport;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;
import cz.zcu.kiv.si.sportbot.model.SportGroupForecast;
import cz.zcu.kiv.si.sportbot.utils.TimePassedException;
import cz.zcu.kiv.si.sportbot.utils.Utils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author Marek Rasocha
 *         date 02.05.2017.
 */
public class ChatBotServiceImpl implements ChatBotService{
    private static final Logger logger = LogManager.getLogger(ChatBotServiceImpl.class.getName());
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
        service.setUsernameAndPassword("{username}", "{password}");
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
        String workspaceId = "25dfa8a0-0263-471b-8980-317e68c30488";

        MessageResponse response = service
                .message(workspaceId, newMessage)
                .execute();
        //action
        ObjectMapper mapper = new ObjectMapper();
        Context context = mapper.convertValue(response.getContext(), Context.class);
        ClientResponse clientResponse = new ClientResponse();
        if(context.isAction()){
            List<String> sports = context.getSports();
            List<String> sportsGroup = context.getSportgroups();
            String day = context.getDay();
            String daySpec = context.getDaySpec();
            int time = context.getTime();
            try {
                find(sports,sportsGroup,day,daySpec,time);
            } catch (TimePassedException e) {
                clientResponse.setBug(true);
                clientResponse.setErrorMessage("Chyba pri parsovani casu:" +e);
            }
        }
        clientResponse.setContext(response.getContext());
        clientResponse.setBotResponse(response.getOutput().get("text").toString());
        return clientResponse;
    }

    private List<SportPlace> find(List<String> sportsList, List<String> sportsGroupList, String dayString, String daySpecString, int timeInt) throws TimePassedException {
        List<SportType> sports = new ArrayList<>();
        for (String str : sportsList){
            sports.add(SportType.valueOf(str));
        }
        List<SportGroup> sportGroup = new ArrayList<>();
        for (String str : sportsGroupList){
            sportGroup.add(getSportGroup(str));
        }
        List<Day> days = getListDay(Day.valueOf(dayString));
        Week week = Week.valueOf(daySpecString);
        List<SportGroupForecast> forecastList = new ArrayList<>();
        List<SportGroup> sportGroup2 = new ArrayList<>();
        for(Day d : days){
            SportGroupForecast sgp;
            forecastList.add(sgp=weatherService.getSportGroupAndForecastForDate(timeInt, d, week));
            if(!sportGroup.contains(sgp.getSportGroup())) sportGroup.add(sgp.getSportGroup());
        }
        List<SportGroup> search = !sportGroup.isEmpty() ? sportGroup : sportGroup2;
        List<SportPlace> sportPlaces = dataFinder.findSportInGroup(search);
        sportPlaces = dataSorter.sortByPriority(sportPlaces,sports,days,new OpeningTime(timeInt,timeInt+1));
        return sportPlaces;

    }

    private List<Day> getListDay(Day day){
        List<Day> list = new ArrayList<>();
        if (day==Day.WEEKEND){
            list.add(Day.SATURDAY);
            list.add(Day.SUNDAY);
        }else{
            list.add(Utils.getWeekDay(day));
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
