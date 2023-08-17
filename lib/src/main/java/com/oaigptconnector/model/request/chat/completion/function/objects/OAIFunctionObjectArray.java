package com.oaigptconnector.model.request.chat.completion.function.objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIFunctionObjectArray implements OAIFunctionObject {

    private final String type = "array";
    private String description;
    private OAIFunctionObject items;

    public OAIFunctionObjectArray() {

    }

    public OAIFunctionObjectArray(String description, OAIFunctionObject items) {
        this.description = description;
        this.items = items;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public OAIFunctionObject getItems() {
        return items;
    }


    @Override
    public String toString() {
        return "OAIGPTChatCompletionRequestFunctionObjectArray{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }

}
