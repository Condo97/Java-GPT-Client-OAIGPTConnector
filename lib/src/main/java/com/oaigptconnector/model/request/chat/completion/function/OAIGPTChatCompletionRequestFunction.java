package com.oaigptconnector.model.request.chat.completion.function;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.request.chat.completion.function.objects.OAIFunctionObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIGPTChatCompletionRequestFunction {

    private String name;
    private String description;
    private OAIFunctionObject parameters;

    public OAIGPTChatCompletionRequestFunction() {

    }

    public OAIGPTChatCompletionRequestFunction(String name, String description, OAIFunctionObject parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OAIFunctionObject getParameters() {
        return parameters;
    }


    @Override
    public String toString() {
        return "OAIGPTChatCompletionRequestFunction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parameters=" + parameters +
                '}';
    }

}
