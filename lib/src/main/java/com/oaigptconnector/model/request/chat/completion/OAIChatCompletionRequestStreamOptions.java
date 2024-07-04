package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequestStreamOptions {

    private Boolean include_usage;

    public OAIChatCompletionRequestStreamOptions() {

    }

    public OAIChatCompletionRequestStreamOptions(Boolean include_usage) {
        this.include_usage = include_usage;
    }

    public Boolean getInclude_usage() {
        return include_usage;
    }

}
