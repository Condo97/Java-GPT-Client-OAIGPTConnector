package com.oaigptconnector.core;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.core.HttpsClientHelper;
import com.oaigptconnector.model.http.client.openaigpt.OpenAIClient;
import com.oaigptconnector.model.http.client.openaigpt.exception.OpenAIGPTException;
import com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.OAIGPTChatCompletionRequest;
import com.oaigptconnector.model.http.client.openaigpt.response.error.OpenAIGPTErrorResponse;
import com.oaigptconnector.model.http.client.openaigpt.response.chat.completion.http.OAIGPTChatCompletionResponse;
import com.oaigptconnector.Constants;
import com.oaigptconnector.keys.Keys;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class OpenAIGPTHttpsClientHelper extends HttpsClientHelper {

    public static OAIGPTChatCompletionResponse postChatCompletion(Object requestObject, String apiKey) throws OpenAIGPTException, IOException, InterruptedException {
        Consumer<HttpRequest.Builder> c = requestBuilder -> {
            requestBuilder.setHeader("Authorization", "Bearer " + apiKey);
        };

        JsonNode response = sendPOST(requestObject, OpenAIClient.getClient(), Constants.OPENAI_URI, c);

        try {
            return new ObjectMapper().treeToValue(response, OAIGPTChatCompletionResponse.class);
        } catch (JsonMappingException e) {
            System.out.println("Issue Mapping OpenAIGPTErrorResponseJSON: " + response.asText());
            throw new OpenAIGPTException(new ObjectMapper().treeToValue(response, OpenAIGPTErrorResponse.class));
        }
    }

    public static Stream<String> postChatCompletionStream(OAIGPTChatCompletionRequest requestObject, String apiKey) throws IOException, InterruptedException {
        // TODO: Make this better
        Consumer<HttpRequest.Builder> c = requestBuilder -> {
            requestBuilder.setHeader("Authorization", "Bearer " + apiKey);
        };

        Stream<String> stream = sendPOSTStream(requestObject, OpenAIClient.getClient(), Constants.OPENAI_URI, c);
        return stream;
    }

}
