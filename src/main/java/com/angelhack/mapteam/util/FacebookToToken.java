package com.angelhack.mapteam.util;

import com.angelhack.mapteam.api.model.AccessTokenResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class FacebookToToken {

     public String changeCode(String code) throws IOException {
         OkHttpClient client = new OkHttpClient();

         Request request = new Request.Builder()
                 .url("https://graph.facebook.com/v2.10/oauth/access_token?client_id=368897760172030%0A&redirect_uri=http%3A%2F%2F10.187.1.18%3A8080%2FAngelHack%2FgetFBCode&client_secret=921a94223f3f0f147196b46ba1a6761e&code="+code)
                 .get()
                 .addHeader("cache-control", "no-cache")
                 .addHeader("postman-token", "b540246f-08b2-1634-bdd8-a708d90bd312")
                 .build();

         Response response = client.newCall(request).execute();
         String token=response.body().string();
         ObjectMapper objectMapper=new ObjectMapper();
         AccessTokenResponse accessTokenResponse= objectMapper.readValue(token, AccessTokenResponse.class);
         System.out.println("response"+accessTokenResponse.getAccessToken());
         return accessTokenResponse.getAccessToken();
     }

}
