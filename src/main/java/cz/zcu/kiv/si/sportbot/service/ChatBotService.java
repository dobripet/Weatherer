package cz.zcu.kiv.si.sportbot.service;

import cz.zcu.kiv.si.sportbot.model.ClientResponse;

import java.util.Map;

/**
 * @author Marek Rasocha
 *         date 02.05.2017.
 */
public interface ChatBotService {
    ClientResponse sendMessage(Map<String,Object> previousContext,String text);
}
