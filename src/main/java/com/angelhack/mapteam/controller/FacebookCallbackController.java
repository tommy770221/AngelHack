package com.angelhack.mapteam.controller;


import com.angelhack.mapteam.api.model.IPtoLocation;
import com.angelhack.mapteam.api.model.ProfileResponse;
import com.angelhack.mapteam.model.MemberCondition;
import com.angelhack.mapteam.model.MemberUser;
import com.angelhack.mapteam.repository.MemberConditionRepository;
import com.angelhack.mapteam.repository.MemberUserRepository;
import com.angelhack.mapteam.specification.MemberUserSpecification;
import com.angelhack.mapteam.util.FacebookToToken;
import com.angelhack.mapteam.util.IPtoLocationJson;
import com.angelhack.mapteam.util.ProfileJson;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;
import com.restfb.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class FacebookCallbackController {

    //https://graph.facebook.com/v2.10/oauth/access_token?client_id=368897760172030&redirect_uri=http://localhost:8080/AngelHack/getFBCode&client_secret=921a94223f3f0f147196b46ba1a6761e&code={code-parameter}

    //https://www.facebook.com/v2.10/dialog/oauth?client_id=368897760172030&redirect_uri=http://localhost:8080/AngelHack/getFBCode
    //EAAFPgrP0FZC4BAGC9QV1bFYXiWn30Ot2aDJE8zulSmS3GtTcXEYBws4vIWG3oBH6wBCyPxyZCtYazUEjz3RZCNMf5x3cfLHgHa3V5t3KeZAhcsAKWaTW356TAwWATaHYedpYusCVrxb9RqTdtEAxqEZAdiInZCmLgZAKTcTicB7eAZDZD


    @Autowired
    MemberUserRepository memberUserRepository;

    @Autowired
    MemberConditionRepository memberConditionRepository;

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/askSignIn", method = RequestMethod.GET, headers = "Accept=application/json")
    public String askSignIn(Model model) {

         System.out.println("ask signin:");
        return "redirect:https://www.facebook.com/v2.10/dialog/oauth?client_id=368897760172030&redirect_uri=http://tommy770221.com:8080/AngelHack/getFBCode&scope=public_profile,email,user_friends";
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/getFBCode", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getFacebookCode(Model model, @RequestParam(value = "code")String code) throws IOException {

        System.out.println(code+" code ");
        FacebookToToken facebookToToken=new FacebookToToken();
        String token="";
        try {
           token= facebookToToken.changeCode(code);
           System.out.println("token"+token);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FacebookClient facebookClient=new DefaultFacebookClient(token, Version.VERSION_2_8);
        JsonObject user = facebookClient.fetchObject("me", JsonObject.class);
        ProfileJson profileJson=new ProfileJson();
        MemberUser memberUser=new MemberUser();
        ProfileResponse profileResponse= profileJson.getProFile(user.get("id").toString(),token);

        System.out.println(user.get("name"));
        System.out.println(user.get("id"));

        System.out.println(profileResponse.getId());
        System.out.println(profileResponse.getGender());
        System.out.println(profileResponse.getLocale());
        System.out.println(profileResponse.getName());
        System.out.println(profileResponse.getEmail());
        memberUser.setFbId(profileResponse.getId());
        memberUser.setName(profileResponse.getName());
        memberUser.setGender(profileResponse.getGender());
        memberUser.setLocale(profileResponse.getLocale());
        memberUser.setEmail(profileResponse.getEmail());
        if(profileResponse.getAgeRange()!=null){
            System.out.println(profileResponse.getAgeRange().getMin());
            memberUser.setAgeRange(String.valueOf(profileResponse.getAgeRange().getMin()));
            model.addAttribute("age",String.valueOf(profileResponse.getAgeRange().getMin()));
        }
        model.addAttribute("memberUser",memberUser);
        model.addAttribute("fbId",profileResponse.getId());
        model.addAttribute("gender",profileResponse.getGender());
        model.addAttribute("name",profileResponse.getName());
        model.addAttribute("locale",profileResponse.getLocale());
        model.addAttribute("email",profileResponse.getEmail());

        MemberUser memberUser1=memberUserRepository.searchByFBID(profileResponse.getId());
        if(memberUser1==null) {
            memberUserRepository.save(memberUser);
        }else{
            System.out.println("memberUser1 : "+ memberUser1.getName());
        }
        return "memberDetail";

    }


    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public String addMember(@ModelAttribute("memberUser") MemberUser memberUser) {
        if(memberUser.getId()!=null || !"".equals(memberUser.getId())) {
         //   memberUserRepository.save(memberUser);
        }

        return "redirect:/getAllCountries";
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/updateLoc", method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json")
    @ResponseBody
    public String updateLoc(@RequestParam(value = "email")String email,
                            @RequestParam(value = "lon")Double lon,
                            @RequestParam(value = "lat")Double lat,
                            HttpServletResponse httpResponse) {
        try {
            MemberUser memberUser=memberUserRepository.searchByEmail(email);
            memberUser.setLon(lon);
            memberUser.setLat(lat);
            memberUserRepository.save(memberUser);
        } catch (Exception e) {
            e.printStackTrace();
            httpResponse.setStatus(500);
            return "\"status\":\"error\"";
        }

        return "\"status\":\"ok\"";
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/accessCondition",method = {RequestMethod.POST,RequestMethod.GET})
    public String searchMember(
                               @RequestParam(value = "email",required = false)String email,
                               @RequestParam(value = "gender",required = false)String gender,
                               @RequestParam(value = "locale",required = false)String locale,
                               @RequestParam(value = "ageRange",required = false)String ageRange,
                               @RequestParam(value = "page",required = false)Integer page,
                               @RequestParam(value = "size",required = false)Integer size,
                               HttpServletRequest request
                         ) {
        System.out.println("search member");
        System.out.println(request.getRemoteAddr());
        IPtoLocationJson iPtoLocationJson=new IPtoLocationJson();
        IPtoLocation iPtoLocation=null;
        try {
            iPtoLocation=iPtoLocationJson.transIpTolocation(request.getRemoteAddr());
        } catch (Exception e) {
            e.printStackTrace();
        }
        MemberCondition memberCondition=new MemberCondition();
        MemberUser memberUser=memberUserRepository.searchByEmail(email);
        memberCondition.setAgeRange(ageRange);
        memberCondition.setGender(gender);
        memberCondition.setLocale(locale);
        memberCondition.setEmail(email);
        if(iPtoLocation !=null){
            memberCondition.setLon(iPtoLocation.getLon());
            memberCondition.setLat(iPtoLocation.getLat());
            memberUser.setLat(iPtoLocation.getLat());
            memberUser.setLon(iPtoLocation.getLon());
            memberUserRepository.save(memberUser);
        }

        MemberCondition memberConditionExist=memberConditionRepository.searchByEmail(email);
        if(memberConditionExist==null){
            memberConditionExist=memberConditionRepository.save(memberCondition);
        }else{
            if(iPtoLocation !=null){
                memberCondition.setLon(iPtoLocation.getLon());
                memberCondition.setLat(iPtoLocation.getLat());
            }
            memberConditionExist.setAgeRange(ageRange);
            memberConditionExist.setGender(gender);
            memberConditionExist.setLocale(locale);
            memberConditionExist=memberConditionRepository.save(memberConditionExist);
        }

//
//        try {
//           System.out.println(URLEncoder.encode(name,"utf-8"));
//           System.out.println(new String(name.getBytes("utf-8")));
//           System.out.println(URLDecoder.decode(name,"utf-8"));
//           System.out.println(URLDecoder.decode(name,"big5"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        Pageable pageable=null;
//        if(page!=null && size!=null){
//           pageable=new PageRequest(page,size);
//        }else{
//           pageable=new PageRequest(1,10);
//        }
//
//        Specification<MemberUser> spec = new MemberUserSpecification(memberUser);
//        Page<MemberUser> travels  = memberUserRepository.findAll(spec, pageable);
//        for(MemberUser memberUser1:travels.getContent()){
//            System.out.println(memberUser1.getEmail());
//        }

        //if null templorlly set some value
        if(memberConditionExist.getLon()==null){
            memberConditionExist.setLon(new Double("121.4966"));
        }

        if(memberConditionExist.getLat()==null){
            memberConditionExist.setLat(new Double("25.0418"));
        }

        return "redirect:http://hsiangyu.com/AH10/index.html?memberCondition="+memberConditionExist.getId()+"&lon="+memberConditionExist.getLon()+"&lat="+memberConditionExist.getLat();
    }


}
