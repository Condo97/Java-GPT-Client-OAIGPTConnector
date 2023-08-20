package com.oaigptconnector.model;

import com.oaigptconnector.Constants;
import httpson.Httpson;

import java.net.http.HttpClient;
import java.time.Duration;

public class OAIClient extends Httpson {

    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

    public static HttpClient getClient() {
        return client;
    }

}
