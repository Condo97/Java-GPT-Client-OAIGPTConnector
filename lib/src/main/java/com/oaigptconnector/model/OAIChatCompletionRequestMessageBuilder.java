package com.oaigptconnector.model;

import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequestMessage;
import com.oaigptconnector.model.request.chat.completion.content.OAIChatCompletionRequestMessageContent;
import com.oaigptconnector.model.request.chat.completion.content.OAIChatCompletionRequestMessageContentImage;
import com.oaigptconnector.model.request.chat.completion.content.OAIChatCompletionRequestMessageContentImageURL;
import com.oaigptconnector.model.request.chat.completion.content.OAIChatCompletionRequestMessageContentText;

import java.util.ArrayList;
import java.util.List;

public class OAIChatCompletionRequestMessageBuilder {

    private CompletionRole role;
    private List<OAIChatCompletionRequestMessageContent> content;

    public OAIChatCompletionRequestMessageBuilder(CompletionRole role) {
        this.role = role;

        content = new ArrayList<>();
    }

    public OAIChatCompletionRequestMessageBuilder addText(String text) {
        content.add(new OAIChatCompletionRequestMessageContentText(text));

        return this;
    }

    public OAIChatCompletionRequestMessageBuilder addImage(String base64EncodedImage) {
        content.add(new OAIChatCompletionRequestMessageContentImage(base64EncodedImage));

        return this;
    }

    public OAIChatCompletionRequestMessageBuilder addImageURL(String imageURL) {
        content.add(new OAIChatCompletionRequestMessageContentImageURL(imageURL));

        return this;
    }

    public OAIChatCompletionRequestMessage build() {
        return new OAIChatCompletionRequestMessage(role, content);
    }

}
