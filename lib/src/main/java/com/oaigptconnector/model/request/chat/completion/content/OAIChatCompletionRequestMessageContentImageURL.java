package com.oaigptconnector.model.request.chat.completion.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.CompletionContentType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequestMessageContentImageURL implements OAIChatCompletionRequestMessageContent {

    private final CompletionContentType type = CompletionContentType.IMAGE_URL;
    private String image_url;

    public OAIChatCompletionRequestMessageContentImageURL() {

    }

    public OAIChatCompletionRequestMessageContentImageURL(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public CompletionContentType getType() {
        return type;
    }

    public String getImage_url() {
        return image_url;
    }


    @Override
    public String toString() {
        return "OAIChatCompletionRequestMessageContentImageURL{" +
                "type=" + type +
                ", image_url='" + image_url + '\'' +
                '}';
    }

}
