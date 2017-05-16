package cz.zcu.kiv.si.sportbot.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
public class Output {
    @JsonProperty("log_messages")
    private List<String> logMessages;
    @JsonProperty("text")
    private List<String> text;
    @JsonProperty("nodes_visited")
    private List<String> nodesVisited;

    public Output() {
    }

    public List<String> getLogMessages() {
        return logMessages;
    }

    public void setLogMessages(List<String> logMessages) {
        this.logMessages = logMessages;
    }

    public List<String> getNodesVisited() {
        return nodesVisited;
    }

    public void setNodesVisited(List<String> nodesVisited) {
        this.nodesVisited = nodesVisited;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
