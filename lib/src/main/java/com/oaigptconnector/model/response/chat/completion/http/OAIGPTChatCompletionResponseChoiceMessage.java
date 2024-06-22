package com.oaigptconnector.model.response.chat.completion.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oaigptconnector.model.response.chat.completion.http.toolcall.OAIGPTChatCompletionResponseChoiceMessageToolCall;
import com.oaigptconnector.model.response.chat.completion.http.toolcall.function.OAIGPTChatCompletionResponseChoiceMessageToolChoiceFunction;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAIGPTChatCompletionResponseChoiceMessage {
    private String role, content;
    private List<OAIGPTChatCompletionResponseChoiceMessageToolCall> tool_calls;

    public OAIGPTChatCompletionResponseChoiceMessage() {

    }

    public OAIGPTChatCompletionResponseChoiceMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public OAIGPTChatCompletionResponseChoiceMessage(String role, String content, List<OAIGPTChatCompletionResponseChoiceMessageToolCall> tool_calls) {
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

    public List<OAIGPTChatCompletionResponseChoiceMessageToolCall> getTool_calls() {
        return tool_calls;
    }

    public void setTool_calls(List<OAIGPTChatCompletionResponseChoiceMessageToolCall> tool_calls) {
        this.tool_calls = tool_calls;
    }

    @Override
    public String toString() {
        return "OAIGPTChatCompletionResponseChoiceMessage{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                ", tool_calls=" + tool_calls +
                '}';
    }

}
