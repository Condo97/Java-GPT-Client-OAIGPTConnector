package com.oaigptconnector.model.request.chat.completion;

public class OAIChatCompletionRequestToolChoiceRequired implements OAIChatCompletionRequestToolChoice {

    @Override
    public Object tool_choice() {
        return "required";
    }

}
