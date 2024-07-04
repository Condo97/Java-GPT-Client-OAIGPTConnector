package com.oaigptconnector.model.request.chat.completion.content;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oaigptconnector.model.CompletionContentType;


// Serializing interfaces with Jackson: https://stackoverflow.com/questions/19379863/how-to-deserialize-interface-fields-using-jacksons-objectmapper
// https://github.com/FasterXML/jackson-docs/wiki/JacksonPolymorphicDeserialization
// https://web.archive.org/web/20200623023452/https://programmerbruce.blogspot.com/2011/05/deserialize-json-with-jackson-into.html
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OAIChatCompletionRequestMessageContentText.class, name = "text"),
        @JsonSubTypes.Type(value = OAIChatCompletionRequestMessageContentImageURL.class, name = "image_url") })
public interface OAIChatCompletionRequestMessageContent {

//    CompletionContentType getType(); TODO: Type is handled by JsonTypeInfo instead for both deserialization and serialization :)

}
