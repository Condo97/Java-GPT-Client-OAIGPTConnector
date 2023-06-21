package com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.function.objects;

import java.util.List;

public class OAIGPTChatCompletionRequestFunctionObjectObject implements OAIGPTChatCompletionRequestFunctionObject {

    private final String type = "object";
    private Object properties;
    private String description;
    private List<String> required;

    public OAIGPTChatCompletionRequestFunctionObjectObject() {

    }

    public OAIGPTChatCompletionRequestFunctionObjectObject(Object properties, String description, List<String> required) {
        this.properties = properties;
        this.description = description;
        this.required = required;
    }

    @Override
    public String getType() {
        return type;
    }

    public Object getProperties() {
        return properties;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRequired() {
        return required;
    }

}
