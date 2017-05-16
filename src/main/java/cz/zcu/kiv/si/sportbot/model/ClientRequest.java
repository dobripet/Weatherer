package cz.zcu.kiv.si.sportbot.model;

import java.util.Map;

public class ClientRequest {
    private String userInput;
    private Map<String,Object> context;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }
}
