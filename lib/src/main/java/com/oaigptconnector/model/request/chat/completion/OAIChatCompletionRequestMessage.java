package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.CompletionRole;
import com.oaigptconnector.model.request.chat.completion.content.OAIChatCompletionRequestMessageContent;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequestMessage {

    private CompletionRole role;
    private List<OAIChatCompletionRequestMessageContent> content;

    public OAIChatCompletionRequestMessage(CompletionRole role, List<OAIChatCompletionRequestMessageContent> content) {
        this.role = role;
        this.content = content;
    }

    public CompletionRole getRole() {
        return role;
    }

    public void setRole(CompletionRole role) {
        this.role = role;
    }

    public List<OAIChatCompletionRequestMessageContent> getContent() {
        return content;
    }

    public void setContent(List<OAIChatCompletionRequestMessageContent> content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "OAIGPTChatCompletionRequestMessage{" +
                "role=" + role +
                ", content='" + content + '\'' +
                '}';
    }

}
