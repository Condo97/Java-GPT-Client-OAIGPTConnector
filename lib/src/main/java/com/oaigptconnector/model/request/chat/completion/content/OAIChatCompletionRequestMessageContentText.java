package com.oaigptconnector.model.request.chat.completion.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.CompletionContentType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAIChatCompletionRequestMessageContentText implements OAIChatCompletionRequestMessageContent {

//    private final CompletionContentType type = CompletionContentType.TEXT;
    private String text;

    public OAIChatCompletionRequestMessageContentText() {

    }

    public OAIChatCompletionRequestMessageContentText(String text) {
        this.text = text;
    }

//    @Override
//    public CompletionContentType getType() {
//        return type;
//    }

    public String getText() {
        return text;
    }


    @Override
    public String toString() {
        return "OAIChatCompletionRequestMessageContentText{" +
//                "type=" + type +
                ", text='" + text + '\'' +
                '}';
    }

}
