package com.oaigptconnector.model.request.chat.completion;

public class OAIChatCompletionRequestToolChoiceNone implements OAIChatCompletionRequestToolChoice {

    @Override
    public Object tool_choice() {
        return "none";
    }

}
