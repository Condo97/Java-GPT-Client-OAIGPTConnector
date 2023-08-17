package com.oaigptconnector.model.request.chat.completion.function;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIGPTChatCompletionRequestFunctionParameter {

    private String type;
    private Object properties;

    public OAIGPTChatCompletionRequestFunctionParameter() {

    }

    public OAIGPTChatCompletionRequestFunctionParameter(String type, Object properties) {
        this.type = type;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public Object getProperties() {
        return properties;
    }


    @Override
    public String toString() {
        return "OAIGPTChatCompletionRequestFunctionParameter{" +
                "type='" + type + '\'' +
                ", properties=" + properties +
                '}';
    }

}
