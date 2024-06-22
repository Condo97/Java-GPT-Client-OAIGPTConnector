package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequestTool {

    private OAIChatCompletionRequestToolType type;
    private Object function;

    public OAIChatCompletionRequestTool() {

    }

    public OAIChatCompletionRequestTool(OAIChatCompletionRequestToolType type, Object function) {
        this.type = type;
        this.function = function;
    }

    public OAIChatCompletionRequestToolType getType() {
        return type;
    }

    public Object getFunction() {
        return function;
    }

}
