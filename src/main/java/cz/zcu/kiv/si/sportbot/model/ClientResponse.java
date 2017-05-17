package cz.zcu.kiv.si.sportbot.model;

import cz.zcu.kiv.si.sportbot.bot.Context;
import cz.zcu.kiv.si.sportbot.dataLoader.object.SportPlace;

import java.util.List;
import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 16.05.2017.
 */
public class ClientResponse {
    private List<String> text;
    private Map<String,Object> context;
    private List<Data>  data;
    private boolean error;



    public ClientResponse() {
        error=false;
    }



    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
