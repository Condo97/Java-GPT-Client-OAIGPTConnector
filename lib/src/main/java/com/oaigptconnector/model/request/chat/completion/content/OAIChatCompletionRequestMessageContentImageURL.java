package com.oaigptconnector.model.request.chat.completion.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAIChatCompletionRequestMessageContentImageURL implements OAIChatCompletionRequestMessageContent {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
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

//    private final CompletionContentType type = CompletionContentType.IMAGE_URL;
    private ImageURL image_url;

    public OAIChatCompletionRequestMessageContentImageURL() {

    }

    public OAIChatCompletionRequestMessageContentImageURL(ImageURL image_url) {
        this.image_url = image_url;
    }

//    @Override
//    public CompletionContentType getType() {
//        return type;
//    }

    public ImageURL getImage_url() {
        return image_url;
    }

    @Override
    public String toString() {
        return "OAIChatCompletionRequestMessageContentImage{" +
//                "type=" + type +
                ", image='" + image_url + '\'' +
                '}';
    }

}
