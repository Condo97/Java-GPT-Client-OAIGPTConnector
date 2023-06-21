package com.oaigptconnector.model.http.client.openaigpt;

import com.oaigptconnector.Constants;

import java.net.http.HttpClient;
import java.time.Duration;

public class OpenAIClient {

    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

    public static HttpClient getClient() {
        return client;
    }

}
