package com.oaigptconnector.model.request.chat.completion.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.CompletionContentType;
import com.oaigptconnector.model.InputImageDetail;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIChatCompletionRequestMessageContentImage implements OAIChatCompletionRequestMessageContent {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ImageURL {

        private String url;
        private InputImageDetail detail;

        public ImageURL() {

        }

        public ImageURL(String url, InputImageDetail detail) {
            this.url = url;
            this.detail = detail;
        }

        public String getUrl() {
            return url;
        }

        public InputImageDetail getDetail() {
            return detail;
        }

        @Override
        public String toString() {
            return "ImageURL{" +
                    "url='" + url + '\'' +
                    ", detail=" + detail +
                    '}';
        }

    }

    private final CompletionContentType type = CompletionContentType.IMAGE;
    private ImageURL image_url;

    public OAIChatCompletionRequestMessageContentImage() {

    }

    public OAIChatCompletionRequestMessageContentImage(ImageURL image_url) {
        this.image_url = image_url;
    }

    @Override
    public CompletionContentType getType() {
        return type;
    }

    public ImageURL getImage_url() {
        return image_url;
    }

    @Override
    public String toString() {
        return "OAIChatCompletionRequestMessageContentImage{" +
                "type=" + type +
                ", image='" + image_url + '\'' +
                '}';
    }

}
