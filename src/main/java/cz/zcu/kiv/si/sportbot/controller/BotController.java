/*******************************************************************************
 * Copyright (c) 2016 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/ 
package cz.zcu.kiv.si.sportbot.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.zcu.kiv.si.sportbot.model.ClientRequest;
import cz.zcu.kiv.si.sportbot.model.ClientResponse;
import cz.zcu.kiv.si.sportbot.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/bot")
public class BotController {

    @Autowired
    ChatBotService chatBotService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    //@CrossOrigin(origins = "http://localhost:8080")
    public ClientResponse communicate(@RequestBody String body){
        try {
            ClientRequest request = objectMapper.readValue(body, ClientRequest.class);
            System.out.println("cajk");
            return chatBotService.sendMessage(request.getContext(), request.getUserInput());
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClientResponse response = new ClientResponse();
        response.setError(true);
        return response;
    }
}