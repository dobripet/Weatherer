package cz.zcu.kiv.si.sportbot.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
public class Context {
    @JsonProperty("conversation_id")
    private String conversationId;
    @JsonProperty("system")
    private MySystem system;
    @JsonProperty("AConoff")
    private String AConoff;
    @JsonProperty("lightonoff")
    private String lightonoff;
    @JsonProperty("musiconoff")
    private String musiconoff;
    @JsonProperty("appl_action")
    private String applAction;
    @JsonProperty("heateronoff")
    private String heateronoff;
    @JsonProperty("volumeonoff")
    private String volumeonoff;
    @JsonProperty("wipersonoff")
    private String wipersonoff;
    @JsonProperty("default_counter")
    private int defaultCounter;

    /*od mateje*/
    @JsonProperty("day")
    private String day;
    @JsonProperty("day_spec")
    private String daySpec;
    @JsonProperty("time")
    private int time;
    @JsonProperty("sports")
    private List<String> sports;
    @JsonProperty("sportgroups")
    private List<String> sportgroups;

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getAConoff() {
        return AConoff;
    }

    public void setAConoff(String AConoff) {
        this.AConoff = AConoff;
    }

    public String getApplAction() {
        return applAction;
    }

    public void setApplAction(String applAction) {
        this.applAction = applAction;
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

    public String getHeateronoff() {
        return heateronoff;
    }

    public void setHeateronoff(String heateronoff) {
        this.heateronoff = heateronoff;
    }

    public String getLightonoff() {
        return lightonoff;
    }

    public void setLightonoff(String lightonoff) {
        this.lightonoff = lightonoff;
    }

    public String getMusiconoff() {
        return musiconoff;
    }

    public void setMusiconoff(String musiconoff) {
        this.musiconoff = musiconoff;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getVolumeonoff() {
        return volumeonoff;
    }

    public void setVolumeonoff(String volumeonoff) {
        this.volumeonoff = volumeonoff;
    }

    public String getWipersonoff() {
        return wipersonoff;
    }

    public void setWipersonoff(String wipersonoff) {
        this.wipersonoff = wipersonoff;
    }

    @JsonProperty("action")
    private boolean action

            ;


}
