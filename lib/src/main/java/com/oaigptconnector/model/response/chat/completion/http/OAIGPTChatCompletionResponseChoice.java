package com.oaigptconnector.model.response.chat.completion.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAIGPTChatCompletionResponseChoice {
    private String finish_reason;
    private Integer index;
    private OAIGPTChatCompletionResponseChoiceMessage message;

    public OAIGPTChatCompletionResponseChoice() {

    }
    public OAIGPTChatCompletionResponseChoice(String finish_reason, Integer index, OAIGPTChatCompletionResponseChoiceMessage message) {
        this.finish_reason = finish_reason;
        this.index = index;
        this.message = message;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public OAIGPTChatCompletionResponseChoiceMessage getMessage() {
        return message;
    }

    public void setMessage(OAIGPTChatCompletionResponseChoiceMessage message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "OAIGPTChatCompletionResponseChoice{" +
                "finish_reason='" + finish_reason + '\'' +
                ", index=" + index +
                ", message=" + message +
                '}';
    }

}
