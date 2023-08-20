package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.request.chat.completion.function.OAIGPTChatCompletionRequestFunction;
import com.oaigptconnector.model.request.chat.completion.function.OAIGPTChatCompletionRequestFunctionCall;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequest {
    private String model;
    private int max_tokens;
    private int n;
    private double temperature;
    private boolean stream;
    private List<OAIGPTChatCompletionRequestMessage> messages;
    private OAIGPTChatCompletionRequestFunctionCall function_call;
    private List<OAIGPTChatCompletionRequestFunction> functions;

    public OAIChatCompletionRequest() {

    }

    public OAIChatCompletionRequest(String model, int max_tokens, double temperature, List<OAIGPTChatCompletionRequestMessage> messages) {
        this.model = model;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
        this.messages = messages;

        this.stream = false;
        this.n = 1;
    }

    public OAIChatCompletionRequest(String model, int max_tokens, double temperature, boolean stream, List<OAIGPTChatCompletionRequestMessage> messages) {
        this.model = model;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
        this.stream = stream;
        this.messages = messages;

        this.n = 1;
    }

    public OAIChatCompletionRequest(String model, int max_tokens, double temperature, boolean stream, List<OAIGPTChatCompletionRequestMessage> messages, OAIGPTChatCompletionRequestFunctionCall function_call, List<OAIGPTChatCompletionRequestFunction> functions) {
        this.model = model;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
        this.stream = stream;
        this.messages = messages;
        this.function_call = function_call;
        this.functions = functions;

        this.n = 1;
    }

    public OAIChatCompletionRequest(String model, int max_tokens, int n, double temperature, boolean stream, List<OAIGPTChatCompletionRequestMessage> messages, OAIGPTChatCompletionRequestFunctionCall function_call, List<OAIGPTChatCompletionRequestFunction> functions) {
        this.model = model;
        this.max_tokens = max_tokens;
        this.n = n;
        this.temperature = temperature;
        this.stream = stream;
        this.messages = messages;
        this.function_call = function_call;
        this.functions = functions;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public List<OAIGPTChatCompletionRequestMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<OAIGPTChatCompletionRequestMessage> messages) {
        this.messages = messages;
    }

    public OAIGPTChatCompletionRequestFunctionCall getFunction_call() {
        return function_call;
    }

    public void setFunction_call(OAIGPTChatCompletionRequestFunctionCall function_call) {
        this.function_call = function_call;
    }

    public List<OAIGPTChatCompletionRequestFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<OAIGPTChatCompletionRequestFunction> functions) {
        this.functions = functions;
    }


    @Override
    public String toString() {
        return "OAIGPTChatCompletionRequest{" +
                "model='" + model + '\'' +
                ", max_tokens=" + max_tokens +
                ", n=" + n +
                ", temperature=" + temperature +
                ", stream=" + stream +
                ", messages=" + messages +
                ", function_call=" + function_call +
                ", functions=" + functions +
                '}';
    }

}
