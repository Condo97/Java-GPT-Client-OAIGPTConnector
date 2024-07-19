package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequest {
    private String model;
    private Integer max_tokens;
    private Integer n;
    private Double temperature;
    private boolean stream;
    private OAIChatCompletionRequestResponseFormat response_format;
    private OAIChatCompletionRequestStreamOptions stream_options;
    private List<OAIChatCompletionRequestMessage> messages;
    private Object tool_choice; // "none", "required", or OAIChatCompletionRequestToolChoiceFunction
    private List<OAIChatCompletionRequestTool> tools;

    private OAIChatCompletionRequest() {

    }

    private OAIChatCompletionRequest(String model, int max_tokens, int n, double temperature, boolean stream, OAIChatCompletionRequestResponseFormat response_format, OAIChatCompletionRequestStreamOptions stream_options, List<OAIChatCompletionRequestMessage> messages, Object tool_choice, List<OAIChatCompletionRequestTool> tools) {
        this.model = model;
        this.max_tokens = max_tokens;
        this.n = n;
        this.temperature = temperature;
        this.stream = stream;
        this.response_format = response_format;
        this.stream_options = stream_options;
        this.messages = messages;
        this.tool_choice = tool_choice;
        this.tools = tools;
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestMessage... messages) {
        return build(model, max_tokens, temperature, responseFormatType, List.of(messages));
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, temperature, false, responseFormatType, null, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, boolean stream, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestStreamOptions streamOptions, OAIChatCompletionRequestMessage... messages) {
        return build(model, max_tokens, temperature, stream, responseFormatType, streamOptions, List.of(messages));
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, boolean stream, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestStreamOptions streamOptions, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, 1, temperature, stream, responseFormatType, streamOptions, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestStreamOptions streamOptions, OAIChatCompletionRequestMessage... messages) {
        return build(model, max_tokens, n, temperature, responseFormatType, streamOptions, List.of(messages));
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestStreamOptions streamOptions, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, n, temperature, false, responseFormatType, streamOptions, messages);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, boolean stream, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestStreamOptions streamOptions, OAIChatCompletionRequestMessage... messages) {
        return build(model, max_tokens, n, temperature, stream, responseFormatType, streamOptions, List.of(messages));
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, boolean stream, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestStreamOptions streamOptions, List<OAIChatCompletionRequestMessage> messages) {
        return build(model, max_tokens, n, temperature, stream, responseFormatType, streamOptions, messages, null, null);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, List<OAIChatCompletionRequestMessage> messages, Object toolChoice, List<java.lang.Object> functions) {
        return build(model, max_tokens, temperature, false, responseFormatType, null, messages, toolChoice, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, double temperature, boolean stream, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestStreamOptions streamOptions, List<OAIChatCompletionRequestMessage> messages, Object toolChoice, List<java.lang.Object> functions) {
        return build(model, max_tokens, 1, temperature, stream, responseFormatType, streamOptions, messages, toolChoice, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, OAIChatCompletionRequestResponseFormat responseFormatType, List<OAIChatCompletionRequestMessage> messages, Object toolChoice, List<java.lang.Object> functions) {
        return build(model, max_tokens, n, temperature, false, responseFormatType, null, messages, toolChoice, functions);
    }

    public static OAIChatCompletionRequest build(String model, int max_tokens, int n, double temperature, boolean stream, OAIChatCompletionRequestResponseFormat responseFormatType, OAIChatCompletionRequestStreamOptions streamOptions, List<OAIChatCompletionRequestMessage> messages, Object tool_choice, List<java.lang.Object> functions) {
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
                responseFormatType,
                streamOptions,
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

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public OAIChatCompletionRequestResponseFormat getResponse_format() {
        return response_format;
    }

    public void setResponse_format(OAIChatCompletionRequestResponseFormat response_format) {
        this.response_format = response_format;
    }

    public OAIChatCompletionRequestStreamOptions getStream_options() {
        return stream_options;
    }

    public void setStream_options(OAIChatCompletionRequestStreamOptions stream_options) {
        this.stream_options = stream_options;
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

    public Object getTool_choice() {
        return tool_choice;
    }

    public void setTool_choice(Object tool_choice) {
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
