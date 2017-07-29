package com.angelhack.mapteam.util;

import com.angelhack.mapteam.api.model.ProfileResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class ProfileJson {

    public ProfileResponse getProFile(String fbId,String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://graph.facebook.com/v2.8/"+fbId+"?fields=name%2Cid%2Cemail%2Cage_range%2Cgender%2Clocale&access_token="+accessToken)
                .get()
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
        String body=response.body().string();
        ObjectMapper objectMapper=new ObjectMapper();
        ProfileResponse profileResponse=objectMapper.readValue(body,ProfileResponse.class);
        return profileResponse;
    }
}
