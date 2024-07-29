package com.oaigptconnector.model.response.chat.completion.stream;

public class OpenAIGPTPromptChoiceDeltaStreamResponseToolCall {

    private Integer index;
    private String id;
    private String type;
    private OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction function;

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCall() {

    }

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCall(Integer index, String id, String type, OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction function) {
        this.index = index;
        this.id = id;
        this.type = type;
        this.function = function;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction getFunction() {
        return function;
    }

    public void setFunction(OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "OpenAIGPTPromptChoiceDeltaStreamResponseToolCall{" +
                "index=" + index +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", function=" + function +
                '}';
    }

}
