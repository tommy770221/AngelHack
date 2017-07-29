package com.angelhack.mapteam.controller;


import com.angelhack.mapteam.model.Country;
import com.angelhack.mapteam.model.MemberMessage;
import com.angelhack.mapteam.repository.MemberMessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    MemberMessageRepository memberMessageRepository;


    @CrossOrigin(value = "*")
    @RequestMapping(value = "/getSingleMessages", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json")
    @ResponseBody
    public String getMessages(Model model,
                              @RequestParam(value = "fromEmail")String fromEmail,
                              @RequestParam(value = "toEmail")String toEmail,
                              HttpServletResponse response) {
        List<MemberMessage> memberMessageList=memberMessageRepository.searchByEmailAndDate(toEmail,fromEmail);
        ObjectMapper objectMapper=new ObjectMapper();
        String  memberMessagesStr=null;
        try {
          memberMessagesStr= objectMapper.writeValueAsString(memberMessageList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            response.setStatus(500);
            return "\"status\":\"error\"";
        }

        return memberMessagesStr;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addSingleMessages", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json")
    @ResponseBody
    public String addMessages(Model model,
                              @RequestParam(value = "fromEmail")String fromEmail,
                              @RequestParam(value = "toEmail")String toEmail,
                              @RequestParam(value = "message")String message,
                              @RequestParam(value = "lon")Double lon,
                              @RequestParam(value = "lat")Double lat,
                              HttpServletResponse response) {
        MemberMessage memberMessage=new MemberMessage();
        memberMessage.setCreateDate(new Date());
        memberMessage.setFromEmail(fromEmail);
        memberMessage.setToEmail(toEmail);
        memberMessage.setGetRead(Boolean.FALSE);
        memberMessage.setLon(lon);
        memberMessage.setLat(lat);
        try {
        memberMessage=memberMessageRepository.save(memberMessage);
        ObjectMapper objectMapper=new ObjectMapper();
        String  memberMessagesStr=null;

            memberMessagesStr= objectMapper.writeValueAsString(memberMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            response.setStatus(500);
            return "\"status\":\"error\"";
        }

        return "\"status\":\"ok\"";
    }
}
