package cz.zcu.kiv.si.sportbot.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotResponse {
    @JsonProperty("entities")
    private List<String> entities;
    @JsonProperty("intents")
    private List<String> intents;
    @JsonProperty("input")
    private Object input;
    @JsonProperty("output")
    private Output output;
    @JsonProperty("context")
    private Context context;



}
