package com.angelhack.mapteam.controller;


import com.angelhack.mapteam.api.model.ProfileResponse;
import com.angelhack.mapteam.model.MemberUser;
import com.angelhack.mapteam.repository.MemberUserRepository;
import com.angelhack.mapteam.util.FacebookToToken;
import com.angelhack.mapteam.util.ProfileJson;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;
import com.restfb.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class FacebookCallbackController {

    //https://graph.facebook.com/v2.10/oauth/access_token?client_id=368897760172030&redirect_uri=http://localhost:8080/AngelHack/getFBCode&client_secret=921a94223f3f0f147196b46ba1a6761e&code={code-parameter}

    //https://www.facebook.com/v2.10/dialog/oauth?client_id=368897760172030&redirect_uri=http://localhost:8080/AngelHack/getFBCode
    //EAAFPgrP0FZC4BAGC9QV1bFYXiWn30Ot2aDJE8zulSmS3GtTcXEYBws4vIWG3oBH6wBCyPxyZCtYazUEjz3RZCNMf5x3cfLHgHa3V5t3KeZAhcsAKWaTW356TAwWATaHYedpYusCVrxb9RqTdtEAxqEZAdiInZCmLgZAKTcTicB7eAZDZD


    @Autowired
    MemberUserRepository memberUserRepository;

    @RequestMapping(value = "/askSignIn", method = RequestMethod.GET, headers = "Accept=application/json")
    public String askSignIn(Model model) {

         System.out.println("ask signin:");
        return "redirect:https://www.facebook.com/v2.10/dialog/oauth?client_id=368897760172030&redirect_uri=http://localhost:8080/AngelHack/getFBCode&scope=public_profile,email,user_friends";
    }

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


        memberUserRepository.save(memberUser);

        return "memberDetail";

    }


    @RequestMapping(value = "/addMember", method = RequestMethod.POST, headers = "text/html")
    public String addMember(@ModelAttribute("memberUser") MemberUser memberUser) {
        if(memberUser.getId()!=null || !"".equals(memberUser.getId())) {
            memberUserRepository.save(memberUser);
        }

        return "redirect:/getAllCountries";
    }


}
