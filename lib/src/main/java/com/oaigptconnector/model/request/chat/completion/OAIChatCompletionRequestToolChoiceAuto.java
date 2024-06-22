package com.oaigptconnector.model.request.chat.completion;

public class OAIChatCompletionRequestToolChoiceAuto implements OAIChatCompletionRequestToolChoice {

    @Override
    public Object tool_choice() {
        return "auto";
    }

}
