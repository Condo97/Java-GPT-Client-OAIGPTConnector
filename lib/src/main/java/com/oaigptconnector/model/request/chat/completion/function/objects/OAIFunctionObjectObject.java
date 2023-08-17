package com.oaigptconnector.model.request.chat.completion.function.objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIFunctionObjectObject implements OAIFunctionObject {

    private final String type = "object";
    private Object properties;
    private String description;
    private List<String> required;

    public OAIFunctionObjectObject() {

    }

    public OAIFunctionObjectObject(Object properties, String description, List<String> required) {
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


    @Override
    public String toString() {
        return "OAIGPTChatCompletionRequestFunctionObjectObject{" +
                "type='" + type + '\'' +
                ", properties=" + properties +
                ", description='" + description + '\'' +
                ", required=" + required +
                '}';
    }

}
