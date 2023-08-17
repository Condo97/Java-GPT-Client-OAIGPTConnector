package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.Role;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIGPTChatCompletionRequestMessage {

    private Role role;
    private String content;

    public OAIGPTChatCompletionRequestMessage(Role role, String content) {
        this.role = role;
        this.content = content;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
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
