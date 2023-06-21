package com.oaigptconnector.model.http.client.openaigpt.response.chat.completion.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oaigptconnector.model.http.client.openaigpt.response.chat.completion.http.function.OAIGPTChatCompletionResponseChoiceMessageFunctionCall;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAIGPTChatCompletionResponseChoiceMessage {
    private String role, content;
    private OAIGPTChatCompletionResponseChoiceMessageFunctionCall function_call;

    public OAIGPTChatCompletionResponseChoiceMessage() {

    }

    public OAIGPTChatCompletionResponseChoiceMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public OAIGPTChatCompletionResponseChoiceMessage(String role, String content, OAIGPTChatCompletionResponseChoiceMessageFunctionCall function_call) {
        this.role = role;
        this.content = content;
        this.function_call = function_call;
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

    public OAIGPTChatCompletionResponseChoiceMessageFunctionCall getFunction_call() {
        return function_call;
    }

    public void setFunction_call(OAIGPTChatCompletionResponseChoiceMessageFunctionCall function_call) {
        this.function_call = function_call;
    }

    @Override
    public String toString() {
        return "OpenAIGPTPromptChoiceMessageResponse{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
