package com.oaigptconnector.model;

import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequestMessage;

import java.util.ArrayList;
import java.util.List;

public class OAIChatCompletionRequestMessagesBuilder {

    private List<OAIChatCompletionRequestMessage> messages;

    public OAIChatCompletionRequestMessagesBuilder() {
        messages = new ArrayList<>();
    }

    public OAIChatCompletionRequestMessagesBuilder addAssistant(String message) {
        messages.add(new OAIChatCompletionRequestMessage(Role.ASSISTANT, message));

        return this;
    }

    public OAIChatCompletionRequestMessagesBuilder addSystem(String message) {
        messages.add(new OAIChatCompletionRequestMessage(Role.SYSTEM, message));

        return this;
    }

    public OAIChatCompletionRequestMessagesBuilder addUser(String message) {
        messages.add(new OAIChatCompletionRequestMessage(Role.USER, message));

        return this;
    }

    public List<OAIChatCompletionRequestMessage> build() {
        return messages;
    }

}
