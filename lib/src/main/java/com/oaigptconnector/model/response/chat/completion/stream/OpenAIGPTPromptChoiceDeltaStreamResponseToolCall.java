package com.oaigptconnector.model.response.chat.completion.stream;

public class OpenAIGPTPromptChoiceDeltaStreamResponseToolCall {

    private Integer index;
    private OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction function;

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCall() {

    }

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCall(Integer index, OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction function) {
        this.index = index;
        this.function = function;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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
                ", function=" + function +
                '}';
    }

}
