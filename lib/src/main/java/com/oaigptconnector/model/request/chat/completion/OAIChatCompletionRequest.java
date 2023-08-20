package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequest {
    private String model;
    private int max_tokens;
    private int n;
    private double temperature;
    private boolean stream;
    private List<OAIChatCompletionRequestMessage> messages;
    private OAIChatCompletionRequestFunctionCall function_call;
    private List<Object> functions;

    private OAIChatCompletionRequest() {

    }

    private OAIChatCompletionRequest(String model, int max_tokens, int n, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestFunctionCall function_call, List<Object> functions) {
        this.model = model;
        this.max_tokens = max_tokens;
        this.n = n;
        this.temperature = temperature;
        this.stream = stream;
        this.messages = messages;
        this.function_call = function_call;
        this.functions = functions;
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, temperature, false, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, 1, temperature, stream, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, n, temperature, false, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, n, temperature, stream, messages, null, null);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestFunctionCall function_call, List<Object> functions) {
        return build(model, max_tokens, temperature, false, messages, function_call, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestFunctionCall functionCall, List<Object> functions) {
        return build(model, max_tokens, 1, temperature, stream, messages, functionCall, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestFunctionCall functionCall, List<Object> functions) {
        return build(model, max_tokens, n, temperature, false, messages, functionCall, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestFunctionCall function_call, List<Object> functions) {
        return new OAIChatCompletionRequest(
                model,
                max_tokens,
                n,
                temperature,
                stream,
                messages,
                function_call,
                functions
        );
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

    public List<OAIChatCompletionRequestMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<OAIChatCompletionRequestMessage> messages) {
        this.messages = messages;
    }

    public OAIChatCompletionRequestFunctionCall getFunction_call() {
        return function_call;
    }

    public void setFunction_call(OAIChatCompletionRequestFunctionCall function_call) {
        this.function_call = function_call;
    }

    public List<Object> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Object> functions) {
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
