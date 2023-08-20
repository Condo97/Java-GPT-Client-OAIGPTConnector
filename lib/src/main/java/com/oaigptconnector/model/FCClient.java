package com.oaigptconnector.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequest;
import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequestFunctionCall;
import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequestMessage;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FCClient {

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, List<OAIChatCompletionRequestMessage> messages, String model, int maxTokens, double temperature, String apiKey) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        return serializedChatCompletion(
                fcClass,
                messages,
                model,
                maxTokens,
                1,
                temperature,
                apiKey
        );
    }

    public static OAIGPTChatCompletionResponse serializedChatCompletion(Class fcClass, List<OAIChatCompletionRequestMessage> messages, String model, int maxTokens, int n, double temperature, String apiKey) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        // Get the function call name from fcClass using OAIFunctionCallSerializer
        String fcName = OAIFunctionCallSerializer.getFunctionName(fcClass);

        return serializedChatCompletion(
                List.of(fcClass),
                fcName,
                messages,
                model,
                maxTokens,
                n,
                temperature,
                apiKey
        );
    }


    /***
     * Takes an annotated FunctionCall class list and name of function call to call, serializes it, calls OAIClient to get response, and deserializes response setting fcObject fields
     *
     * @param fcClasses
     * @param fcToCallName
     * @param messages
     * @param model
     * @param maxTokens
     * @param n
     * @param temperature
     * @param apiKey
     * @return
     * @throws OAISerializerException
     * @throws OpenAIGPTException
     * @throws IOException
     * @throws InterruptedException
     */
    public static OAIGPTChatCompletionResponse serializedChatCompletion(List<Class> fcClasses, String fcToCallName, List<OAIChatCompletionRequestMessage> messages, String model, int maxTokens, int n, double temperature, String apiKey) throws OAISerializerException, OpenAIGPTException, IOException, InterruptedException {
        // Adapt to list of FCBase serializedFCObjects
        List<Object> serializedFCObjects = new ArrayList<>();
        for (Class fcClass: fcClasses) {
            serializedFCObjects.add(OAIFunctionCallSerializer.objectify(fcClass));
        }

        // Create requestFunctionCall
        OAIChatCompletionRequestFunctionCall requestFunctionCall = new OAIChatCompletionRequestFunctionCall(fcToCallName);

        // Create OAIChatCompletionRequest
        OAIChatCompletionRequest request = OAIChatCompletionRequest.build(
                model,
                maxTokens,
                temperature,
                messages,
                requestFunctionCall,
                serializedFCObjects
        );

        // Execute request and return response
        OAIGPTChatCompletionResponse response = OAIClient.postChatCompletion(
                request,
                apiKey
        );

        return response;
    }

}
