package com.oaigptconnector.model.response.chat.completion.stream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenAIGPTPromptChoiceDeltaStreamResponse {

    private String role, content;
    private List<OpenAIGPTPromptChoiceDeltaStreamResponseToolCall> tool_calls;

    public OpenAIGPTPromptChoiceDeltaStreamResponse() {

    }

    public OpenAIGPTPromptChoiceDeltaStreamResponse(String role, String content, List<OpenAIGPTPromptChoiceDeltaStreamResponseToolCall> tool_calls) {
        this.role = role;
        this.content = content;
        this.tool_calls = tool_calls;
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

    public List<OpenAIGPTPromptChoiceDeltaStreamResponseToolCall> getTool_calls() {
        return tool_calls;
    }

    public void setTool_calls(List<OpenAIGPTPromptChoiceDeltaStreamResponseToolCall> tool_calls) {
        this.tool_calls = tool_calls;
    }

    @Override
    public String toString() {
        return "OpenAIGPTPromptChoiceDeltaStreamResponse{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                ", tool_calls=" + tool_calls +
                '}';
    }

}
