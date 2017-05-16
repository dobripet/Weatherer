package cz.zcu.kiv.si.sportbot.dataLoader.object;

import cz.zcu.kiv.si.sportbot.bot.Context;

import java.util.List;
import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 16.05.2017.
 */
public class ClientResponse {
    private String botResponse;
    private Map<String,Object> context;
    private List<SportPlace> places;
    private boolean bug;
    private String errorMessage;

    public ClientResponse() {
        bug=false;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    public List<SportPlace> getPlaces() {
        return places;
    }

    public void setPlaces(List<SportPlace> places) {
        this.places = places;
    }

    public boolean isBug() {
        return bug;
    }

    public void setBug(boolean bug) {
        this.bug = bug;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
