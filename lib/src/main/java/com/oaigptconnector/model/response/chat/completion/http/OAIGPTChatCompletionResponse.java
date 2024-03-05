package com.oaigptconnector.model.response.chat.completion.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAIGPTChatCompletionResponse {
    private String id, object, model;
    private Long created;
    private OAIGPTChatCompletionResponseUsage usage;
    private OAIGPTChatCompletionResponseChoice[] choices;

    public OAIGPTChatCompletionResponse() {

    }

    public OAIGPTChatCompletionResponse(String id, String object, String model, Long created, OAIGPTChatCompletionResponseUsage usage, OAIGPTChatCompletionResponseChoice[] choices) {
        this.id = id;
        this.object = object;
        this.model = model;
        this.created = created;
        this.usage = usage;
        this.choices = choices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public OAIGPTChatCompletionResponseUsage getUsage() {
        return usage;
    }

    public void setUsage(OAIGPTChatCompletionResponseUsage usage) {
        this.usage = usage;
    }

    public OAIGPTChatCompletionResponseChoice[] getChoices() {
        return choices;
    }

    public void setChoices(OAIGPTChatCompletionResponseChoice[] choices) {
        this.choices = choices;
    }


    @Override
    public String toString() {
        return "OAIGPTChatCompletionResponse{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", model='" + model + '\'' +
                ", created=" + created +
                ", usage=" + usage +
                ", choices=" + Arrays.toString(choices) +
                '}';
    }

}
