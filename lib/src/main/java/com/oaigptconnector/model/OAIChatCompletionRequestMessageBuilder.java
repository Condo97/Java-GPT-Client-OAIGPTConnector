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
        // Null check
        if (text == null) return this;

        // Add text
        content.add(new OAIChatCompletionRequestMessageContentText(text));

        return this;
    }

    public OAIChatCompletionRequestMessageBuilder addImage(String base64EncodedImage, InputImageDetail detail) {
        // Null check
        if (base64EncodedImage == null) return this;

        // Create contentImageURL child with base64EncodedImage and detail
        OAIChatCompletionRequestMessageContentImage.ImageURL contentImageURL = new OAIChatCompletionRequestMessageContentImage.ImageURL(
                base64EncodedImage,
                detail
        );

        // Add imageURL in image request parent
        content.add(new OAIChatCompletionRequestMessageContentImage(contentImageURL));

        return this;
    }

    public OAIChatCompletionRequestMessageBuilder addImageURL(String imageURL, InputImageDetail detail) {
        // Null check
        if (imageURL == null || detail == null) return this;

        // Create contentImageURL child with imageURL and detail
        OAIChatCompletionRequestMessageContentImage.ImageURL contentImageURL = new OAIChatCompletionRequestMessageContentImage.ImageURL(
                imageURL,
                detail
        );
        content.add(new OAIChatCompletionRequestMessageContentImage(contentImageURL));

        return this;
    }

    public OAIChatCompletionRequestMessage build() {
        return new OAIChatCompletionRequestMessage(role, content);
    }

}
