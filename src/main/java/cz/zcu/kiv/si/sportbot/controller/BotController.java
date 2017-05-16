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

import cz.zcu.kiv.si.sportbot.dataLoader.enums.Day;
import cz.zcu.kiv.si.sportbot.dataLoader.enums.Week;
import cz.zcu.kiv.si.sportbot.dataLoader.object.ClientResponse;
import cz.zcu.kiv.si.sportbot.service.BasicService;
import cz.zcu.kiv.si.sportbot.service.ChatBotService;
import cz.zcu.kiv.si.sportbot.utils.TimePassedException;
import cz.zcu.kiv.si.sportbot.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/bot")
public class BotController {

    @Autowired
    ChatBotService chatBotService;

    @RequestMapping()
    @ResponseBody
    public ClientResponse communicate(Map<String,Object> context, String userInput) {
        return chatBotService.sendMessage(context,userInput);
    }
}