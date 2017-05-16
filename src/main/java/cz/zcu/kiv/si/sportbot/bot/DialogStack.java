package cz.zcu.kiv.si.sportbot.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
public class DialogStack {
    @JsonProperty("dialog_node")
    private String dialog_node;

    public DialogStack() {
    }

    public String getDialog_node() {
        return dialog_node;
    }

    public void setDialog_node(String dialog_node) {
        this.dialog_node = dialog_node;
    }
}
