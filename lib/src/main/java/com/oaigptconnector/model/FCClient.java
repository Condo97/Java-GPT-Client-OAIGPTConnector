package com.oaigptconnector.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.request.chat.completion.*;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public final class FCClient {

    private FCClient() {

    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClass, model, maxTokens, temperature, responseFormatType, apiKey, httpClient, List.of(messages));
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, boolean printResponse, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClass, model, maxTokens, temperature, responseFormatType, apiKey, httpClient, List.of(messages), printResponse);
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClass, model, maxTokens, 1, temperature, responseFormatType, apiKey, httpClient, messages);
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages, boolean printResponse) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClass, model, maxTokens, 1, temperature, responseFormatType, apiKey, httpClient, messages, printResponse);
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClass, model, maxTokens, n, temperature, responseFormatType, apiKey, httpClient, List.of(messages));
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, boolean printResponse, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClass, model, maxTokens, n, temperature, responseFormatType, apiKey, httpClient, List.of(messages), printResponse);
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        String fcName = JSONSchemaSerializer.getFunctionName(fcClass);
        return serializedChatCompletion(List.of(fcClass), fcName, model, maxTokens, n, temperature, responseFormatType, apiKey, HttpClient.newHttpClient(), messages, false);
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, String model, int maxTokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages, boolean printResponse) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        String fcName = JSONSchemaSerializer.getFunctionName(fcClass);
        return serializedChatCompletion(List.of(fcClass), fcName, model, maxTokens, n, temperature, responseFormatType, apiKey, HttpClient.newHttpClient(), messages, printResponse);
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(List<Class> fcClasses, String fcToCallName, String model, int maxTokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClasses, fcToCallName, model, maxTokens, n, temperature, responseFormatType, apiKey, httpClient, List.of(messages));
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(List<Class> fcClasses, String fcToCallName, String model, int maxTokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, boolean printResponse, OAIChatCompletionRequestMessage... messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClasses, fcToCallName, model, maxTokens, n, temperature, responseFormatType, apiKey, httpClient, List.of(messages), printResponse);
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(List<Class> fcClasses, String fcToCallName, String model, int maxTokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(fcClasses, fcToCallName, model, maxTokens, n, temperature, responseFormatType, apiKey, httpClient, messages, false);
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
    public static OAIGPTChatCompletionResponse serializedChatCompletion(List<Class> fcClasses, String fcToCallName, String model, int maxTokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, String apiKey, HttpClient httpClient, List<OAIChatCompletionRequestMessage> messages, boolean printResponse) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        // Adapt to list of FCBase serializedFCObjects
        List<java.lang.Object> serializedFCObjects = new ArrayList<>();
        for (Class fcClass: fcClasses) {
            serializedFCObjects.add(FCJSONSchemaSerializer.objectify(fcClass));
        }

//        // Create requestFunctionCall
//        OAIChatCompletionRequestFunctionCall requestFunctionCall = new OAIChatCompletionRequestFunctionCall(fcToCallName);

        // Create requestToolChoiceFunction for function requestToolChoice
        OAIChatCompletionRequestToolChoiceFunction.Function requestToolChoiceFunction = new OAIChatCompletionRequestToolChoiceFunction.Function(fcToCallName);

        // Create requestToolChoice as Function tool choice
        Object requestToolChoice = new OAIChatCompletionRequestToolChoiceFunction(requestToolChoiceFunction);

        // Create OAIChatCompletionRequest
        OAIChatCompletionRequest request = OAIChatCompletionRequest.build(
                model,
                maxTokens,
                temperature,
                responseFormatType,
                messages,
                requestToolChoice,
                serializedFCObjects
        );

//        try {
//            System.out.println(new ObjectMapper().writeValueAsString(request));
//        } catch (Exception e) {
//
//        }

//        // Create HttpClient
//        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

        // Execute request and return response
        OAIGPTChatCompletionResponse response = OAIClient.postChatCompletion(
                request,
                apiKey,
                httpClient,
                printResponse
        );

        return response;
    }

}
