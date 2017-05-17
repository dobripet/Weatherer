package cz.zcu.kiv.si.sportbot.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Context {
    @JsonProperty("conversation_id")
    private String conversationId;
    @JsonProperty("system")
    private MySystem system;
    @JsonProperty("default_counter")
    private int defaultCounter;

    /*od mateje*/
    @JsonProperty("day")
    private String day;
    @JsonProperty("day_spec")
    private String daySpec;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("sports")
    private List<String> sports;
    @JsonProperty("sportgroups")
    private List<String> sportgroups;
    @JsonProperty("find_weather")
    private Boolean findWeather;
    @JsonProperty("find_where")
    private Boolean findWhere;
    @JsonProperty("find_when")
    private Boolean findWhen;
    @JsonProperty("find_price")
    private Boolean findPrice;
    @JsonProperty("action")
    private boolean action;

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDaySpec() {
        return daySpec;
    }

    public void setDaySpec(String daySpec) {
        this.daySpec = daySpec;
    }

    public int getDefaultCounter() {
        return defaultCounter;
    }

    public void setDefaultCounter(int defaultCounter) {
        this.defaultCounter = defaultCounter;
    }


    public List<String> getSportgroups() {
        return sportgroups;
    }

    public void setSportgroups(List<String> sportgroups) {
        this.sportgroups = sportgroups;
    }

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    public MySystem getSystem() {
        return system;
    }

    public void setSystem(MySystem system) {
        this.system = system;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Boolean getFindPrice() {
        return findPrice;
    }

    public void setFindPrice(Boolean findPrice) {
        this.findPrice = findPrice;
    }

    public Boolean getFindWeather() {
        return findWeather;
    }

    public void setFindWeather(Boolean findWeather) {
        this.findWeather = findWeather;
    }

    public Boolean getFindWhen() {
        return findWhen;
    }

    public void setFindWhen(Boolean findWhen) {
        this.findWhen = findWhen;
    }

    public Boolean getFindWhere() {
        return findWhere;
    }

    public void setFindWhere(Boolean findWhere) {
        this.findWhere = findWhere;
    }
}
