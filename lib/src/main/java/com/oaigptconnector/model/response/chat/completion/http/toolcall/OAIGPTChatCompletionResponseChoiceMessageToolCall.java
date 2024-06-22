package com.oaigptconnector.model.response.chat.completion.http.toolcall;

import com.oaigptconnector.model.response.chat.completion.http.toolcall.function.OAIGPTChatCompletionResponseChoiceMessageToolChoiceFunction;

public class OAIGPTChatCompletionResponseChoiceMessageToolCall {

    private String id;
    private String type;
    private OAIGPTChatCompletionResponseChoiceMessageToolChoiceFunction function;

    public OAIGPTChatCompletionResponseChoiceMessageToolCall() {

    }

    public OAIGPTChatCompletionResponseChoiceMessageToolCall(String id, String type, OAIGPTChatCompletionResponseChoiceMessageToolChoiceFunction function) {
        this.id = id;
        this.type = type;
        this.function = function;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public OAIGPTChatCompletionResponseChoiceMessageToolChoiceFunction getFunction() {
        return function;
    }

}
