package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequestResponseFormat {

    private ResponseFormatType type;
    private Object json_schema;

    public OAIChatCompletionRequestResponseFormat() {

    }

    public OAIChatCompletionRequestResponseFormat(ResponseFormatType type) {
        this.type = type;
    }

    public OAIChatCompletionRequestResponseFormat(ResponseFormatType type, Object json_schema) {
        this.type = type;
        this.json_schema = json_schema;
    }

    public ResponseFormatType getType() {
        return type;
    }

    public Object getJson_schema() {
        return json_schema;
    }

}
