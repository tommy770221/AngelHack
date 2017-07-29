package com.angelhack.mapteam.controller;


import com.angelhack.mapteam.model.Country;
import com.angelhack.mapteam.util.FacebookToToken;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.json.JsonObject;
import com.restfb.types.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @RequestMapping(value = "/askSignIn", method = RequestMethod.GET, headers = "Accept=application/json")
    public String askSignIn(Model model) {

         System.out.println("ask signin:");
        return "redirect:https://www.facebook.com/v2.10/dialog/oauth?client_id=368897760172030&redirect_uri=http://10.187.1.18:8080/AngelHack/getFBCode&scope=public_profile,email,user_friends";
    }

    @RequestMapping(value = "/getFBCode", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getFacebookCode(Model model, @RequestParam(value = "code")String code) {

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
        User user = facebookClient.fetchObject("me", User.class);

        System.out.println(user.getName());
        //  List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("country", new Country());
       // model.addAttribute("listOfCountries", listOfCountries);
        return "countryDetails";
    }



}
