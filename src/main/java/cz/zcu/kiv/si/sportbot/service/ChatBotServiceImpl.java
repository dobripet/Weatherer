package cz.zcu.kiv.si.sportbot.service;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * @author Marek Rasocha
 *         date 02.05.2017.
 */
public class ChatBotServiceImpl {
    private ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03,"b4d5e338-b5d2-4b91-bc50-67a4f73e2349", "om4MLqXIVcj0");


    public ChatBotServiceImpl() {
    }
    // TODO: upravit
    public String sendMessage(String messageContent) {
        ConversationService service = new ConversationService("2017-04-21");
        service.setUsernameAndPassword("{username}", "{password}");


        MessageRequest newMessage = new MessageRequest.Builder()
                .inputText(messageContent)
                        // Replace with the context obtained from the initial request
                        //.context(...)
                .build();

        String workspaceId = "25dfa8a0-0263-471b-8980-317e68c30488";

        MessageResponse response = service
                .message(workspaceId, newMessage)
                .execute();

        System.out.println(response);
        return null;
    }
}
