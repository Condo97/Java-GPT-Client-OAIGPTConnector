package com.oaigptconnector.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.Constants;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import com.oaigptconnector.model.response.error.OpenAIGPTErrorResponse;
import httpson.Httpson;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class OAIClient extends Httpson {

    private OAIClient() {

    }

    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

    private static HttpClient getClient() {
        return client;
    }

    public static OAIGPTChatCompletionResponse postChatCompletion(Object requestObject, String apiKey) throws OpenAIGPTException, IOException, InterruptedException {
        Consumer<HttpRequest.Builder> c = requestBuilder -> {
            requestBuilder.setHeader("Authorization", "Bearer " + apiKey);
        };

        JsonNode response = sendPOST(requestObject, OAIClient.getClient(), Constants.OPENAI_URI, c);

        try {
            OAIGPTChatCompletionResponse oaiChatcompletionResponse = new ObjectMapper().treeToValue(response, OAIGPTChatCompletionResponse.class);
            if (oaiChatcompletionResponse == null)
                throw new RuntimeException("");

            return oaiChatcompletionResponse;
        } catch (JsonProcessingException e) {
            System.out.println("Issue Mapping OAIGPTChatCompletionResponse: " + response);

            throw new OpenAIGPTException(e, new ObjectMapper().treeToValue(response, OpenAIGPTErrorResponse.class));
        }
    }

    public static Stream<String> postChatCompletionStream(Object requestObject, String apiKey) throws IOException, InterruptedException {
        // TODO: Make this better
        Consumer<HttpRequest.Builder> c = requestBuilder -> {
            requestBuilder.setHeader("Authorization", "Bearer " + apiKey);
        };

        Stream<String> stream = sendPOSTStream(requestObject, OAIClient.getClient(), Constants.OPENAI_URI, c);
        return stream;
    }

}
