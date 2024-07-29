package com.oaigptconnector.model.response.chat.completion.stream;

public class OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction {

    private String arguments;

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction() {

    }

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction(String arguments) {
        this.arguments = arguments;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction{" +
                "arguments='" + arguments + '\'' +
                '}';
    }

}
