package com.oaigptconnector.model.response.chat.completion.stream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenAIGPTPromptChoiceDeltaStreamResponse {
    private String role, content;

    public OpenAIGPTPromptChoiceDeltaStreamResponse() {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
        return "OpenAIGPTPromptChoiceDeltaStreamResponse{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
