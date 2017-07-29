package com.angelhack.mapteam.util;

import com.angelhack.mapteam.api.model.AccessTokenResponse;
import com.angelhack.mapteam.api.model.IPtoLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class IPtoLocationJson {

    public IPtoLocation transIpTolocation(String ip) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://ip-api.com/json/"+ip)
                .get()
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String ipLocation=response.body().string();
        ObjectMapper objectMapper=new ObjectMapper();
        IPtoLocation iPtoLocation= objectMapper.readValue(ipLocation, IPtoLocation.class);
        System.out.println("response : "+ iPtoLocation.getLon());

        return iPtoLocation;

    }
}
