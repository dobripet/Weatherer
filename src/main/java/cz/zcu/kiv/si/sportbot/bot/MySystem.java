package cz.zcu.kiv.si.sportbot.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
public class MySystem {
    @JsonProperty("dialog_stack")
    private List<DialogStack> dialog_stack;
    @JsonProperty("branch_exited_reason")
    private String branchExitedReason;
    @JsonProperty("_node_output_map")
    private Map<String,Object> _node_output_map;
    @JsonProperty("dialog_turn_counter")
    private int dialogTurnCounter;
    @JsonProperty("dialog_request_counter")
    private int dialogRequestCounter;
    @JsonProperty("branch_exited")
    private boolean branchExited;
}
