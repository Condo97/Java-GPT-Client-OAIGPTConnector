package com.oaigptconnector.model;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.Constants;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import com.oaigptconnector.model.response.error.OpenAIGPTErrorResponse;
import httpson.Httpson;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class OAIConnector extends Httpson {

    public static OAIGPTChatCompletionResponse postChatCompletion(Object requestObject, String apiKey) throws OpenAIGPTException, IOException, InterruptedException {
        Consumer<HttpRequest.Builder> c = requestBuilder -> {
            requestBuilder.setHeader("Authorization", "Bearer " + apiKey);
        };

        JsonNode response = sendPOST(requestObject, OAIClient.getClient(), Constants.OPENAI_URI, c);

        try {
            return new ObjectMapper().treeToValue(response, OAIGPTChatCompletionResponse.class);
        } catch (JsonMappingException e) {
            System.out.println("Issue Mapping OpenAIGPTErrorResponseJSON: " + response.asText());
            throw new OpenAIGPTException(new ObjectMapper().treeToValue(response, OpenAIGPTErrorResponse.class));
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
