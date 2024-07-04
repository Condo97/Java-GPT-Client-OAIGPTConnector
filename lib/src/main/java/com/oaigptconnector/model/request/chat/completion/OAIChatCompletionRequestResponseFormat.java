package com.oaigptconnector.model.request.chat.completion;

public class OAIChatCompletionRequestResponseFormat {

    private ResponseFormatType type;

    public OAIChatCompletionRequestResponseFormat() {

    }

    public OAIChatCompletionRequestResponseFormat(ResponseFormatType type) {
        this.type = type;
    }

    public ResponseFormatType getType() {
        return type;
    }

}
