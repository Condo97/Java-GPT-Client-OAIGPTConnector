package com.oaigptconnector.model.request.chat.completion.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.CompletionContentType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequestMessageContentImage implements OAIChatCompletionRequestMessageContent {

    private final CompletionContentType type = CompletionContentType.IMAGE;
    private String image;

    public OAIChatCompletionRequestMessageContentImage() {

    }

    public OAIChatCompletionRequestMessageContentImage(String image) {
        this.image = image;
    }

    @Override
    public CompletionContentType getType() {
        return type;
    }

    public String getImage() {
        return image;
    }


    @Override
    public String toString() {
        return "OAIChatCompletionRequestMessageContentImage{" +
                "type=" + type +
                ", image='" + image + '\'' +
                '}';
    }

}
