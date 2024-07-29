package com.oaigptconnector.model.response.chat.completion.stream;

public class OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction {

    private String name;
    private String arguments;

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction() {

    }

    public OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction(String name, String arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OpenAIGPTPromptChoiceDeltaStreamResponseToolCallFunction{" +
                "name='" + name + '\'' +
                ", arguments='" + arguments + '\'' +
                '}';
    }

}
