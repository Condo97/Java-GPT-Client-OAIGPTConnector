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
    private OAIChatCompletionRequestToolChoice tool_choice; // "none", "required", or OAIChatCompletionRequestToolChoiceFunction
    private List<OAIChatCompletionRequestTool> tools;

    private OAIChatCompletionRequest() {

    }

    private OAIChatCompletionRequest(String model, int max_tokens, int n, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestToolChoice tool_choice, List<OAIChatCompletionRequestTool> tools) {
        this.model = model;
        this.max_tokens = max_tokens;
        this.n = n;
        this.temperature = temperature;
        this.stream = stream;
        this.messages = messages;
        this.tool_choice = tool_choice;
        this.tools = tools;
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, OAIChatCompletionRequestMessage... messages) {
        return build(model, max_tokens, temperature, List.of(messages));
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, temperature, false, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, boolean stream, OAIChatCompletionRequestMessage... messages) {
        return build(model, max_tokens, temperature, stream, List.of(messages));
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, 1, temperature, stream, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, OAIChatCompletionRequestMessage... messages) {
        return build(model, max_tokens, n, temperature, List.of(messages));
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, n, temperature, false, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, boolean stream, OAIChatCompletionRequestMessage... messages) {
        return build(model, max_tokens, n, temperature, stream, List.of(messages));
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, n, temperature, stream, messages, null, null);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestToolChoice toolChoice, List<Object> functions) {
        return build(model, max_tokens, temperature, false, messages, toolChoice, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestToolChoice toolChoice, List<Object> functions) {
        return build(model, max_tokens, 1, temperature, stream, messages, toolChoice, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestToolChoice toolChoice, List<Object> functions) {
        return build(model, max_tokens, n, temperature, false, messages, toolChoice, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, boolean stream, List<OAIChatCompletionRequestMessage> messages, OAIChatCompletionRequestToolChoice tool_choice, List<Object> functions) {
        // TODO: Implement tools better.. right now it just translates functions to tools
        List<OAIChatCompletionRequestTool> tools = null;

        if (functions != null && !functions.isEmpty()) {
            tools = functions.stream()
                    .map(f -> new OAIChatCompletionRequestTool(
                            OAIChatCompletionRequestToolType.FUNCTION,
                            f
                    ))
                    .toList();
        }

        return new OAIChatCompletionRequest(
                model,
                max_tokens,
                n,
                temperature,
                stream,
                messages,
                tool_choice,
                tools
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

    public OAIChatCompletionRequestToolChoice getTool_choice() {
        return tool_choice;
    }

    public void setTool_choice(OAIChatCompletionRequestToolChoice tool_choice) {
        this.tool_choice = tool_choice;
    }

    public List<OAIChatCompletionRequestTool> getTools() {
        return tools;
    }

    public void setTools(List<OAIChatCompletionRequestTool> tools) {
        this.tools = tools;
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
                ", tool_choice=" + tool_choice +
                ", tools=" + tools +
                '}';
    }

}
