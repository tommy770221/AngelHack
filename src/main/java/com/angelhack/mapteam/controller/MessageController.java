package com.angelhack.mapteam.controller;


import com.angelhack.mapteam.model.Country;
import com.angelhack.mapteam.model.MemberMessage;
import com.angelhack.mapteam.model.MemberMessageAll;
import com.angelhack.mapteam.model.MemberUser;
import com.angelhack.mapteam.repository.MemberMessageAllRepository;
import com.angelhack.mapteam.repository.MemberMessageRepository;
import com.angelhack.mapteam.repository.MemberUserRepository;
import com.angelhack.mapteam.util.distance.FlatEarthDist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    MemberMessageRepository memberMessageRepository;

    @Autowired
    MemberMessageAllRepository memberMessageAllRepository;

    @Autowired
    MemberUserRepository memberUserRepository;


    @CrossOrigin(value = "*")
    @RequestMapping(value = "/getSingleMessages", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json")
    @ResponseBody
    public String getMessages(Model model,
                              @RequestParam(value = "fromEmail")String fromEmail,
                              @RequestParam(value = "toEmail")String toEmail,
                              HttpServletResponse response) {
        List<MemberMessage> memberMessageList=memberMessageRepository.searchByEmailAndDate(toEmail,fromEmail);
        MemberUser memberUser=memberUserRepository.searchByEmail(fromEmail);
        for(MemberMessage memberMessage:memberMessageList){
            Double dis= FlatEarthDist.distance(memberMessage.getLat(),memberMessage.getLon(),memberUser.getLat(),memberUser.getLon());
            memberMessage.setDistance(dis);
        }
        ObjectMapper objectMapper=new ObjectMapper();
        DateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        objectMapper.setDateFormat(df);
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
    @RequestMapping(value = "/getAllMessages", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json")
    @ResponseBody
    public String getAllMessages(Model model,
                              @RequestParam(value = "fromEmail")String fromEmail,
                              HttpServletResponse response) {
        List<MemberMessageAll> memberMessageList=memberMessageAllRepository.searchByEmail(fromEmail);
        MemberUser memberUser=memberUserRepository.searchByEmail(fromEmail);
        for(MemberMessageAll memberMessageAll:memberMessageList){
            Double dis= FlatEarthDist.distance(memberMessageAll.getLat(),memberMessageAll.getLon(),memberUser.getLat(),memberUser.getLon());
            memberMessageAll.setDistance(dis);
        }

        ObjectMapper objectMapper=new ObjectMapper();
        DateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        objectMapper.setDateFormat(df);
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
    @RequestMapping(value = "/addAllMessages", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json")
    @ResponseBody
    public String addAllMessages(Model model,
                              @RequestParam(value = "fromEmail")String fromEmail,
                              @RequestParam(value = "message")String message,
                              @RequestParam(value = "lon")Double lon,
                              @RequestParam(value = "lat")Double lat,
                              HttpServletResponse response) {
        try {
            MemberMessageAll memberMessage=new MemberMessageAll();
            memberMessage.setCreateDate(new Date());
            memberMessage.setFromEmail(fromEmail);
            memberMessage.setMessage(message);
            memberMessage.setGetRead(Boolean.FALSE);
            memberMessage.setLon(lon);
            memberMessage.setLat(lat);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return "\"status\":\"error\"";
        }

        return "\"status\":\"ok\"";
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
        try {
        MemberMessage memberMessage=new MemberMessage();
        memberMessage.setCreateDate(new Date());
        memberMessage.setFromEmail(fromEmail);
        memberMessage.setToEmail(toEmail);
        memberMessage.setMessage(message);
        memberMessage.setGetRead(Boolean.FALSE);
        memberMessage.setLon(lon);
        memberMessage.setLat(lat);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return "\"status\":\"error\"";
        }

        return "\"status\":\"ok\"";
    }
}
