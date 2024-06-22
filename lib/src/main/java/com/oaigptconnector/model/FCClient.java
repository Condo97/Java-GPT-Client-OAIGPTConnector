package com.oaigptconnector.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.Constants;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.request.chat.completion.*;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public final class FCClient {

    private FCClient() {

    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, double temperature, String apiKey, HttpClient httpClient, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(
                fcClass,
                model,
                maxTokens,
                temperature,
                apiKey,
                httpClient,
                List.of(messages));
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, double temperature, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(
                fcClass,
                model,
                maxTokens,
                1,
                temperature,
                apiKey,
                httpClient,
                messages
        );
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, int n, double temperature, String apiKey, HttpClient httpClient, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(
                fcClass,
                model,
                maxTokens,
                n,
                temperature,
                apiKey,
                httpClient,
                List.of(messages));
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, int n, double temperature, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        // Get the function call name from fcClass using OAIFunctionCallSerializer
        String fcName = OAIFunctionCallSerializer.getFunctionName(fcClass);

        return serializedChatCompletion(
                List.of(fcClass),
                fcName,
                model,
                maxTokens,
                n,
                temperature,
                apiKey,
                httpClient,
                messages
        );
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(List<Class> fcClasses, String fcToCallName, String model, int maxTokens, int n, double temperature, String apiKey, HttpClient httpClient, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(
                fcClasses,
                fcToCallName,
                model,
                maxTokens,
                n,
                temperature,
                apiKey,
                httpClient,
                List.of(messages));
    }


    /***
     * Takes an annotated FunctionCall class list and name of function call to call, serializes it, calls OAIClient to get response, and deserializes response setting fcObject fields
     *
     * @param fcClasses
     * @param fcToCallName
     * @param model
     * @param maxTokens
     * @param n
     * @param temperature
     * @param apiKey
     * @param messages
     * @return
     * @throws OAISerializerException
     * @throws OpenAIGPTException
     * @throws IOException
     * @throws InterruptedException
     */
    public static OAIGPTChatCompletionResponse serializedChatCompletion(List<Class> fcClasses, String fcToCallName, String model, int maxTokens, int n, double temperature, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        // Adapt to list of FCBase serializedFCObjects
        List<Object> serializedFCObjects = new ArrayList<>();
        for (Class fcClass: fcClasses) {
            serializedFCObjects.add(OAIFunctionCallSerializer.objectify(fcClass));
        }

//        // Create requestFunctionCall
//        OAIChatCompletionRequestFunctionCall requestFunctionCall = new OAIChatCompletionRequestFunctionCall(fcToCallName);

        // Create requestToolChoiceFunction for function requestToolChoice
        OAIChatCompletionRequestToolChoiceFunction.Function requestToolChoiceFunction = new OAIChatCompletionRequestToolChoiceFunction.Function(fcToCallName);

        // Create requestToolChoice as Function tool choice
        OAIChatCompletionRequestToolChoice requestToolChoice = new OAIChatCompletionRequestToolChoiceFunction(requestToolChoiceFunction);

        // Create OAIChatCompletionRequest
        OAIChatCompletionRequest request = OAIChatCompletionRequest.build(
                model,
                maxTokens,
                temperature,
                messages,
                requestToolChoice,
                serializedFCObjects
        );

//        // Create HttpClient
//        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

        // Execute request and return response
        OAIGPTChatCompletionResponse response = OAIClient.postChatCompletion(
                request,
                apiKey,
                httpClient
        );

        return response;
    }

}
